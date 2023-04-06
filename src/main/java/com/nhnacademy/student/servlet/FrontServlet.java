package com.nhnacademy.student.servlet;

import com.nhnacademy.student.controller.Command;
import com.nhnacademy.student.controller.StudentDeleteController;
import com.nhnacademy.student.controller.StudentListController;
import com.nhnacademy.student.controller.StudentRegisterController;
import com.nhnacademy.student.controller.StudentRegisterFormController;
import com.nhnacademy.student.controller.StudentUpdateController;
import com.nhnacademy.student.controller.StudentUpdateFormController;
import com.nhnacademy.student.controller.StudentViewController;
import com.nhnacademy.student.init.ControllerFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    public static final String REDIRECT_PREFIX = "redirect:";
    private ControllerFactory controllerFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        controllerFactory = (ControllerFactory) config.getServletContext().getAttribute("controllerFactory");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.excute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
                return;
            }

            req.getRequestDispatcher(view).forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method){
        return controllerFactory.getBean(method, servletPath);
    }

}
