package com.michael.schoolWebAppwithmongo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String successUrl = "/students";

    public LoginSuccessHandler(String successUrl){
        if(!successUrl.equals("") || successUrl != null)
            this.successUrl = successUrl;
        setDefaultTargetUrl(this.successUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        getRedirectStrategy().sendRedirect(request,response,this.successUrl);

    }
}
