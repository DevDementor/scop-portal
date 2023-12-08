package com.scop.portal.service.customer;

import com.scop.portal.dao.customer.CustomerMapper;
import com.scop.portal.domain.customer.Customer;
import com.scop.portal.utils.page.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.scop.portal.service.customer
 * fileName       : CustomerServiceImpl
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerMapper customerMapper;
    @Override
    public List<Customer> customerList(Criteria criteria) {
        return customerMapper.customerList(criteria);
    }

    @Override
    public int customerCount(Criteria criteria) {
        return customerMapper.customerCount(criteria);
    }
    @Override
    public Customer readCustomer(String customerId){
        return customerMapper.readCustomer(customerId);
    }
}
