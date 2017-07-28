package com.bwjk.sso.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by zxl on 2017/7/14.
 */
public class HTTPBearerAuthorizeAttribute implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {/*

        System.out.println("filter-start");

        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        String auth = httpRequest.getHeader("Authorization");

        if ((auth != null) && (auth.length() > 7)) {
            String HeadStr = auth.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0) {
                auth = auth.substring(7, auth.length());
                try {
                    if (JwtUtil.parseJWT(auth) != null) {
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        System.out.println("filter-end");
        return;
    */}

    @Override
    public void destroy() {

    }
}
