/**  NUI v1  |  Made by NTELS ICS team **/

$(function() {
	// 페이지 유형
	navigationLNB(); // navigation LNB
	minNav();        // navigation LNB
	userDropdown();
	searchToggle();

	// component
	checkboxAll();
	switchAll();
	btnToggle();
	textClear();
	numberSpinner();
	multiSelectLoad();
	tooltipLoad();
	dropdownLoad();
	formBlurDrag(); // drag 영역안에 dropdown form 요소가 있는 경우 사용
	$(window).add('div:not(.dropdown-menu)').on('scroll', function() {
		multiSelectReposition();
		formBlur();
	});
	$('.lnb .navigation').hover(formBlur);
});

$(window).on('resize', function() {
	minNav(); // navigation LNB
	multiSelectReposition();
	formBlur();
});


/* checkbox all toggle (일괄 선택/해제) */
function checkboxAll() {
	$('body').on('click', function(e) {
		var $target = $(e.target);
		var $nodeName = e.target.nodeName;
		if ($target.parents().hasClass('checkbox') && $nodeName == 'INPUT') {
			if ($target.hasClass('all')) {
				var $checkbox = $target.parents('.checkbox_all').find('.checkbox').find('input').not('.all').not(':disabled');
				if ($target.is(':checked')) {
					$checkbox.prop('checked', true);
				} else {
					$checkbox.prop('checked', false);
				}
			} else {
				// child checkbox 
				var $checkbox_all = $target.parents('.checkbox_all').find('.checkbox').find('input.all');
				if (!$target.is(':checked')) {
					$checkbox_all.prop('checked', false);
				}
				else {
					if ($target.parents('.checkbox_all').find('.checkbox').find('input[type=checkbox]:checked').not('.all').length
							== $target.parents('.checkbox_all').find('.checkbox').find('input[type=checkbox]').not('.all').length) {
						$checkbox_all.prop('checked', true);
					}
				}
			}
		}
	});
}

/* switch all toggle (일괄 선택/해제) */
function switchAll() {
	$('body').on('click', function(e) {
		var $target = $(e.target);
		var $nodeName = e.target.nodeName;
		if ($target.parents().hasClass('switch') && $nodeName == 'INPUT') {
			if ($target.hasClass('all')) {
				var $switch = $target.parents('.switch_all').find('.switch').find('input').not('.all').not(':disabled');
				if ($target.is(':checked')) {
					$switch.prop('checked', true);
				} else {
					$switch.prop('checked', false);
				}
			} else {
				var $switch_all = $target.parents('.switch_all').find('.switch').find('input.all');
				if (!$target.is(':checked')) {
					$switch_all.prop('checked', false);
				}
				else {
					if ($target.parents('.switch_all').find('.switch').find('input[type=checkbox]:checked').not('.all').length
							== $target.parents('.switch_all').find('.switch').find('input[type=checkbox]').not('.all').length) {
						$switch_all.prop('checked', true);
					}
				}
			}
		}
	});
}

/* button icon toggle */
function btnToggle() {
	$('.btn.toggle').click(function() {
		$(this).toggleClass('on');
	})
}

/* button icon toggle */
function searchToggle() {
	$('.btn.search_toggle').click(function() {
		$(this).toggleClass('on');
		$(this).closest('.search_area').find('.search_row_02').toggle();
	})
}

/* input text clear */
function textClear(){
	var $btn_clear = $('.input.search > .btn.icon');
	$btn_clear.on('click', function(){
		if($(this).find('span').length > 0){
			$(this).parent('.input').find('input').val('');
		}
	}); 
}

/* Number Spinner */
function numberSpinner() {
	var num = $(".number");
	$.each(num, function(idx, item) {
		var numI =  $(item).find("input"),
				 min = $(numI).attr("min"),
				 max = $(numI).attr("max"),
				step = $(numI).attr("step");
		if(min == "" || min  == undefined){
				min = -999999999999;
		}
		if(max == "" || max  == undefined){
				max = 999999999999;
		}
		if(step == "" || step  == undefined){
				step = "1";
		}
		$.each($(item).find("button"),function(sub_idx, sub_item){
			if(sub_idx == 0){
				$(sub_item).attr("onClick", "stepperInput($(this), -" + step + ", " + min + ")");
			} else {
				$(sub_item).attr("onClick", "stepperInput($(this), " + step + ", " + max + ")");
			}
		});
		
		// button disabled
		for (var i = 0; i < numI.length; i++) {
			if (numI.eq(i).prop("disabled") == true) {
				numI.eq(i).siblings('button').attr('disabled', true);
			}
		}
	});
}
function stepperInput(obj, s, m) {
	var num = $(".number"),
			 el = $(obj).parent(num).find("input");
	if (s > 0) {
		if (parseFloat(el.val()) < m) {
			el.val(parseFloat(el.val()) + s);
		}
	} else {
		if (parseFloat(el.val()) > m) {
			el.val(parseFloat(el.val()) + s);
		}
	}
}

/* bootstrap modal - multiple & drag issues */
(function($, window) {
	'use strict';

	var MultiModal = function(element) {
		this.$element = $(element);
		this.modalCount = 0;
	};

	MultiModal.BASE_ZINDEX = 1040;

	MultiModal.prototype.show = function(target) {
		var that = this;
		var $target = $(target);
		var modalIndex = that.modalCount++;
		$target.css('z-index', MultiModal.BASE_ZINDEX + (modalIndex * 10) + 1);
		// Bootstrap triggers the show event at the beginning of the show function and before
		// the modal backdrop element has been created. The timeout here allows the modal
		// show function to complete, after which the modal backdrop will have been created
		// and appended to the DOM.
		window.setTimeout(function() {
			// we only want one backdrop; hide any extras
			if(modalIndex > 0)
				$('.modal-backdrop').not(':first').addClass('hidden');
			that.adjustBackdrop();
		});
		//Reset drag position 
		$target.find(".modal-dialog").css({
			top: 0,
			left: 0
		});
	};

	MultiModal.prototype.hidden = function(target) {
		this.modalCount--;
		if(this.modalCount) {
			this.adjustBackdrop();
			// bootstrap removes the modal-open class when a modal is closed; add it back
			$('body').addClass('modal-open');
		}
	};

	MultiModal.prototype.adjustBackdrop = function() {
		var modalIndex = this.modalCount - 1;
		$('.modal-backdrop:first').css('z-index', MultiModal.BASE_ZINDEX + (modalIndex * 10));
	};

	function Plugin(method, target) {
		return this.each(function() {
			var $this = $(this);
			var data = $this.data('multi-modal-plugin');
			if(!data)
				$this.data('multi-modal-plugin', (data = new MultiModal(this)));
			if(method)
				data[method](target);
		});
	}

	$.fn.multiModal = Plugin;
	$.fn.multiModal.Constructor = MultiModal;
	$(document).on('show.bs.modal', function(e) {
		$(document).multiModal('show', e.target);
	});
	$(document).on('hidden.bs.modal', function(e) {
		$(document).multiModal('hidden', e.target);
	});

}(jQuery, window));


/* bootstrap modal - close all */
function modalCloseAll() {
	$('.modal').modal('hide');
}

/* form: Multiselect load */
function multiSelectLoad() {
	var $multiselect = $('.multi_select > select');
	for (var i = 0; i < $multiselect.length; i++) {
		var $multiselect_wrap = $multiselect.eq(i).parent('.multi_select');
		if ($multiselect_wrap.hasClass('select_all') && $multiselect_wrap.hasClass('search')){
			$multiselect.eq(i).multiselect({
				// includeResetOption: true,
				// enableClickableOptGroups: true,
				includeSelectAllOption: true,
				enableFiltering: true,
				enableCaseInsensitiveFiltering: true,
				selectAllNumber: false,
				buttonTextAlignment: 'left'
			});
		} else if ($multiselect_wrap.hasClass('select_all')){
			$multiselect.eq(i).multiselect({
				// includeResetOption: true,
				// enableClickableOptGroups: true,
				includeSelectAllOption: true,
				selectAllNumber: false,
				buttonTextAlignment: 'left'
			});
		} else if ($multiselect_wrap.hasClass('search')){
			$multiselect.eq(i).multiselect({
				// includeResetOption: true,
				// enableClickableOptGroups: true,
				enableFiltering: true,
				enableCaseInsensitiveFiltering: true,
				buttonTextAlignment: 'left'
			});
		} else {
			$multiselect.eq(i).multiselect({
				buttonTextAlignment: 'left'
			});
		}
	}
	var $btn_toggle =  $('.multiselect.dropdown-toggle');
	for (var i = 0; i < $btn_toggle.length; i++) {
		$btn_toggle.eq(i).off();
		$btn_toggle.eq(i).on('click', function() {
			multiSelectPosition($(this));
		});
	}
}
function multiSelectPosition(e) {
	var $container = e.next('.multiselect-container'),
			$scroll_top = window.scrollY || window.pageYOffset || (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop,
			$scroll_left = (document.documentElement && document.documentElement.scrollLeft) || document.body.scrollLeft,
			$top = e.offset().top - $scroll_top + e.outerHeight(),
			$left = e.offset().left - $scroll_left;
	$container.css({
		minWidth : $(e).outerWidth()
	});
	if ($(window).height() < $top + $container.outerHeight()){
		$container.css({
			top : $top - $container.outerHeight() - e.outerHeight(), 
			left : $left
		});
	} else {
		$container.css({
			top : $top, 
			left : $left
		});
	};
	if ($(window).width() < $left + $container.outerWidth()){
		$container.css({
			left : $left - $container.outerWidth() + $container.parent('.btn-group').outerWidth()
		});
	};
}
function multiSelectReposition() {
	if($('.multi_select').find('.btn-group').hasClass('show')){
		multiSelectPosition($('.btn-group.show').find('.multiselect.dropdown-toggle'));
	}
}

/* tooltip */
function tooltipLoad() {
	$('[data-toggle="tooltip"]').tooltip();
}

/* dropdown */
function dropdownLoad() {
	$('.dropdown > .dropdown-menu, .dropup > .dropdown-menu, .dropleft > .dropdown-menu, .dropright > .dropdown-menu').click(function(e){
		e.stopPropagation();
	})
	$('.dropdown-menu .btn_close').click(function() {
		$(this).closest('.dropdown, .dropup, .dropleft, .dropright').find('[data-toggle="dropdown"]').dropdown('toggle');
	});
}

/* form focus out [scroll, drag : z-index, position issue]: date+time picker, select, multi select, tooltip, dropdown */
// 필요시 해당하는 부분만 사용하면 됨 
function formBlur() {
	var $datetimebox = $('.time_input input, .time_sec_input input, .month_input input, .date_input input, .datetime_input input, .datetime_sec_input input'), // native date, time
			$selectbox = $('.select select'), // native select
			$tooltip = $(".tooltip.show")
			$dropdown = $(".dropdown-menu.show"); // multiselect, dropdown
	if($datetimebox.length > 0){
		$datetimebox.blur();
	}
	if($selectbox.length > 0){
		$selectbox.blur();
	}
	if($tooltip.length > 0){
		$('[data-toggle="tooltip"]').tooltip('hide');
	}
	if($dropdown.length > 0){
		$dropdown.dropdown('toggle');
	}
}
function formBlurDrag() {
	$(".modal-header").on('mousedown', formBlur);
}

/* Tab menu */
function tabMenu() {
	// 초기화 — 첫 번째 탭과 첫 번째 탭에 연관된 탭 패널 활성화
	$('.tabs > .tablist > button:first-of-type')
		.addClass('on')
		.attr('aria-selected', 'true')
		.attr('tabindex', '0');
	$('.tabs > .tablist').next('.tabpanel').addClass('on');

	// 탭 초점 이동(방향키), 탭 활성화(Space/Enter)
	$(".tabs > .tablist > button").on("keydown", function(event){
		event = event || window.event;
		event.preventDefault ? event.preventDefault() : event.returnValue = false;
		var keycode = event.keyCode || event.which;

		switch(keycode){
			case 37:  // left arrow
			case 38:  // up arrow
				if(this.previousElementSibling){
					$(this)
						.attr("tabindex", "-1")
					.prev()
						.attr("tabindex", "0")
						.focus();
				}else{
					// 초점이 첫 번째 요소에 있었다면, 마지막 탭으로 초점 이동
					$(this)
						.attr("tabindex", "-1");
					$(this).parent().find('> button:last-of-type')
						.attr("tabindex", "0")
						.focus();
				}
				break;
			case 39:  // right arrow
			case 40:  // down arrow
				if(this.nextElementSibling){
					$(this)
						.attr("tabindex", "-1")
					.next()
						.attr("tabindex", "0")
						.focus();
				}else{
					// 초점이 마지막 요소에 있었다면, 첫 번째 탭으로 초점 이동
					$(this)
						.attr("tabindex", "-1");
					$(this).parent().find('> button:first-of-type')
						.attr("tabindex", "0")
						.focus();
				}
				break;

			case 36:  // home
				// 첫 번째 탭으로 초점 이동
				$(this)
					.attr("tabindex", "-1");
				$(this).parent().find('> button:first-of-type')
					.attr("tabindex", "0")
					.focus();
				break;
			case 35:  // end
				// 마지막 번째 탭으로 초점 이동
				$(this)
					.attr("tabindex", "-1");
				$(this).parent().find('> button:last-of-type')
					.attr("tabindex", "0")
					.focus();
				break;

			case 32:    // Space
			case 13:    // Enter
				// 선택된 탭 활성화
				$(this)
					.addClass("on")
					.attr("aria-selected", "true")
				// 기존 탭 비활성화
				.siblings()
					.removeClass("on")
					.attr("aria-selected", "false");
				// 연관된 탭 패널 활성화
				$("#" + $(this).attr("aria-controls"))
					.attr("tabindex", "0")
					.addClass("on")
				// 기존 탭 패널 비활성화
				.siblings(".tabpanel")
					.attr("tabindex", "-1")
					.removeClass("on");
				break;
		}
	});

	// 탭 패널 이동 — 활성화 된 탭에서 Tab키 누를 경우 연관된 탭 패널로 이동
	$(".tabs > .tablist").on("keydown", ".on", function(event){
		event = event || window.event;
		var keycode = event.keyCode || event.which;
	 
		// tab 키 눌렀을 때 (shift + tab은 제외)
		if(!event.shiftKey && keycode === 9){
			event.preventDefault ? event.preventDefault() : event.returnValue = false;
			$("#" + $(this).attr("aria-controls"))
				.attr("tabindex", "0")
				.addClass("on")
				.focus()
			.siblings(".tabpanel")
				.attr("tabindex", "-1")
				.removeClass("on");
		}
	});

	// 마우스 클릭에 대한 이벤트 핸들링
	$(".tabs > .tablist > button").on("click", function(){
		// 선택된 탭 활성화
		$(this)
			.addClass("on")
			.attr({
				"tabindex": "0",
				"aria-selected": "true"
			})
			.focus()
		// 기존 탭 비활성화
		.siblings()
			.removeClass("on")
			.attr({
				"tabindex": "-1",
				"aria-selected": "false"
			});
		// 연관된 탭 패널 활성화
		$("#" + $(this).attr("aria-controls"))
			.attr("tabindex", "0")
			.addClass("on")
		// 기존 탭 패널 비활성화
		.siblings(".tabpanel")
			.attr("tabindex", "-1")
			.removeClass("on");
	});
}

/* Accordion */
function accordionLoad() {
	// 초기화 — 활성화된 버튼의 연관된 패널 활성화
	var $btn_on = $('.accordion .btn_accordion.on');
	for (var i = 0; i < $btn_on.length; i++) {
		$('#' + $btn_on.eq(i).attr('aria-controls'))
		.addClass('on')
		.slideDown(200);
		// .show();
	}

	// 탭 초점 이동(Up/Down/Home/End), 탭 활성화(Space/Enter)
	$('.accordion .btn_accordion').on('keydown', function(event){
		event = event || window.event;
		var keycode = event.keyCode || event.which;

		switch(keycode){
			case 38:  // up arrow
				event.preventDefault ? event.preventDefault() : event.returnValue = false;
				if($(this).closest('.accordion').find('> *:nth-of-type(1) > button').is(':focus') == false){
					$(this).parent().prev().prev().find('> .btn_accordion')
						.focus();
				}else{
					// 초점이 첫 번째 요소에 있었다면, 마지막 탭으로 초점 이동
					$(this).closest('.accordion').find('> *:nth-last-of-type(1) > button')
						.focus();
				}
				break;
			case 40:  // down arrow
				event.preventDefault ? event.preventDefault() : event.returnValue = false;
				if($(this).closest('.accordion').find('> *:nth-last-of-type(1) > button').is(':focus') == false){
					$(this).parent().next().next().find('> .btn_accordion')
						.focus();
				}else{
					// 초점이 마지막 요소에 있었다면, 첫 번째 탭으로 초점 이동
					$(this).closest('.accordion').find('> *:nth-of-type(1) > button')
						.focus();
				}
				break;

			case 36:  // home
				event.preventDefault ? event.preventDefault() : event.returnValue = false;
				// 첫 번째 탭으로 초점 이동
				$(this).closest('.accordion').find('> *:nth-of-type(1) > button')
					.focus();
				break;
			case 35:  // end
				event.preventDefault ? event.preventDefault() : event.returnValue = false;
				// 마지막 번째 탭으로 초점 이동
				$(this).closest('.accordion').find('> *:nth-last-of-type(1) > button')
					.focus();
				break;
		}
	});


	// 마우스 클릭에 대한 이벤트 핸들링
	$('.accordion .btn_accordion').on('click', function(){
		if ($(this).hasClass('on')){
			// 선택된 버튼 비활성화
			$(this)
				.removeClass('on')
				.attr('aria-expanded', 'false');
			// 연관된 패널 비활성화
			$('#' + $(this).attr('aria-controls'))
				.removeClass('on')
				.slideUp(200);
		} else {
			if ($(this).closest('.accordion').hasClass('auto_collapse')){
				// 선택된 버튼 활성화
				$(this)
					.addClass('on')
					.attr('aria-expanded', 'true')
					.focus()
				// 기존 버튼 비활성화
				.parent().siblings().find('> .btn_accordion')
					.removeClass('on')
					.attr('aria-expanded', 'false');
				// 연관된 패널 활성화
				$('#' + $(this).attr('aria-controls'))
					.addClass('on')
					.slideDown(200)
				// 기존 패널 비활성화
				.siblings('.accordion_panel')
					.removeClass('on')
					.slideUp(200);
			} else {
				// 선택된 버튼 활성화
				$(this)
					.addClass('on')
					.attr('aria-expanded', 'true')
					.focus();
				// 연관된 패널 활성화
				$('#' + $(this).attr('aria-controls'))
					.addClass('on')
					.slideDown(200);
			}
		}
	});
}

/* LNB Navigation */
function navigationLNB() {
	// 현재 페이지 네비게이션 자동 active
	var curLocation_1 = $('.page_title > .path').find('.path_01').text().replace(/\s/g, ""),
			curLocation_2 = $('.page_title > .path').find('.path_02').text().replace(/\s/g, ""),
			curLocation_3 = $('.page_title > .path').find('.path_03').text().replace(/\s/g, ""),
			lnb = $('.lnb .navigation'),
			lnbMenu_1 = lnb.find('> li'),
			lnbMenu_2 = lnb.find('> li > ul > li'),
			lnbMenu_3 = lnb.find('> li > ul > li > ul > li');

	lnbMenu_1.each(function(){
		var _this = $(this),
			menuStr = _this.find('> a > span').text().replace(/\s/g, "");
		if(menuStr == curLocation_1){
			_this.addClass('active open');
		}
	});
	lnbMenu_2.each(function(){
		var _this = $(this),
			menuStr = _this.find('> a > span').text().replace(/\s/g, "");
		if(menuStr == curLocation_2){
			_this.addClass('active open');
		}
	});
	lnbMenu_3.each(function(){
		var _this = $(this),
			menuStr = _this.find('> a > span').text().replace(/\s/g, "");
		if(menuStr == curLocation_3){
			_this.addClass('active');
		}
	});

	//하위 메뉴가 있으면 클래스명 subDepth 자동 추가
	$('.lnb .navigation li:has(ul)').addClass('sub_depth'); 

	// 메뉴 클릭 fold, unfold
	$('.lnb .navigation li > a').on('click keypress', function(e){
		if ($(this).prop("onclick") != null) {
			return;
		}
		var $target = $(this).parent('li');
		event.preventDefault ? event.preventDefault() : event.returnValue = false;
		if (e.type === 'click' || e.keyCode == '32') { //spacebar keyboard
			if($target.hasClass('open') === false) {
				// console.log("focus, click");
				$(this).parent().parent().find('li').removeClass('open');
				$(this).parent().parent().find('ul').slideUp(200);
				if($(this).next('ul').length > 0) {
					$(this).parent('li').addClass('open');
					$(this).next('ul').slideDown(200);
				}
			} else {
				// console.log("click");
				$(this).parent('li').removeClass('open');
				$(this).next('ul').slideUp(200);
			}
		}
	});

	// header navigation button
	$(document).on('click', '.navi_btn', function(event){
		event.stopImmediatePropagation();

		var winW = window.innerWidth;
		if (winW > 1536){
			if ($(this).hasClass('min') === false) {
				$(this).addClass('min not_auto');
				$('.wrap').addClass('min_lnb');
			} else {
				$(this).removeClass('min not_auto');
				$('.wrap').removeClass('min_lnb');
			}
		} else {
			$('.lnb').toggleClass('open');
			$(this).removeClass('not_auto');
		}
	});

	// minNav(축소)일때 마우스 오버시 LNB open
	$(document).on('mouseover', '.min_lnb > .lnb', function(event){
		event.stopImmediatePropagation();
		$('.lnb').addClass('open');
	});
	$(document).on('mouseleave', '.min_lnb > .lnb', function(event){
		event.stopImmediatePropagation();
		$('.lnb').removeClass('open');
	});

	// lnb 제외한 영역 클릭하면 LNB 축소
	$('body').on('click', function(e){
		if (!$('.lnb').has(e.target).length) {
			if ($('.lnb').hasClass('open')){
				$('.lnb').removeClass('open');
			}
		}
	});
}
function minNav() {
	var winW = window.innerWidth,
			navBtn = $('.header .navi_btn');
	if (navBtn.hasClass('not_auto') === false) {
		if (winW < 1536){
			if(!$('.wrap').hasClass('min_lnb')) {
				$('.wrap').addClass('min_lnb');
				$('.header .navi_btn').addClass('min');
			}
		} else {
			if($('.wrap').hasClass('min_lnb')) {
				$('.wrap').removeClass('min_lnb');
				$('.lnb').removeClass('open');
				$('.header .navi_btn').removeClass('min');
			}
		}
	}
}

/* header - my info */
function userDropdown() {
	var $dropdown = $('.user_dropdown');

	// 알림 toggle 버튼 
	$('.header_link .user_btn').click(function(){
		$dropdown.toggle();
		// console.log('OK');
	});

	// noti를 제외한 영역 클릭하면 dropdown 닫기
	$('body').on('click', function(e){
		if (!$('.user_btn, .user_dropdown, .user_txt_btn, .user_dropdown').has(e.target).length) {
			if ($dropdown.css('display') == 'block'){
				$dropdown.toggle();
			}
		}
	});
}
