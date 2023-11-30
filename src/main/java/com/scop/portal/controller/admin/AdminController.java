package com.scop.portal.controller.admin;

import com.scop.portal.common.email.EmailService;
import com.scop.portal.common.email.EmailVO;
import com.scop.portal.domain.admin.Admin;
import com.scop.portal.service.admin.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@AllArgsConstructor
public class AdminController {
    private final String viewUrl = "/views/admin";
    private AdminService adminService;
    private EmailService emailService;

    /**
     * 메인 화면 조회
     *
     * @param model the model
     * @return the string
     */
    @GetMapping
    public String adminList(Model model) {
        model.addAttribute("list", adminService.getAdminList());

        EmailVO emailVO = EmailVO.builder()
                .to("dementor0711@gmail.com")
                .subject("이메일 테스트")
                .message("이메일 테스트 본문")
                .build();

        emailService.sendMail(emailVO);

        return viewUrl + "/adminList";
    }

    /**
     * 운영자 상세 조회
     *
     * @return the string
     */
    @GetMapping("/{adminId}")
    public String adminDtl() {

        return viewUrl + "/adminDtl";
    }

    /**
     * 운영자 수정 화면
     *
     * @param adminId the admin id
     * @param model   the model
     * @return the string
     */
    @GetMapping("/editAdmin/{adminId}")
    public String editAdmin(@PathVariable String adminId, Model model) {

        return viewUrl + "/editAdmin";
    }

    /**
     * 운영자 수정
     *
     * @param admin the admin
     * @return the string
     */
    @PostMapping("/editAdmin/{adminId}")
    public String editAdmin(@ModelAttribute Admin admin) {

        return "/redirect:admin";
    }

    /**
     * 운영자 등록 화면
     *
     * @return the string
     */
    @GetMapping("/addAdmin")
    public String addAdmin() {
        log.info("");

        return "";
    }

    /**
     * 운영자 등록
     *
     * @param admin the admin
     * @return the object
     */
    @PostMapping("/addAdmin")
    @ResponseBody
    public Object addAdmin(@ModelAttribute Admin admin) {
        log.info("addAdmin = {}", admin);

        return "ok";
    }


}
