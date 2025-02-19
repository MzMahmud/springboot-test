package com.moazmahmud.springboot.test;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Extract client information
        String clientIp = httpRequest.getRemoteAddr();
        String userAgent = httpRequest.getHeader("User-Agent");

        // Log request details with client info
        logger.info("Request: Method={}, URI={}, Client IP={}, User Agent={}, Parameters={}, Headers={}",
                httpRequest.getMethod(),
                httpRequest.getRequestURI(),
                clientIp,
                userAgent,
                httpRequest.getParameterMap(),
                httpRequest.getHeaderNames()
        );

        // Proceed with the request
        chain.doFilter(request, response);
    }
}