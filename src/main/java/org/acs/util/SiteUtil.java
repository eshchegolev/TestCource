package org.acs.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GenCloud
 * @date 10/2018
 */
public class SiteUtil {
	public static String getBaseURl(HttpServletRequest request) {
		final String scheme = request.getScheme();
		final String serverName = request.getServerName();
		final int serverPort = request.getServerPort();
		final String contextPath = request.getContextPath();
		final StringBuilder url = new StringBuilder();
		url.append(scheme).append("://").append(serverName);

		if (serverPort != 80 && serverPort != 443 && serverPort != 8080 && serverPort != 8443) {
			url.append(":").append(serverPort);
		}

		url.append(contextPath);

		if (url.toString().endsWith("/")) {
			url.append("/");
		}

		return url.toString();
	}
}
