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