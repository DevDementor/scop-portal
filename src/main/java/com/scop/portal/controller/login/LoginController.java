package com.scop.portal.controller.login;

import com.scop.portal.service.login.AuthService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AuthService authService;
    private final String viewUrl =  "/views/login";

    @GetMapping("")
    public String main(){
        return viewUrl + "/login";
    }
}
