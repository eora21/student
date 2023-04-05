package com.nhnacademy.student.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE;
import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;
import static javax.servlet.RequestDispatcher.ERROR_REQUEST_URI;
import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@Slf4j
@WebServlet(name = "errorServlet", urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardError(req, resp);
        log.info("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardError(req, resp);
        log.info("doPost");
    }

    private static void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
        req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
        req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
        req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
        req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));

        req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
}
