package org.edu.mazurek.edu.controllers;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ControllerAdvice
     public class ExceptionHandlerAdvice {

        @ExceptionHandler(BindException.class)
        public ModelAndView bindException() {
            Map<String, String> props = new HashMap<String, String>();
            props.put("error", "");
//            props.put("error_msg", "Rejestracja nie powiodła się.");
            return new ModelAndView("Home", props);
        }

}
