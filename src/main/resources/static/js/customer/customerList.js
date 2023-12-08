$(function(){
    //셀렉트 박스
    $("#selePerPageNum").val(perPageNum).attr("selected");
});

function selPerPageNum(selectValue){
    let perPageNum = selectValue;
    let pagingForm = $("#pagingForm");
    pagingForm.find("[name='perPageNum']").val(perPageNum);
    pagingForm.attr("action","/customer").attr("method","get");
    pagingForm.submit();
}

function search(){
    let pagingForm = $("#pagingForm");
    pagingForm.find("[name='perPageNum']").val(perPageNum);
    pagingForm.find("[name='searchCustName']").val();
    pagingForm.attr("action","/customer").attr("method","get");
    pagingForm.submit();
}