package com.scop.portal.common.email;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.scop.portal.common.email
 * fileName       : EmailVO
 * author         : Mr.Lee
 * date           : 2023-11-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-29        Mr.Lee      최초 생성
 */
@Getter
@Setter
@Builder
public class EmailVO {
    private String to;
    private String subject;
    private String message;
}
