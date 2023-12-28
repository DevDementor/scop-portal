package com.scop.portal.domain.common.search;

import com.scop.portal.domain.common.page.Criteria;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.scop.portal.domain.common.search
 * fileName       : CustSearch
 * author         : Mr.Lee
 * date           : 2023-12-28
 * description    : 고객사 검색 및 페이징 구현시 사용 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-28        Mr.Lee      최초 생성
 */

@Setter
@Getter
public class CustSearchCriteria extends Criteria {

    //시작 날짜
    private String startDate;
    private String endDate;
    private String custCompId;
    private String custCompNm;
    private String cpsnNm;
}
