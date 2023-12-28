package com.scop.portal.service.customer;

import com.scop.portal.domain.common.search.CustSearchCriteria;
import com.scop.portal.domain.customer.CustComp;
import com.scop.portal.domain.common.page.Criteria;

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
    List<CustComp> customerList(CustSearchCriteria criteria);

    int customerCount(CustSearchCriteria criteria);

    void insertCustComp(CustComp custComp);

    CustComp readCustomer(String custCompId);

    boolean idDupChk(String custCompNm);
}
