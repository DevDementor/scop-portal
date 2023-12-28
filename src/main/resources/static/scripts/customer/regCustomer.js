$(function () {

});

function idDupChk() {
    var params = {
        "custCompNm": $("[name='custCompNm']").val()
    }
    ajaxGet("/customer/idDupChk", params, function (res) {

        if(res == false){// 중복인 경우
            alert(msgIdDupChkError);
            chkDupId = false;
        }else if(res == true){//중복이 아닌 경우
            alert(msgIdDupChkSuccess);
            chkDupId = true;
        }
    })
}

function saveCust(){
    $('form').submit(function(event){
        //중복확인 체크
        if(chkDupId == false){
            alert("고객사명 중복 확인이 필요합니다.")
            return false;
        }
    })
}