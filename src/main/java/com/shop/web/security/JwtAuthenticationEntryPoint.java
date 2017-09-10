package com.shop.web.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = 6616051157378312121L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		/*
		 * This is invoked when user tries to access a secured REST resource
		 * without supplying any credentials We should just send a 401
		 * Unauthorized response because there is no 'login page' to redirect to
		 */
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}