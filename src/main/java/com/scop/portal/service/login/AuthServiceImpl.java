package com.scop.portal.service.login;

import com.scop.portal.dao.login.AuthMapper;
import com.scop.portal.domain.admin.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;
    @Override
    public Admin selectUser(String userId) {
        return authMapper.selectUser(userId);
    }
}
