package com.scop.portal.dao.customer;

import com.scop.portal.domain.common.search.CustSearchCriteria;
import com.scop.portal.domain.customer.CustComp;
import com.scop.portal.domain.common.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {
    public List<CustComp> customerList(CustSearchCriteria criteria);

    public int customerCount(CustSearchCriteria criteria);

    public void insertCustComp(CustComp custComp);

    public CustComp readCustomer(String custCompId);

    public int idDupChk(String custCompNm);
}
