package com.scop.portal.domain.admin;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * packageName    : com.scop.portal.domain.admin
 * fileName       : Admin
 * author         : Mr.Lee
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Mr.Lee      최초 생성
 */

@Data
public class Admin{
    private String adminId;
    private String adminName;
    private String telNo;
    private String password;
    private String memo;
    private String createDate;
    private String updateDate;
}
