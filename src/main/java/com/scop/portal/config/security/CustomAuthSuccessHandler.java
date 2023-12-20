package com.scop.portal.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.scop.portal.config.security
 * fileName       : CustomAuthSuccessHandler
 * author         : Mr.Lee
 * date           : 2023-12-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-19        Mr.Lee      최초 생성
 */
@Slf4j
@Component
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("CustomAuthSuccessHandler onAuthenticationSuccess!!");
        // TODO: 2023-12-20
        /*
            1.

         */
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
