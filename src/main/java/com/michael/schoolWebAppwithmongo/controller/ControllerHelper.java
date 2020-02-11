package com.michael.schoolWebAppwithmongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.michael.schoolWebAppwithmongo.documents.ErrorMessages;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
public class ControllerHelper {

    @ExceptionHandler(IOException.class)
    public String generalIOException(Model model,Exception ex,ErrorMessages error){
        error = new ErrorMessages(ex.getMessage());
        model.addAttribute("error", error);
        return "/error";

    }

    @ExceptionHandler(RuntimeException.class)
    public String generalRuntimeException(Model model,Exception ex,ErrorMessages error){
        error = new ErrorMessages(ex.getMessage());
        model.addAttribute("error", error);
        return "/error";

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequest(Model model, HttpServletRequest request,ErrorMessages error){
        System.out.println(request.getRequestURL().toString());
        error = new ErrorMessages(request.getRequestURL() +" Not found");
        model.addAttribute("error", error);
        return "/error";
    }
}
