package com.scop.portal.utils.page;

import lombok.Data;

/**
 * packageName    : com.scop.portal.utils.page
 * fileName       : Criteria
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
public class Criteria {
    private int page;
    private int perPageNum;

    private String searchCustName;

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPage(int page){
        if(page <= 0){
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPage(){
        return page;
    }

    public int getPageStart(){
        return (this.page -1) * perPageNum;
    }

    public int getPerPageNum(){
        return this.perPageNum;
    }

    public void setSearchCustName(String searchCustName) {
        this.searchCustName = searchCustName;
    }

    public String getSearchCustName(){
        return this.searchCustName;
    }

    @Override
    public String toString(){
        return "Criteria [page = "+ page + ","
                +"perPageNum=" + perPageNum+"]";
    }

}
