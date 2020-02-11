package com.michael.schoolWebAppwithmongo.controller;

import com.michael.schoolWebAppwithmongo.documents.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(final Administrator admin,final BindingResult result, Model model){
        if(result.hasErrors()){
            Error error = new Error(result.getGlobalError().toString());
            model.addAttribute("error", error);
            return "/login";
        }
        model.addAttribute("error", null);

        return "/login";

    }
}
