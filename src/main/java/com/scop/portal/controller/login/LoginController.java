package com.scop.portal.controller.login;

import com.scop.portal.common.email.EmailService;
import com.scop.portal.domain.admin.Admin;
import com.scop.portal.service.login.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService authService;

    private final EmailService emailService;
    private final String viewUrl = "/views/login";

    @GetMapping("")
    public String main() {
        return viewUrl + "/login";
    }

    @GetMapping("/findId")
    public String findId() {
        return viewUrl + "/findId";
    }

    @PostMapping("/findId")
    @ResponseBody
    public Object findId(@RequestBody Map<String, Object> param) {
        String resultCd ="SUCCESS";
        /*
        TODO: 2023-12-21
            1. DB에서 아이디 조회
                1.1. 조회 성공시
                    1.1.1. 메일 전송
                1.2. 조회 실패시
         */

        //1.
        Optional<Admin> findOne = Optional.ofNullable(authService.selectAdmin((String)param.get("userEmail")));
        if(findOne.isPresent()){

        }else{
            resultCd = "NOT_EXISTS";
        }

        return resultCd;
    }

    @GetMapping("/findPw")
    public String findPw() {
        return viewUrl + "/findPw";
    }

    @PostMapping("/findPw")
    @ResponseBody
    public Object findPw(@RequestBody Map<String, Object> param) {
        String resultCd ="SUCCESS";
        /*
        TODO: 2023-12-21
            1. DB에서 아이디 조회
                1.1. 조회 성공시
                    1.1.1. 메일 전송
                1.2. 조회 실패시
         */

        //1.
        Optional<Admin> findOne = Optional.ofNullable(authService.selectAdmin((String)param.get("userEmail")));
        if(findOne.isPresent()){

        }else{
            resultCd = "Not_EXISTS";
        }

        return resultCd;
    }

}


