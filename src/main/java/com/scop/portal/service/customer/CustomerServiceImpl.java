package com.scop.portal.service.customer;

import com.scop.portal.dao.customer.CustomerMapper;
import com.scop.portal.domain.common.search.CustSearchCriteria;
import com.scop.portal.domain.customer.CustComp;
import com.scop.portal.domain.common.page.Criteria;
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
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;

    @Override
    public List<CustComp> customerList(CustSearchCriteria criteria) {
        return customerMapper.customerList(criteria);
    }

    @Override
    public void insertCustComp(CustComp custComp) {
        // TODO: 2023-12-27 등록자 정보 세션에서 가져오는걸로 수정 필요
        custComp.setStmFrstRegUserId("admin");
        custComp.setStmLastModfUserId("admin");
        customerMapper.insertCustComp(custComp);
    }

    @Override
    public int customerCount(CustSearchCriteria criteria) {
        return customerMapper.customerCount(criteria);
    }

    @Override
    public CustComp readCustomer(String custCompId) {
        return customerMapper.readCustomer(custCompId);
    }

    @Override
    public boolean idDupChk(String custCompNm) {
        int result = customerMapper.idDupChk(custCompNm);

        if(result >= 1){
            return false;
        }
        return true;
    }
}
