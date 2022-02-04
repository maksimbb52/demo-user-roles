/*
 * Copyright 2020 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package com.example.crudtoboot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

/**
 * Request logging filter.
 * Класс, который скинул Макс, позволяет отслеживать дебажить и смотреть содержимое запроса (в данном проекте не нужен)
 */
@Slf4j
@Component
public class RequestLoggingFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain filterChain) throws ServletException, IOException {
        if (log.isDebugEnabled() && req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            final StringBuilder requestAsString = new StringBuilder("REQUEST: ");
            requestAsString.append("\n\tProtocol: ").append(request.getProtocol());
            requestAsString.append("\n\tMethod: ").append(request.getMethod());
            requestAsString.append("\n\tPath: ").append(request.getRequestURI());
            if (StringUtils.isNotBlank(request.getQueryString())) {
                requestAsString.append("\n\tQuery string: ").append(request.getQueryString());
            }
            if (StringUtils.isNotBlank(request.getRemoteUser())) {
                requestAsString.append("\n\tRemote user: ").append(request.getRemoteUser());
            }
            requestAsString.append("\n\tRemote address: ").append(request.getRemoteAddr());
            requestAsString.append("\n\tRemote host: ").append(request.getRemoteHost());
            requestAsString.append("\n\tHttp session id: ").append(request.getRequestedSessionId());
            requestAsString.append("\n\tRequest headers: ");
            for (String headerName : Collections.list(request.getHeaderNames())) {
                requestAsString.append("\n\t\t").append(headerName).append(": ")
                        .append(String.join("; ", Collections.list(request.getHeaders(headerName))));
            }
            log.debug(requestAsString.toString());
        }

        filterChain.doFilter(req, resp);
    }
}
