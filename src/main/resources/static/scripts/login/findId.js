$(function () {
    $('form .btn').click(function () {
        var data ={
            "userEmail" : $("#userEmail").val(),
            "userNm" : $("#userNm").val()
        }
        validate();
        ajaxPost("/login/findId", data, function (res) {
            console.log(res);
            if(res == "SUCCESS"){

            }else if(res == "NOT_EXISTS"){
                $('.error_msg').removeClass('hide');
            }
        })
    });
});


function validate() {
    let userEmail = $('#userEmail').val();
    let userNm = $('#userNm').val();

    if (isNull(userEmail)) {
        $("#userEmail").parent().addClass('error');
        $('.error_msg').removeClass('hide');
        $(".error_msg").text(msgErrorId);
        return false;
    }

    if (isNull(userNm)) {
        $("#userNm").parent().addClass('error');
        $('.error_msg').removeClass('hide');
        $(".error_msg").text(msgErrorPW);
        return false;
    }
}