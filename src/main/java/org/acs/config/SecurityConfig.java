package org.acs.config;

import lombok.extern.slf4j.Slf4j;
import org.acs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

import static org.acs.util.SiteUtil.getBaseURl;

/**
 * @author GenCloud
 * @date 10/2018
 */
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final AccountService accountService;

	@Autowired
	public SecurityConfig(AccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountService::loadUserByUsername)
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
				authorizeRequests().
				antMatchers("/", "/error", "/error403", "/error405").permitAll().
				antMatchers("/**/css/**", "/**/fonts/**", "/**/fontawesome/**",
						"/**/js/**", "/**/images/**", "/**/video/**").permitAll().
				antMatchers("/image/**", "/auth/**", "/api/**").permitAll().
				antMatchers("/admin/**").hasRole("ADMIN").
				anyRequest().authenticated().and().
				csrf().
				disable().
				sessionManagement().
				maximumSessions(1).
				maxSessionsPreventsLogin(false).
				expiredUrl("/auth").
				sessionRegistry(sessionRegistry());
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public Filter corsFilter() {
		return new CorsFilter();
	}

	@Bean
	public Filter csrfFilter() {
		return new StatelessCSRFFilter();
	}

	@Bean
	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
		return new OpenEntityManagerInViewFilter();
	}

	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Slf4j
	public static class StatelessCSRFFilter extends OncePerRequestFilter {
		static final String X_CSRF_TOKEN_HEADER = "X-CSRF-TOKEN";
		static final String CSRF_TOKEN_COOKIE = "CSRF-TOKEN";
		private static final int EXPIRE = 0;
		private final RequestMatcher requireCsrfProtectionMatcher = new DefaultRequiresCsrfMatcher();
		private final AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {

			if (requireCsrfProtectionMatcher.matches(request)) {
				final String csrfTokenValue = request.getHeader(X_CSRF_TOKEN_HEADER);
				final Cookie[] cookies = request.getCookies();

				String csrfCookieValue = null;
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals(CSRF_TOKEN_COOKIE)) {
							csrfCookieValue = cookie.getValue();
						}
					}
				}

				if (csrfTokenValue == null || !csrfTokenValue.equals(csrfCookieValue)) {
					accessDeniedHandler.handle(request, response, new AccessDeniedException("Missing or non-matching CSRF-token"));
					log.warn("Missing/bad CSRF-TOKEN while CSRF is enabled for request {}", request.getRequestURI());
					return;
				}
			}

			invalidate(response);
			filterChain.doFilter(request, response);
		}

		private void invalidate(HttpServletResponse response) {
			Cookie cookie = new Cookie(CSRF_TOKEN_COOKIE, "");
			cookie.setMaxAge(EXPIRE);
			response.addCookie(cookie);
		}

		public class DefaultRequiresCsrfMatcher implements RequestMatcher {
			private final Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

			@Override
			public boolean matches(HttpServletRequest request) {
				return !allowedMethods.matcher(request.getMethod()).matches();
			}
		}
	}

	public static class CorsFilter extends OncePerRequestFilter {
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
			response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, getBaseURl(request));
			response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

			if (request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD) != null && HttpMethod.OPTIONS.name().equals(request.getMethod())) {
				// CORS "pre-flight" request
				response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE");
				response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.CONTENT_TYPE + ", " + StatelessCSRFFilter.X_CSRF_TOKEN_HEADER);
				response.addHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "1");
			}

			filterChain.doFilter(request, response);
		}
	}
}
