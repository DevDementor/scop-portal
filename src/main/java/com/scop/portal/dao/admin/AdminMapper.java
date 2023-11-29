package com.scop.portal.dao.admin;

import com.scop.portal.domain.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.scop.portal.dao.admin
 * fileName       : AdminMapper
 * author         : Mr.Lee
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        Mr.Lee      최초 생성
 */

@Repository
@Mapper
public interface AdminMapper {
    public List<Admin> getAdminList();
}
