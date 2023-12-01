package com.scop.portal.service.admin;

import com.scop.portal.domain.admin.Admin;

import java.util.List;

/**
 * packageName    : com.scop.portal.service.admin
 * fileName       : AdminService
 * author         : Mr.Lee
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Mr.Lee      최초 생성
 */
public interface AdminService {
    public List<Admin> adminList();

    public void addAdmin(Admin admin);
}
