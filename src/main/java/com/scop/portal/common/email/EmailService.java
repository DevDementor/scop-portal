package com.scop.portal.common.email;

import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

/**
 * packageName    : com.scop.portal.common.email
 * fileName       : EmailService
 * author         : Mr.Lee
 * date           : 2023-11-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-29        Mr.Lee      최초 생성
 */
@Slf4j
@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    public void sendMail(EmailVO emailVO){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setTo(emailVO.getTo()); // 메일 수신자
            mimeMessageHelper.setSubject(emailVO.getSubject()); // 메일 제목
            mimeMessageHelper.setText(emailVO.getMessage()); // 메일 본문 내용, HTML

            javaMailSender.send(mimeMessage);
        }catch(Exception e){
            log.info("fail");
            e.printStackTrace();
        }
    }
}
