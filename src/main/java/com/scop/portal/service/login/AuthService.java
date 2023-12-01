package com.scop.portal.service.login;

import com.scop.portal.domain.admin.Admin;


public interface AuthService {
    public Admin selectUser(String userId);
}
