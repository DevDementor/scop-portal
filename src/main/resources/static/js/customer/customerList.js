$(function(){
    /*
        페이징 처리
     */
    $("#perPageNum").change(function (){
        var perPageNum = $(this).val();
        var pagingForm = $("#pagingForm");
        pagingForm.find("[name='perPageNum']").val(perPageNum);
        pagingForm.attr("action","/customer").attr("method","get");
        pagingForm.submit();
    })

})