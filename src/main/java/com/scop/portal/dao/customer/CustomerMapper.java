package com.scop.portal.dao.customer;

import com.scop.portal.domain.admin.Admin;
import com.scop.portal.domain.customer.Customer;
import com.scop.portal.utils.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface CustomerMapper {
    public List<Customer> customerList(Criteria criteria);

    public int customerCount(Criteria criteria);

    public Customer readCustomer(String customerId);
}
