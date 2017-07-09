var imgArr = new Array();

function reply() {
	$("#rep").attr("disabled", true);
	var urls = "reply.go";
	var endit = dataFrame();
	if(endit == "") {
		alert("内容不能为空");
		return;
	}
	if(vid == "") {
		alert("发表路径非法")
		return;
	}
	var param = {
		"endit": endit,
		"vid": vid,
		"fid": fid,
		"aArr": imgArr
	};
	$.ajax({
		type: "post",
		url: urls,
		async: true,
		traditional: true,
		data: param,
		success: function(json) {
			if(json.state == 0) {
				//刷新页面
				window.location.reload(true);
			} else {
				alert(json.message);
				$("#rep").removeAttr("disabled");
			}
		}

	});

}

function dataFrame() {
	var data1 = $("#endit").html().trim();

	data1 = data1.replace(/<div[^>]*>((<br>))([^<]*)<\/div>/gi, "\n");
	data1 = data1.replace(/<div[^>]*><\/div>/gi, "\n");
	data1 = data1.replace(/<p[^>]*>((<br>))([^<]*)<\/p>/gi, "\n");
	data1 = data1.replace(/<br(([ ]\/)|(\/)|)>/gi, "\n");

	data1.replace(/<div>([^<]*)<\/div>/gi, function(match) {
		var matchs = match;
		match = match.replace(/<div>/g, "");
		match = match.replace(/<\/div>/g, "\n");
		data1 = data1.replace(matchs, match);
	});

	data1.replace(/<img [^>]*src=['"]([^'"]+)[^>]*>/gi, function(match) {
		match.replace(/name=['"].*\d['"]/gi, function(matchs, capture) {
			matchs = matchs.replace(/\"/g, "");
			matchs = matchs.replace("name=", "");
			data1 = data1.replace(match, '[img]' + matchs + '[/img]');
		})
	});
	return data1;
}

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
						$("#imageList").append('<div class="ImglistBox"><img  onclick="addDocument(' + returndata.data[i].aid + ')" class="' + classes + '"  src="static/image/Document.png" id="img"  /><br/><span class="filename">' + filename + '</span></div>');
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
	$("#endit").append('<div>[document]' + name + '[/document]</div>');
}
function buy(vid,price,mod,aid,rid){
	var param;
	if(mod=='post'){
		param={"vid":vid,"price":price,"mod":mod}
	}else{
		param={"vid":vid,"price":price,"mod":mod,"aid":aid,"rid":rid}
	}
	$.ajax({
		type:"post",
		url:"buy.go",
		async:true,
		data:param,
		success:function(json){
			if(json.state==0){
				if(json.data=='post'){
					location.reload();
				}else{
					location.resolveURL("AttachmentDownload.do?aid="+aid);
				}
			}else{
				alert(json.message);
			}
		}
	});
}
$(function() {

	var paging = $("#pagings");
	if(count == 1) {
		return;
	}
	$("#page").show();
	var start = 1;
	var end = page + 5;
	var message = '<span class="UpGobackPageButton"> <a href="index.do">返回</a></span>';
	if(page > 5) {
		start = page - 5;
		message = message + '<span class="UpGobackPageButton"> <a href="viewthread.go?vid=' + vid + '&fid=' + fid + '&page=1">1...</a></span>';
	}
	if(end > 500) {
		end = 500;
	}
	if(end > count) {
		end = count;
	}
	for(var i = start; i <= end; i++) {
		if(page != i) {
			message = message + '<a class="paging" href="viewthread.go?vid=' + vid + '&fid=' + fid + '&page=' + i + '" >' + i + '</a>';
		}
		if(page == i) {
			message = message + '<strong class="checkpaging">' + i + '</strong>';
		}

	}
	if(page < 500 && count > page) {
		message = message + '<span class="UpGobackPageButton"> <a href="viewthread.go?vid=' + vid + '&fid=' + fid + '&page=' + ++page + '" >下一页</a></span>';
	}
	var las = count;
	if(count > 500) {
		las = 500;
	}
	message = message + '<span class="UpGobackPageButton"> <a href="viewthread.go?vid=' + vid + '&fid=' + fid + '&page=' + las + '">末页</a></span>';
	paging.append(message);

})