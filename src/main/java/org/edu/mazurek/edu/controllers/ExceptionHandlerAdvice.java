package org.edu.mazurek.edu.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BindException.class)
    public ModelAndView bindException(Exception exception) {
        log.info("BindException", exception);
        Map<String, String> props = new HashMap<String, String>();
        props.put("error", "");
        return new ModelAndView("Home", props);
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView genericException(Exception exception) {
        log.info("Exception", exception);
        Map<String, String> props = new HashMap<String, String>();
        props.put("error", "Zjebales generycznie");
        return new ModelAndView("Home", props);
    }

}
