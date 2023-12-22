/**
 * null 체크
 * */
function isNull(sParam) {
    if(typeof(sParam) == "number" || typeof(sParam) == "boolean")
        return false;

    if(sParam == undefined || sParam == 'undefined' || sParam == '' ||sParam == ' '|| sParam == 'null' ||sParam == null) {
        return true;
    } else {
        return false;
    }
}

function ajaxGet(url, params, callback, complete, showLoading) {
    $.ajax({
        type: "GET",
        url: url,
        data: JSON.stringify(params),
        beforeSend : function(xhr){
            xhr.setRequestHeader(csrfHeader, csrfToken);
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            xhr.setRequestHeader("Content-type","application/json");
        },
        success: callback,
        complete: complete,
        showLoading: showLoading
    });
}

function ajaxPost(url, params, callback, complete, showLoading) {
    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(params),
        beforeSend : function(xhr){
            xhr.setRequestHeader(csrfHeader, csrfToken);
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            xhr.setRequestHeader("Content-type","application/json");
        },
        success: callback,
        complete: complete,
        showLoading: showLoading
    });
}