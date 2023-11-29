package com.scop.portal.service.login;

import com.scop.portal.dao.login.AuthMapper;
import com.scop.portal.domain.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;

    @Override
    public void createUser(Member member) {

    }

    @Override
    public Member selectUser(String userId) {
        Member member = authMapper.selectUser(userId);
        log.info("member >>>>> {}", member);

        return authMapper.selectUser(userId);
    }
}
