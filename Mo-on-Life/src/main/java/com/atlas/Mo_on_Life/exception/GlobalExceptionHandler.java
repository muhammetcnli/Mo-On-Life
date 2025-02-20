package com.atlas.Mo_on_Life.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFound(PostNotFoundException e){
        return "error/404"; // Returns to the error page, when thrown
    }

}
