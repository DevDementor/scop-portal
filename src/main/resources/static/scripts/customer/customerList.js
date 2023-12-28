$(function(){
    //검색 날짜 초기화
    initDate();
    //셀렉트 박스
    $("#perPageNum").val(perPageNum).attr("selected");
});

// 페이지당 게시글 수 선택
function selPerPageNum(selectValue){
    let perPageNum = selectValue;
    let pagingForm = $("#pagingForm");
    pagingForm.find("[name='perPageNum']").val(perPageNum);
    pagingForm.attr("action","/customer").attr("method","get");
    pagingForm.submit();
}

//검색
function search(){
    let pagingForm = $("#pagingForm");
    pagingForm.find("[name='startDate']").val();
    pagingForm.find("[name='endDate']").val();
    pagingForm.find("[name='custCompId']").val();
    pagingForm.find("[name='custCompNm']").val();
    pagingForm.find("[name='cpsnNm']").val();
    pagingForm.find("[name='perPageNum']").val(perPageNum);
    pagingForm.attr("action","/customer").attr("method","get");
    pagingForm.submit();
}
