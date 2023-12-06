package com.scop.portal.controller.customer;

import com.scop.portal.service.customer.CustomerService;
import com.scop.portal.utils.page.Criteria;
import com.scop.portal.utils.page.PageMaker;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final String viewUrl = "/views/customer";

    private final CustomerService customerService;

    @GetMapping
    public String customerList(Criteria criteria, Model model){

        model.addAttribute("list", customerService.customerList(criteria));
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(customerService.customerCount());
        model.addAttribute("pageMaker", pageMaker);
        return viewUrl + "/customerList";
    }
}


