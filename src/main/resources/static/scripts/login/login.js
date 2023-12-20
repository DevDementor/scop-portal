$(function () {
});

/*
유효성 검사
 */
function validate() {
    let adminId = $('#adminId').val();
    let password = $('#password').val();

    if (isNull(adminId)) {
        $("#adminId").parent().addClass('error');
        $('.error_msg').css('display','block');
        $(".error_msg").text(msgErrorId);
        return false;
    }

    if (isNull(password)) {
        $("#password").parent().addClass('error');
        $('.error_msg').css('display','block');
        $(".error_msg").text(msgErrorPW);
        return false;
    }
}