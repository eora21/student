//package com.nhnacademy.student.controller;
//
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
//import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE;
//import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;
//import static javax.servlet.RequestDispatcher.ERROR_REQUEST_URI;
//import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;
//
//@Slf4j
//public class ErrorController implements Command {
//
//    @Override
//    public String excute(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("status_code", request.getAttribute(ERROR_STATUS_CODE));
//        request.setAttribute("exception_type", request.getAttribute(ERROR_EXCEPTION_TYPE));
//        request.setAttribute("message", request.getAttribute(ERROR_MESSAGE));
//        request.setAttribute("exception", request.getAttribute(ERROR_EXCEPTION));
//        request.setAttribute("request_uri", request.getAttribute(ERROR_REQUEST_URI));
//
//        return "/error.jsp";
//    }
//}
