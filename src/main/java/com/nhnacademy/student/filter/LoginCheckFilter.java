//package com.nhnacademy.student.filter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
//        @WebInitParam(name = "exclude-urls", value = "/login, /logout, /login.html")
//})
//public class LoginCheckFilter implements Filter {
//    private final Set<String> excludeUrls = new HashSet<>();
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        excludeUrls.addAll(Arrays.asList(filterConfig.getInitParameter("exclude-urls").split(", ")));
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//
//        if (!excludeUrls.contains(httpServletRequest.getRequestURI())) {
//            if (httpServletRequest.getSession(false) == null) {
//                ((HttpServletResponse) servletResponse).sendRedirect("login.html");
//                return;
//            }
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
