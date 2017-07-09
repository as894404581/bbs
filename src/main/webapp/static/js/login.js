//改变浏览器签页标题内容,显示登录div
function showLogin() {
	$('.register').css("display", "none");
	$('.login').css("display", "block");
	$('#log').addClass("cleck");
	$("#reg").removeClass();
	document.title = '登录';
}
//改变浏览器签页标题内容,显示注册div
function showReg() {
	$('.register').css("display", "block")
	$('.login').css("display", "none")
	$('#reg').addClass("cleck");
	$("#log").removeClass();
	document.title = '注册';

}

//使登录注册验证码同步
function loadimage() {
	var num = Math.random();
	document.getElementById("logNum").src = "number.jsp?" + num;
	document.getElementById("regNum").src = "number.jsp?" + num;

}

//检查邮箱是否符合要求 
function checkEmail(callback) {
	var reg1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(reg1.test(document.getElementsByName('regemail')[0].value)) {
		$("#lodEmail").css('display', 'block');
		var param = {
			email: document.getElementsByName('regemail')[0].value
		};
		var url = "ajax/checkEmail.do";
		$.ajax({
			type: "post",
			url: url,
			data: param,
			async: true,
			success: function(data) {
				if(data) {
					check = true;
					document.getElementsByName('regemail')[0].style.border = "solid 1px #00cc33";
					$('#regerror').html("");

				} else {
					document.getElementsByName('regemail')[0].style.border = "solid 1px red";
					$('#regerror').html("邮箱已被使用");

				}
				$("#lodEmail").css('display', 'none');
			}

		});

	} else {
		document.getElementsByName('regemail')[0].style.border = "solid 1px red";
		$('#regerror').html("邮箱不合法");

		return false;
	}
}
//检查用户名是否符合要求
function checkUser(callback) {

	var reg2 = /^([\w]{6,20})/;
	if(reg2.test(document.getElementsByName('reguser')[0].value)) {
		$("#lodUser").css('display', 'block');
		var param = {
			user: document.getElementsByName('reguser')[0].value
		};
		var url = "ajax/checkUser.do";

		$.ajax({
			type: "post",
			url: url,
			data: param,
			async: true,
			success: function(data) {
				if(data) {

					document.getElementsByName('reguser')[0].style.border = "solid 1px #00cc33";
					$('#regerror').html("");
				} else {
					document.getElementsByName('reguser')[0].style.border = "solid 1px red";
					$('#regerror').html("用户名已被使用");
				}
				$("#lodUser").css('display', 'none');
			}
		});

	} else {
		document.getElementsByName('reguser')[0].style.border = "solid 1px red";
		if($("#user").val() == "") {
			$('#user').prop('type', 'text').val("字母数字下划线,至少6位");
		}
		$('#regerror').html("用户名不符合要求");
		return false;
	}

}
//清除登录账号文本框提示内容
function clearLogUser() {
	if($("#logUser").val() == "用户名或邮箱") {
		$("#logUser").val("");
	}
}

function addMess() {
	if($("#logUser").val() == "") {
		$("#logUser").val("用户名或邮箱");
	}
}
//清除文本框提示内容
function clearPass() {

	if($('#pass').is(":text")) {
		$('#pass').val("");
		$('#pass').prop('type', 'password');
	}

}
//清除文本框提示内容
function clearUser() {
	if($("#user").val() == "字母数字下划线,至少6位") {
		$("#user").val("");

	}
}
//检查密码是否符合要求
function checkPwdCheck() {
	var reg2 = /^([\w]{6,20})/;

	if(reg2.test(document.getElementsByName('regpwd')[0].value)) {
		document.getElementsByName('regpwd')[0].style.border = "solid 1px #00cc33";
		if(document.getElementsByName('regpwd')[0].value == document.getElementsByName('regpwd')[1].value) {
			document.getElementsByName('regpwd')[1].style.border = "solid 1px #00cc33";
			$('#regerror').html("");
			return true;
		} else {
			document.getElementsByName('regpwd')[1].style.border = "solid 1px red";
			if($("#pass").val() == "") {
				$('#pass').prop('type', 'text').val("字母数字下划线,至少6位");
			}
			$('#regerror').html("两次密码不一致");
			return false;
		}
	} else {
		document.getElementsByName('regpwd')[0].style.border = "solid 1px red";
		document.getElementsByName('regpwd')[1].style.border = "solid 1px red";
		if($("#pass").val() == "") {
			$('#pass').prop('type', 'text').val("字母数字下划线,至少6位");
		}
		$('#regerror').html("密码不符合要求");
		return false;
	}

}
//注册提交
function regSubmit() {
	$("#regSub").attr("disabled", true);
	$.ajax({
		cache: true,
		type: "POST",
		url: "ajax/regUser.do",
		timeout: 0,
		data: $('#regf').serialize(), 
		async: true,
		error: function(request) {
			alert("服务器错误");
			$("#regSub").removeAttr("disabled");
		},
		success: function(data) {
			if(data.state == 1) {
				loadimage();
				alert(data.message)
				$("#regSub").removeAttr("disabled");

			} else {
				alert(data.data);
				location.href = "index.do";
			}
		}
	});

}
//登录提交
function loginSub() {
	$("#logSub").attr("disabled", true);
	$.ajax({
		cache: true,
		type: "POST",
		url: "ajax/log.do",
		timeout: 0,
		data: $('#logf').serialize(), // 你的formid
		async: true,
		error: function(request) {
			alert("服务器连接失败");
			$("#logSub").removeAttr("disabled");
		},
		success: function(data) {
			if(data.state == 0) {
				location.href = "index.do";
			} else {
				if(data.errorCode==05){
					like=window.confirm(data.message+",是否重新发送邮件?");
					if(like==true){
						resendEmail();
						$("#logSub").removeAttr("disabled");
						loadimage();
						return;
					}
				}
				alert(data.message)
				loadimage();
				$("#logSub").removeAttr("disabled");
			}
		}
	});
}
function resendEmail(){
	var user=$("#logUser").val();
	console.log(user);
	$.ajax({
		type:"post",
		url:"resendEmail.do",
		data:{"user":user},
		async:true,
		success:function(data){
			if(data.state==0){
				alert("重发邮件成功,请前往邮箱激活!");
			}else{
				alert("发送邮件失败!请联系管理员");
				alert(data.message)
			}
		}
	});
}

//根据url值改变登录注册
$(function() {

		if(getType("type") == 'log') {
			$('.register').css("display", "none");
			$('.login').css("display", "block");
			$('#log').addClass("cleck");
			$("#reg").removeClass();
		} else {
			$('.register').css("display", "block")
			$('.login').css("display", "none")
			$('#reg').addClass("cleck");
			$("#log").removeClass();
		}
		
		
		
		
	})
	//获取url参数
function getType(key) {
	var url = location.search.replace(/^\?/, '').split('&');
	var paramsObj = {};
	for(var i = 0, iLen = url.length; i < iLen; i++) {
		var param = url[i].split('=');
		paramsObj[param[0]] = param[1];
	}
	if(key) {
		return paramsObj[key] || '';
	}
	return paramsObj;
}