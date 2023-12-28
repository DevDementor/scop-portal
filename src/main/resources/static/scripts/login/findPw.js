$(function () {
    $('form .btn').click(function () {
        var params ={
            "userEmail" : $("#userEmail").val(),
            "userId" : $("#userId").val()
        }
        validate();
        ajaxPost("/login/findPw", params, function (res) {
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
    let userNm = $('#userId').val();

    if (isNull(userEmail)) {
        $("#userEmail").parent().addClass('error');
        $('.error_msg').removeClass('hide');
        $(".error_msg").text(msgErrorId);
        return false;
    }

    if (isNull(userId)) {
        $("#userNm").parent().addClass('error');
        $('.error_msg').removeClass('hide');
        $(".error_msg").text(msgErrorPW);
        return false;
    }
}