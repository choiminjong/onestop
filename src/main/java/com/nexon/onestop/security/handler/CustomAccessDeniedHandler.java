package com.nexon.onestop.security.handler;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;
    private String errorMessage;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
                        throws IOException, ServletException {

        errorMessage = URLEncoder.encode(accessDeniedException.getMessage(), "UTF-8");
        String denieUrl = errorPage + "?exception="+errorMessage;
        response.sendRedirect(denieUrl);
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}
