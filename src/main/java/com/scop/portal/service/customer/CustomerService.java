package com.scop.portal.service.customer;

import com.scop.portal.domain.customer.Customer;
import com.scop.portal.utils.page.Criteria;

import java.util.List;

/**
 * packageName    : com.scop.portal.service.customer
 * fileName       : CustomerService
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
public interface CustomerService {
    List<Customer> customerList(Criteria criteria);

    int customerCount();
}
