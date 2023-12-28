package com.scop.portal.config.security;

import com.scop.portal.domain.admin.Admin;
import com.scop.portal.domain.admin.AdminContext;
import com.scop.portal.service.login.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<Admin> findOne = Optional.ofNullable(authService.selectAdmin(memberId));
        Admin admin = findOne.orElseThrow(() -> new UsernameNotFoundException("UsernameNotFoundException"));

        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//권한 관리는 따로 하지 않기 때문에 임의로 지정

        return new AdminContext(admin, roles);
    }
}
