package com.scop.portal.controller.dashboard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final String viewUrl =  "/views/dashboard";


    @GetMapping
    public String main(){
        //신규 등록건 조회

        //누적 등록건 조회


        return viewUrl+"/dashboard";
    }
}
