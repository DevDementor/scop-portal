package com.scop.portal.dao.login;

import com.scop.portal.domain.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthMapper {
    public int join();
    public Admin selectUser(String userId);
}
