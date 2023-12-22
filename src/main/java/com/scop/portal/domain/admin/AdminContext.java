package com.scop.portal.domain.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * packageName    : com.scop.portal.domain.admin
 * fileName       : AdminContext
 * author         : Mr.Lee
 * date           : 2023-12-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-20        Mr.Lee      최초 생성
 */
public class AdminContext extends User {
    private Admin admin;

    public AdminContext(Admin admin, Collection<? extends GrantedAuthority> authorities){
        super(admin.getAdminId(), admin.getPassword(), authorities);
    }

}
