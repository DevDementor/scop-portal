package com.scop.portal.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * packageName    : com.scop.portal.config.security
 * fileName       : CustomAuthFailureHandler
 * author         : Mr.Lee
 * date           : 2023-12-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-18        Mr.Lee      최초 생성
 */

@Slf4j
@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.debug("CustomAuthFailureHandler onAuthenticationFailure!!");

        // TODO: 2023-12-20
        /*
            1. 로그인 실패 횟수 증가
            2. 실패 횟수 기준 초과시 계정 잠금
         */

        setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, exception);
    }
}
