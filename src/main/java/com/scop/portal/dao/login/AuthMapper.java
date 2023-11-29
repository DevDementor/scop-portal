package com.scop.portal.dao.login;

import com.scop.portal.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthMapper {
    public int join();

    public Member selectUser(String userId);
}
