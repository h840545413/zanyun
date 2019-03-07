function line() {
	$("#menu li").mouseover(function() {
		var line = $(".line");
		$(this).addClass("active");
		line.stop().animate({
			width : $(this).width(),
			left :(parseInt($(this).position().left)-($(document.body).width()*0.2+105))+ "px"}, 300);
	});
}

$(document).ready(function() {
	$("#zy").addClass("active");
	//line1();
});
