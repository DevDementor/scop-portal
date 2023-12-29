package com.scop.portal.controller.customer;

import com.scop.portal.domain.common.page.Criteria;
import com.scop.portal.domain.common.page.PageMaker;
import com.scop.portal.domain.common.search.CustSearchCriteria;
import com.scop.portal.domain.customer.CustComp;
import com.scop.portal.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final String viewUrl = "/views/customer";

    private final CustomerService customerService;

    @GetMapping
    public String customerList(CustSearchCriteria criteria, Model model) {

        model.addAttribute("list", customerService.customerList(criteria));

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(customerService.customerCount(criteria));
        model.addAttribute("pageMaker", pageMaker);
        return viewUrl + "/customerList";
    }

    @GetMapping("/regCustomer")
    public String regCustomerForm(Model model) {
        model.addAttribute("custComp", new CustComp());
        return viewUrl + "/regCustomer";
    }

    @PostMapping("/regCustomer")
    public String regCustomer(@Validated @ModelAttribute CustComp custComp, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return viewUrl + "/regCustomer";
        }
        customerService.insertCustComp(custComp);

        return "redirect:/customer";
    }

    @GetMapping("/{customerId}")
    public String readCustomer(@PathVariable String custCompId, Model model) {

//        model.addAttribute("customer", customerService.readCustomer(customerId));

        return viewUrl + "/readCustomer";
    }

    @GetMapping("/updateCustomer/{customerId}")
    public String updateCustomer(@PathVariable String custCompId) {

        return viewUrl + "/updateCustomer";
    }

    @GetMapping("/idDupChk")
    @ResponseBody
    public Object idDupChk(@RequestParam Map<String, Object> params) {
        log.info("params={}", params);
        return customerService.idDupChk((String) params.get("custCompNm"));
    }

    // TODO: 2023-12-28 레이어 팝업 테스트..후에는 주차장 관리 쪽 Controller로 빼자
    @GetMapping("/layer/pkstSelPop")
    public String pkstSelPop(@RequestParam Map<String, Object> params, CustSearchCriteria criteria, Model model){
        log.info("pkstSelPop");
        model.addAttribute("list", customerService.customerList(criteria));

        return viewUrl + "/pkstSelPop";
    }

}


