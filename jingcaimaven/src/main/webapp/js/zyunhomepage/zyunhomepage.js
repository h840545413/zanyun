$(function() {
	$('a[href*=#],area[href*=#]').click(
			function() {
				if (location.pathname.replace(/^\//, '') == this.pathname
						.replace(/^\//, '')
						&& location.hostname == this.hostname) {
					var $target = $(this.hash);
					$target = $target.length && $target
							|| $('[name=' + this.hash.slice(1) + ']');
				}
			});
});
$(function() {
	$("#zyhome").fullpage(
			{
				anchors : [ 'page1', 'page2', 'page3', 'page4', 'page5',
						'page6', 'page7' ],
				menu : '#menu'
			});
});

$("#zy").click(function() {
	$("#cp").addClass('active');
})
$(document).ready(function() {
	a();
	mouse();
	more();
	know1();
	know2();
	watchmore();
	down();
	enter();
	line();
});

function mouse() {
	var po = $(".ps1");
	po.mouseover(function() {
		$(this).children(".ps3").removeClass('display');
	});
	po.mouseout(function() {
		$(this).children(".ps3").addClass('display');
	});
}

function jpbutton1() {

	var show1 = $("#show1");
	var show2 = $("#show2");
	var standard = $("#standard");
	var cust = $("#cust");
	show1.removeClass('display');
	show2.addClass('display');
	standard.attr('src', '/jingcaimaven/images/jpfw/standard-click.png');
	cust.attr('src', '/jingcaimaven/images/jpfw/cust.png');
}
function jpbutton2() {

	var show1 = $("#show1");
	var show2 = $("#show2");
	var standard = $("#standard");
	var cust = $("#cust");
	show2.removeClass('display');
	show1.addClass('display');
	standard.attr('src', '/jingcaimaven/images/jpfw/standard.png');
	cust.attr('src', '/jingcaimaven/images/jpfw/cust-click.png');
}
function more() {
	var more = $("#more");
	more.mouseover(function() {
		alert(2);
		more.attr('src', '/jingcaimaven/images/caseshow/more-float.png');
	});
	more.mouseout(function() {
		more.attr('src', '/jingcaimaven/images/caseshow/more.png');
	});
}
function know1() {
	var knowmore = $("#knowmore1");
	knowmore.mouseover(function() {
		knowmore.attr('src', '/jingcaimaven/images/jpfw/knowmore-float.png');
	});
	knowmore.mouseout(function() {
		knowmore.attr('src', '/jingcaimaven/images/jpfw/knowmore.png');
	});

}
function know2() {
	var knowmore = $("#knowmore2");
	knowmore.mouseover(function() {
		knowmore.attr('src', '/jingcaimaven/images/jpfw/knowmore-float.png');
	});
	knowmore.mouseout(function() {
		knowmore.attr('src', '/jingcaimaven/images/jpfw/knowmore.png');
	});
}
function watchmore() {

	var watchmore = $("#watchmore");
	watchmore.mouseover(function() {
		watchmore.attr('src', '/jingcaimaven/images/rjxz/watchmore-click.png');
	});
	watchmore.mouseout(function() {
		watchmore.attr('src', '/jingcaimaven/images/rjxz/watchmore.png');
	});
}

function down() {
	var down = $("#down");
	down.mouseover(function() {
		down.attr('src', '/jingcaimaven/images/rjxz/down-click.png');
	});
	down.mouseout(function() {
		down.attr('src', '/jingcaimaven/images/rjxz/down.png');
	});
}
function enter() {
	var enter = $("#enter");
	enter.mouseover(function() {
		enter.attr('src', '/jingcaimaven/images/zyxt/enter-click.png');
	});
	enter.mouseout(function() {
		enter.attr('src', '/jingcaimaven/images/zyxt/enter.png');
	});
}

function line() {
	$("ul li").mouseover(function() {
		var line = $("header .menu .line");
		if (line.css("display") == "none")
			line.show();
		line.stop().animate({
			width : $(this).width(),
			left : parseInt($(this).position().left) + 16 + "px"
		}, 300);
	});
	$("#menu").mouseout(function() {
	
		var line = $("header .menu .line");
		if ($("#sy1").hasClass('active')) {
			line.stop().animate({
				left : "697px"
			});
		}
		if ($("#sy2").hasClass('active')) {
			line.stop().animate({
				left : "822px"
			});
		}
		if ($("#sy3").hasClass('active')) {
			line.stop().animate({
				left : "948px"
			});
		}
		if ($("#sy4").hasClass('active')) {
			line.stop().animate({
				left : "1074px"
			});
		}
		if ($("#sy5").hasClass('active')) {
			line.stop().animate({
				left : "1199px"
			});
		}
		if ($("#sy6").hasClass('active')) {
			line.stop().animate({
				left : "1325px"
			});
		}
		if ($("#sy7").hasClass('active')) {
			line.stop().animate({
				left : "1451px"
			});
		}
	});
}

function a() {
	$(window).mousewheel(
			function() {
				if ($('body').hasClass('fp-viewing-page1-0')) {
					$("#masthead").removeClass("float-header"), $(".logo")
							.removeClass("float-logo"), $(".hotline")
							.removeClass("float-hotline");
				} else {
					$("#masthead").addClass("float-header"), $(".logo")
							.addClass("float-logo"), $(".hotline").addClass(
							"float-hotline");
				}
				var line = $("header .menu .line");
				if ($("#sy1").hasClass('active')) {
					line.stop().animate({
						left : "697px"
					});
				}
				if ($("#sy2").hasClass('active')) {
					line.stop().animate({
						left : "822px"
					});
				}
				if ($("#sy3").hasClass('active')) {
					line.stop().animate({
						left : "948px"
					});
				}
				if ($("#sy4").hasClass('active')) {
					line.stop().animate({
						left : "1074px"
					});
				}
				if ($("#sy5").hasClass('active')) {
					line.stop().animate({
						left : "1199px"
					});
				}
				if ($("#sy6").hasClass('active')) {
					line.stop().animate({
						left : "1325px"
					});
				}
				if ($("#sy7").hasClass('active')) {
					line.stop().animate({
						left : "1451px"
					});
				}
			});

	$(".s1").click(
			function() {
				$("#masthead").removeClass("float-header"), $(".logo")
						.removeClass("float-logo"), $(".hotline").removeClass(
						"float-hotline");
			})
	$(".s2").click(
			function() {
				$("#masthead").addClass("float-header"), $(".logo").addClass(
						"float-logo"), $(".hotline").addClass("float-hotline");
			})
	/*
	 * $(window).scroll(function() { var t = $(this).scrollTop(); t >= e ?
	 * (i(".site-header").addClass("fixed"), $("body").addClass("siteScrolled")) :
	 * ($(".site-header").removeClass("fixed"),
	 * $("body").removeClass("siteScrolled")), t >= 207 ?
	 * ($("#masthead").addClass("float-header"),$(".logo").addClass("float-logo"),$(".hotline").addClass("float-hotline")) :
	 * ($("#masthead").removeClass("float-header"),$(".logo").removeClass("float-logo"),$(".hotline").removeClass("float-hotline"));
	 * });
	 */
	$(".ha").click(function() {
		var line = $("header .menu .line");
		if ($("#sy1").hasClass('active')) {
			line.stop().animate({
				left : "697px"
			});
		}
		if ($("#sy2").hasClass('active')) {
			line.stop().animate({
				left : "822px"
			});
		}
		if ($("#sy3").hasClass('active')) {
			line.stop().animate({
				left : "948px"
			});
		}
		if ($("#sy4").hasClass('active')) {
			line.stop().animate({
				left : "1074px"
			});
		}
		if ($("#sy5").hasClass('active')) {
			line.stop().animate({
				left : "1199px"
			});
		}
		if ($("#sy6").hasClass('active')) {
			line.stop().animate({
				left : "1325px"
			});
		}
	})
}
/*
 * function zy(){ $('body').removeClass("fp-viewing-0-0");
 * $('body').addClass("fp-viewing-1-0"); }
 */

