package com.nhnacademy.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String excute(HttpServletRequest request, HttpServletResponse response);
}
