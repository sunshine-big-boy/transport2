$(function() {
	$('input').iCheck({
		checkboxClass : 'icheckbox_square-blue',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%' // optional
	});

});

function login() {

	var username = $("#username").val();
	var password = $("#password").val();

	if (username == null || username == '') {
		$("#message-block").html("请输入用户名！").css("color", "red");
		return;
	} else if (password == null || password == '') {
		$("#message-block").html("请输入密码！").css("color", "red");
		return;
	} else {

		$.ajax({
			type : 'POST',
			url : 'user/login',
			data : $("form").serializeString(),
			dataType : 'json',
			contentType : 'application/json;charset=UTF-8',
			success : function(data) {
				if (data.message == 'none') {
					$("#message-block").html("未找到该用户！").css("color", "red");
					$("#username").val("");
					$("#password").val("");
				} else if (data.message == 'noPass') {
					$("#message-block").html("输入密码错误！").css("color", "red");
					$("#password").val("");
				} else {
					$.cookie("username",username);
					window.location.href = data.url;
				}
			},
			error : function(err) {
				alert("出现错误，请联系管理员！");
			}
		});
	}

}


function toRegister() {

	window.location.href = "register.html";

}