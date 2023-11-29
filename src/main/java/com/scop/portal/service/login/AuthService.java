package com.scop.portal.service.login;

import com.scop.portal.domain.Member;


public interface AuthService {

    public void createUser(Member member);
    public Member selectUser(String userId);
}
