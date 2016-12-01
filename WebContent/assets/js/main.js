

function show_row(){
	$(".row-hidden").each(function(){
		$(this).slideDown("normal");
	});
	$(".btn-show-more").hide();
}
$(document).ready(function(){
	/*$("#detail .thumb").on("click", function(){
		var img = $(this).find("img");
		var src = $(img).attr("src");
		$("#show-img").attr("src", src);
		return false;
	});*/
	$("#detail .thumb").on("click", function(){
		var img = $(this).find("input");
		var src = $(img).val();
		$("#show-img").attr("src", src);
		return false;
	});

	$("#color-product .thumb").on('click',function(){
		$("#color").val($(this).attr("data"));
		return false;
	});

    var car_m_2 = $('#car_m_2').data('carousel');
	$("form .thumb").on("click", function(){
		if($(this).attr("data") == $(".scp-"+$(this).attr("data")).val()){
			car_m_2.slideTo($(".scp-"+$(this).attr("data")).parent().attr('data-index'));
		}

	});

	function resize(){
		$("#slide .carousel").attr("style", "width: 100%;height: " + ($( window ).width() / 3.3) + "px;")
	}
	$( window ).resize(function(){
		resize();
	});
	resize();
	$(".row-hidden").each(function(){
		$(this).hide();
	});
});