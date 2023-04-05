package com.nhnacademy.student.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String servletPath = resolveServlet(req.getServletPath());
        log.info(req.getServletPath());
        req.getRequestDispatcher(servletPath).include(req, resp);

        String view = (String) req.getAttribute("view");

        if (view.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));
            return;
        }

        req.getRequestDispatcher(view).forward(req, resp);
    }

    private String resolveServlet(String servletPath) {
        String processingServletPath = null;

        if ("/student/list.do".equals(servletPath)) {
            processingServletPath = "/student/list";
        } else if ("/student/delete.do".equals(servletPath)) {
            processingServletPath = "/student/delete";
        } else if ("/student/register.do".equals(servletPath)) {
            processingServletPath = "/student/register";
        } else if ("/student/update.do".equals(servletPath)) {
            processingServletPath = "/student/update";
        } else if ("/student/view.do".equals(servletPath)) {
            processingServletPath = "/student/view";
        }

        return processingServletPath;
    }
}
