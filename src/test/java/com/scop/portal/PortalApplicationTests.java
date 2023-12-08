package com.scop.portal;

import com.scop.portal.dao.customer.CustomerMapper;
import com.scop.portal.domain.customer.Customer;
import com.scop.portal.utils.page.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class PortalApplicationTests {
    @Autowired
    CustomerMapper customerMapper;
    @Test
    public void testCriteria()throws Exception{
        Criteria criteria = new Criteria();
        criteria.setPage(1);
        criteria.setPerPageNum(20);

        List<Customer> list = customerMapper.customerList(criteria);

        for(Customer customer : list){
            log.info("customer id ={}",customer.getId());
            log.info("customer name ={}",customer.getName());
        }

    }

}
