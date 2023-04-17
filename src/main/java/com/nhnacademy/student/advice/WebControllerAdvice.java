package com.nhnacademy.student.advice;

import com.nhnacademy.student.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.UnexpectedTypeException;
import java.net.BindException;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(value = {NoHandlerFoundException.class, IllegalArgumentException.class, BindException.class,
            ConversionFailedException.class, ValidationFailedException.class, UnexpectedTypeException.class})
    public String handleException(Exception ex, Model model){
        log.error("resources not found", ex);
        model.addAttribute("exception",ex.getMessage());
        return "error";
    }
}
