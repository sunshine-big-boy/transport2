$(function() {
	$('input').iCheck({
		checkboxClass : 'icheckbox_square-blue',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%' // optional
	});
});


function register(){
	
	var username = $("#username").val();
	var password = $("#password").val();
	var password2 = $("#password2").val();
	
	
	if(username==null || username == ''){
		$(".login-box-msg").html("请输入用户名！").css("color", "red");
		return ;
	}
	if(password==null || password == ''){
		$(".login-box-msg").html("请输入密码！").css("color", "red");
		return ;
	}
	if(password2==null || password2 == ''){
		$(".login-box-msg").html("请输入确认密码！").css("color", "red");
		return ;
	}
	if(password != password2){
		$(".login-box-msg").html("两次输入的密码不一致，请重新输入！").css("color", "red");
		return ;
	}

	$.ajax({
		type : 'POST',
		url : 'user/register',
		data : $("form").serializeString(),
		dataType : 'json',
		contentType : 'application/json;charset=UTF-8',
		success : function(data) {
			if (data.message == 'exist') {
				$(".login-box-msg").html("该用户名已经存在，请重新输入！").css("color", "red");
				$("#username").val("");
				$("#password").val("");
				$("#password2").val("");
			} else{
				window.location.href = "main.html?username="+username;
			}
		},
//		 error: function(XMLHttpRequest, textStatus, errorThrown) {
//			 alert(XMLHttpRequest.status);
//			 alert(XMLHttpRequest.readyState);
//			 alert(textStatus);
//		}
		error : function(){
			alert("系统出错，请联系管理员！");
		}
			
	});	
	
	
	
	
	
	
}