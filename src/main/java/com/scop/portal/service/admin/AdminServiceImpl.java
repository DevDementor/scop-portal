package com.scop.portal.service.admin;

import com.scop.portal.dao.admin.AdminMapper;
import com.scop.portal.domain.admin.Admin;
import lombok.AllArgsConstructor;
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
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    AdminMapper adminMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAdminList() {
        return adminMapper.getAdminList();
    }
}
