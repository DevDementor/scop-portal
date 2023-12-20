package com.scop.portal.controller.login;

import com.scop.portal.domain.admin.Admin;
import com.scop.portal.service.login.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private final AuthService authService;
    private final String viewUrl = "/views/login";

    @GetMapping("")
    public String main(@RequestParam(value = "error", required = false)String error,
                       @RequestParam(value = "errorMsg", required = false)String errorMsg,
                       Model model) {

        model.addAttribute("error", error);
        model.addAttribute("errorMsg", errorMsg);
        return viewUrl + "/login";
    }

    @GetMapping("/findId")
    public String findId(){
        return viewUrl + "/findId";
    }

    @PostMapping("/findId")
    @ResponseBody
    public Object findId(@RequestBody Admin admin){
        return "";
    }

    @GetMapping("/findPw")
    public String findPw(){
        return viewUrl + "/findPw";
    }
    
}


