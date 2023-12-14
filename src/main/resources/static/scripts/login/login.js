$(function(){

});


/*
유효성 검사
 */
function validate(){
    let id = $("#adminId").val();
    let pw = $("#adminPw").val();

    if(isNull(id)){
        //todo. 퍼블 나오면 적용
        return false;
    }

    if(isNull(pw)){
        //todo. 퍼블 나오면 적용
        return
    }
}

function saveAction(){
    alert("saveAction");

    if(!validate()){

    }
}