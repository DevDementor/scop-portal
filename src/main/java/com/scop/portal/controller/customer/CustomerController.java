package com.scop.portal.controller.customer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * packageName    : com.scop.portal.controller
 * fileName       : CustomerController
 * author         : Mr.Lee
 * date           : 2023-11-13
 * description    : 고객사 관리 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-13        Mr.Lee      최초 생성
 */

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final String viewUrl = "/views/customer";

    @GetMapping("/list")
    public String list(){
        return viewUrl + "/list";
    }

    @PostMapping("/sarchList")
    @ResponseBody
    public Object customerSearchList(Map<String, Object> paramMap){

        return "";
    }

}
