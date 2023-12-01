package com.scop.portal.service.admin;

import com.scop.portal.dao.admin.AdminMapper;
import com.scop.portal.domain.admin.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.scop.portal.service.admin
 * fileName       : AdminServiceImpl
 * author         : Mr.Lee
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Mr.Lee      최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Admin> adminList() {
        return adminMapper.adminList();
    }

    @Override
    @Transactional
    public void createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        log.info("admin={}", admin);
        adminMapper.createAdmin(admin);
    }
}
