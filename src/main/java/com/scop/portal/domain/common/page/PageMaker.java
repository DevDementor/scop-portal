package com.scop.portal.domain.common.page;

import lombok.Data;

/**
 * packageName    : com.scop.portal.utils.page
 * fileName       : PageMaker
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    : 페이징시 사용 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
@Data
public class PageMaker {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private Criteria criteria;

    public void setCriteria(Criteria criteria){
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount){
        this.totalCount=totalCount;
        calcData();
    }

    private void calcData(){
        endPage = (int)(Math.ceil(criteria.getPage()/(double)displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int)(Math.ceil(totalCount / (double) criteria.getPerPageNum()));

        if(endPage > tempEndPage){
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false:true;
        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }
}
