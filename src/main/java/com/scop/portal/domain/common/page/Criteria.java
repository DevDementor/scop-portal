package com.scop.portal.domain.common.page;

import lombok.Data;

/**
 * packageName    : com.scop.portal.utils.page
 * fileName       : Criteria
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    : 페이징에 사용 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
public class Criteria {
    private int page;
    private int perPageNum;
    public Criteria(){
        this.page = 1;
        this.perPageNum = 20;
    }

    public void setPage(int page){
        if(page <= 0){
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0){
            this.perPageNum = 20;
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

    @Override
    public String toString(){
        return "Criteria [page = "+ page + ","
                +"perPageNum=" + perPageNum+"]";
    }

}
