package com.scop.portal.controller.admin;

import com.scop.portal.domain.admin.Admin;
import com.scop.portal.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.scop.portal.controller.admin
 * fileName       : AdminController
 * author         : Mr.Lee
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Mr.Lee      최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final String viewUrl = "/views/admin";
    private final AdminService adminService;

    /**
     * 메인 화면 리스트 조회
     *
     * @param model the model
     * @return the string
     */
    @GetMapping
    public String adminList(@AuthenticationPrincipal User user, Model model){
        log.info("User = {}", user);
        model.addAttribute("admin", user);
        model.addAttribute("list", adminService.adminList());
        return viewUrl + "/adminList";
    }

    /**
     * 운영자 등록 화면
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/createAdmin")
    public String createAdmin(Model model){
        model.addAttribute("admin", new Admin());
        return viewUrl+"/addAdmin";
    }

    /**
     * 운영자 등록
     *
     * @param admin the admin
     * @return the object
     */
    @PostMapping("/createAdmin")
    public String createAdmin(@ModelAttribute Admin admin){
        adminService.createAdmin(admin);
        return "redirect:/admin";
    }

    /**
     * 운영자 상세 조회
     *
     * @return the string
     */
    @GetMapping("/{adminId}")
    public String adminDtl(){

        return viewUrl +"/adminDtl";
    }

    /**
     * 운영자 수정 화면
     *
     * @param adminId the admin id
     * @param model   the model
     * @return the string
     */
    @GetMapping("/editAdmin/{adminId}")
    public String editAdmin(@PathVariable String adminId, Model model){

        return viewUrl+"/editAdmin";
    }

    /**
     * 운영자 수정
     *
     * @param admin the admin
     * @return the string
     */
    @PostMapping("/editAdmin")
    public String editAdmin(@ModelAttribute Admin admin){

        return "/redirect:admin";
    }

    /**
     * ID 중복 체크
     *
     * @param admin the admin
     * @return the object
     */
    @GetMapping("/idDupChk")
    @ResponseBody
    public Object idDupChk(Admin admin){
        return "";
    }

    @PostMapping("/updatePw")
    @ResponseBody
    public Object updatePw(Admin admin){

        return "";
    }
}
