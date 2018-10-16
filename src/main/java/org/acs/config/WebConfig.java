package org.acs.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author GenCloud
 * @date 10/2018
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.acs.domain.repository")
@EntityScan(basePackages = "org.acs.domain.model")
@EnableTransactionManagement
@EnableScheduling
@EnableCaching
@EnableWebMvc
@PropertySource(value = "file:./application.properties", ignoreResourceNotFound = true)
@PropertySource(value = "file:./public/application.properties", ignoreResourceNotFound = true)
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Add handlers to serve static resources such as images, js, and, css
	 * files from specific locations under web application root, the classpath, and others.
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		final String currentPath = new File(".").getAbsolutePath();
		final String location = "file:///" + currentPath + "/public/";
		registry.addResourceHandler("/**").addResourceLocations(location);
	}

	/**
	 * Add resolvers to support custom controller method argument types.
	 * <p>This does not override the built-in support for resolving handler
	 * method arguments. To customize the built-in support for argument
	 * resolution, configure {@link RequestMappingHandlerAdapter} directly.
	 *
	 * @param argumentResolvers initially an empty list
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		final PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setFallbackPageable(new PageRequest(0, 8));
		argumentResolvers.add(resolver);
		super.addArgumentResolvers(argumentResolvers);
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		final StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		return converter;
	}
}
