package com.scop.portal.config.security;

import com.scop.portal.domain.Member;
import com.scop.portal.service.login.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<Member> findOne = Optional.ofNullable(authService.selectUser(memberId));
        Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));

        return User.builder()
                .username(member.getId())
                .password(member.getPw())
                .build();
    }
}
