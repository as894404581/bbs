var imgArr = new Array();
//利用ajax上传附件
function upload() {
	//显示进度条
	$("#prog").show();
	//清空错误信息
	$('#error').html('');
	var xhr = new XMLHttpRequest();
	var formData = new FormData($("#uploadForm")[0]);
	//ajax上传进度
	xhr.upload.addEventListener("progress", uploadProgress, false);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var returndata = eval('(' + xhr.responseText + ')');

			if(returndata.state == 0) {
				for(var i = 0; i < returndata.data.length; i++) {
					console.log(returndata.data[i]);
					imgArr[imgArr.length] = returndata.data[i].aid;
					
					var url = returndata.data[i].attachment_url;
					var filename = returndata.data[i].attachment_formerly;
					var ext = url.split("\.")[1].toUpperCase();
					var classes = "listImgMax";
					if(ext == 'BMP' || ext == 'PNG' || ext == 'GIF' || ext == 'JPG' || ext == 'JPEG') {
						$("#imageList").append('<div class="ImglistBox"><img onclick="addImg(this,' + returndata.data[i].aid + ')" class="' + classes + '"  src="' + url + '" id="img"  /><br/><span class="filename">' + filename + '</span></div>');
					} else {
						$("#imageList").append('<div class="ImglistBox"><img  onclick="addDocument(' + returndata.data[i].aid + ')" class="' + classes + '"  src="static/image/Document.png" id="img"  /><br/><span class="filename">' + filename + '</span><br/>售价:<input type="text" name="price" style=" width: 20px;"/>&nbsp;阅读权限:<input type="text" name="access_rights" style=" width: 20px;"/></div>');
					}
				}
			}
			$('#prog').hide();
			$('#imageList').show();
		} else if(xhr.status == 500) {
			$('#error').html('上传文件超出大小,或服务器错误');
			$('#prog').hide();
		}
	};
	xhr.open("POST", "upload.do", true);
	xhr.send(formData);
}

//上传进度条显示
function uploadProgress(evt) {
	if(evt.lengthComputable) {
		var percentComplete = Math.round((evt.loaded) * 100 / evt.total);
		$("#percent").html(percentComplete + '%')
		$("#progresss").val(percentComplete)
		$("#progressNumber").css("width", "" + percentComplete + "px");

	}
}
//将图片从图片列表中添加到帖子中
function addImg(img, name) {
	$("#endit").append('<div><img style="width:60%;height:60%;" src="' + img.src + '"  name="' + name + '"/></div>');
}
//插入文件附件
function addDocument(name) {
	$("#endit").append('<div>[document]'+name+'[/document]</div>');
}
//发表帖子
function submitPost() {
	$("#sub").attr("disabled", true);
	var data1 = dataFrame();
	var titl = $('#titl').val().trim();
	if(titl.length > 50) {
		alert("标题长度过长!");
		$("#sub").attr("disabled", false);
		return;
	}

	if(titl == '') {
		alert("标题不能为空!")
		$("#sub").attr("disabled", false);
		return;
	}
	if(data1 == '') {
		alert("帖子内容不能为空!")
		$("#sub").attr("disabled", false);
		return;
	}
	var gIndex=$("#groupId ").get(0).selectedIndex;
	var price=$("#price").val();
	var param = {
		"text": data1,
		"titl": titl,
		"fid": fid,
		"aArr": imgArr,
		"gIndex":gIndex,
		"price":price
	};
	$.ajax({
		type: "post",
		url: "publish.go",
		async: true,
		traditional: true,
		data: param,
		success: function(json) {
			if(json.state == 0) {
				location.href = "viewthread.go?vid=" + json.data + "&fid=" + fid + "&page=1";
			} else {
				alert(json.message);
			}
		},
		error: function() {
			$("#sub").attr("disabled", false);
			alert("连接服务器异常")
		}
	});

}

function repUpdate() {
	var data1 = dataFrame();
	if(data1 == '') {
		alert("帖子内容不能为空!")
		$("#sub").attr("disabled", false);
		return;
	}
	$.ajax({
		type: "post",
		url: "repUpdate.go",
		async: true,
		traditional: true,
		data: { "fid":fid,"vid": vid, "rid": rid, "text": data1,"aArr":imgArr },
		success: function(json) {
			if(json.state == 0) {
				location.href = "viewthread.go?vid=" + vid + "&fid=" + fid + "&page=1";
			} else {
				alert(json.message)
			}
		},
		error: function() {
			alter("网络错误");
		}
	});
}

function postUpdate() {
	var data1 = dataFrame();
	var titl = $('#titl').val().trim();
	if(titl.length > 50) {
		alert("标题长度过长!");
		$("#sub").attr("disabled", false);
		return;
	}
	if(titl == '') {
		alert("标题不能为空!")
		$("#sub").attr("disabled", false);
		return;
	}
	if(data1 == '') {
		alert("帖子内容不能为空!")
		$("#sub").attr("disabled", false);
		return;
	}
	var gIndex=$("#groupId ").get(0).selectedIndex;
	var price=$("#price").val();
	var param = {
		"text": data1,
		"titl": titl,
		"fid": fid,
		"vid": vid,
		"aArr":imgArr,
		"gIndex":gIndex,
		"price":price
	};
	$.ajax({
		type: "post",
		url: "updatepost.go",
		data: param,
		async: true,
		traditional: true,
		success: function(json) {
			if(json.state == 0) {
				location.href = "viewthread.go?vid=" + vid + "&fid=" + fid + "&page=1";
			}
		},
		error: function() {
			alert("网络错误")
		}
	});
}

function dataFrame(){
	var data1 = $("#endit").html().trim();
	
	data1=data1.replace(/<div[^>]*>((<br>))([^<]*)<\/div>/gi,"\n");
	data1=data1.replace(/<div[^>]*><\/div>/gi,"\n");
	data1=data1.replace(/<p[^>]*>((<br>))([^<]*)<\/p>/gi,"\n");
	data1=data1.replace(/<br(([ ]\/)|(\/)|)>/gi,"\n");

	
	data1.replace(/<div>([^<]*)<\/div>/gi,function(match){
		var matchs=match;
		match=match.replace(/<div>/g,"");
		match=match.replace(/<\/div>/g,"\n");
		data1=data1.replace(matchs,match);
	});
	
	data1.replace(/<img [^>]*src=['"]([^'"]+)[^>]*>/gi, function(match) {
		match.replace(/name=['"].*\d['"]/gi,function(matchs,capture){
			matchs=matchs.replace(/\"/g,"");
			matchs=matchs.replace("name=","");
			data1=data1.replace(match,'[img]'+matchs+'[/img]');
		})
	});
	
	console.log(data1);
	return data1;
}
//判断是否是修改帖子信息
$(function() {
	if(type.trim() == "") {
		$("#sub").click(submitPost);
		$("#sub").val("发表");
		return;
	}
	if(type == "post") {
		$("#sub").click(postUpdate);
		$("#sub").val("修改");
		return;
	}
	if(type == "rep") {
		$("#sub").click(repUpdate);
		$("#sub").val("修改");
		return;
	}


})

