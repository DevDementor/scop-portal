/**
 * null 체크
 * */
function isNull(sParam) {
    if (typeof (sParam) == "number" || typeof (sParam) == "boolean") return false;

    if (sParam == undefined || sParam == 'undefined' || sParam == '' || sParam == ' ' || sParam == 'null' || sParam == null) {
        return true;
    } else {
        return false;
    }
}

function ajaxGet(url, params, callback, complete, showLoading) {
    $.ajax({
        type: "GET", url: url, data: params, beforeSend: function (xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            xhr.setRequestHeader("Content-type", "application/json");
        }, success: callback, complete: complete, showLoading: showLoading
    });
}

function ajaxPost(url, params, callback, complete, showLoading) {
    $.ajax({
        type: "POST", url: url, data: JSON.stringify(params), beforeSend: function (xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            xhr.setRequestHeader("Content-type", "application/json");
        }, success: callback, complete: complete, showLoading: showLoading
    });
}

//검색창의 날짜 초기화
function initDate() {
    /*
        검색 후의 날짜 초기화. query string에서 가져온다.
     */
    // 현재 URL에서 쿼리 스트링 값 가져오기
    let queryString = window.location.search;

    // URLSearchParams를 사용하여 파싱
    let urlParams = new URLSearchParams(queryString);

    // 날짜 정보 가져오기
    let startDate = urlParams.get('startDate');
    let endDate = urlParams.get('endDate');


    /*
        검색 전의 날짜 초기화
     */
    if (isNull(startDate) || isNull(endDate)) {
        //현재 날짜
        startDate = new Date();
        let year = startDate.getFullYear();
        let month = ('0' + (startDate.getMonth() + 1)).slice(-2);
        let startDay = ('0' + startDate.getDate()).slice(-2);
        let hours = ('0' + startDate.getHours()).slice(-2);
        let minutes = ('0' + startDate.getMinutes()).slice(-2);
        startDate = `${year}-${month}-${startDay}T${hours}:${minutes}`;

        endDate = new Date();
        endDate.setDate(endDate.getDate() + 30);
        let endYear = endDate.getFullYear();
        let endMonth = ('0' + endDate.getMonth() + 1).slice(-2);
        let endDay = ('0' + endDate.getDate()).slice(-2);
        let endHours = ('0' + endDate.getHours()).slice(-2);
        let endMinutes = ('0' + endDate.getMinutes()).slice(-2);
        endDate = `${endYear}-${endMonth}-${endDay}T${endHours}:${endMinutes}`;
    }

    $('input[name=startDate]').val(startDate);
    $('input[name=endDate]').val(endDate);
}


/**
 * layerPop방식 팝업호출
 * @param url
 * @param name
 * @param params
 */
function openLayerPopPost(url, div, params, callBack) {
    ajaxPost(url, params, function(getData) {
        console.log(getData);

        $("#pkstSelPop").modal();
    });
}

/**
 * layerPop 닫기
 * @param url
 * @param name
 * @param params
 */
function openLayerPopClose(div) {
    $("[id='"+div+"']").remove();
    if($('.modal_wrap.open').length<=0){
        $('body').removeClass('modal_open');
    }
}

function openModal ( id ){
    var zIndex = 1000;
    if($('.modal_wrap.open').length>0){
        $('.modal_wrap.open').each(function(){
            zIndex =  zIndex > $(this).css('zIndex') ? zIndex : $(this).css('zIndex');
        });
        // $('body').addClass('modal_open');
        $(id).addClass('open').css('zIndex',parseInt(zIndex)+10);
    }else{
        if($(id).is('.modal_alert') == false){
            $('body').addClass('modal_open');
        }
        $(id).addClass('open');
    }

}