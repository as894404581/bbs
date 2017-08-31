function formats1min(times) {
	var Inter_Min = parseInt(((times).toFixed(2) / 1000));
	return Inter_Min + " 秒前"
}

function formats60min(times) {
	var Inter_Min = parseInt(((times).toFixed(2) / 60000));
	return Inter_Min + " 分钟前"
}

function formats24hour(times) {
	var Inter_Hour = parseInt(((times).toFixed(2) / 3600000));
	return Inter_Hour + " 小时前"
}
//将long的时间转为 距离几天 详细时间()
function formats7day(times, timesn) {
	var today = new Date();
	today.setHours(0);
	today.setMinutes(0);
	today.setSeconds(0);
	today.setMilliseconds(0);
	var Inter_Days = parseInt(((times).toFixed(2) / 86400000)+1);
	if(Inter_Days <= 2) {
		if(timesn < today.getTime() - 86400000) {
			return "前天 " + format(timesn, "HH:mm");
		} else if(timesn < today.getTime()) {
			return "昨天 " + format(timesn, "HH:mm");
		}
	}

	return parseInt(Inter_Days) + " 天前";
}

function formats(times) {

	var timeDifference = (new Date().getTime() - times);
	if(timeDifference < 60000) {
		return formats1min(timeDifference);
	} else if(timeDifference < 3600000) {
		return formats60min(timeDifference);
	} else if(timeDifference < 86400000) {
		return formats24hour(timeDifference);
	} else if(timeDifference < 604800000) {
		return formats7day(timeDifference, times);
	} else {
		return format(times, "yyyy-MM-dd")
	}
}
//将时间毫秒数转换为指定格式时间
var format = function(time, format) {

		var t = new Date(time);
		var tf = function(i) {
			return(i < 10 ? '0' : '') + i
		};
		return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a) {
			switch(a) {
				case 'yyyy':
					return tf(t.getFullYear());
					break;
				case 'MM':
					return tf(t.getMonth() + 1);
					break;
				case 'mm':
					return tf(t.getMinutes());
					break;
				case 'dd':
					return tf(t.getDate());
					break;
				case 'HH':
					return tf(t.getHours());
					break;
				case 'ss':
					return tf(t.getSeconds());
					break;
			}
		})
	}
	//使用ajax查询帖子列表
function ajaxPage() {
	var count = pageCount;
	var data = {
		"fid": fid,
		"page": page
	};
	var paging = $("#paging");
	paging.empty();
	var tbody = $("#mess table tbody");
	tbody.empty();
	tbody.append("<tr><td colspan='5'  style='text-align: center;' ><img src='static/image/lod.gif' width='30px' height='30px' /></td></tr>");
	$.ajax({
		type: "get",
		url: "forumAjaxPost.go",
		data: data,
		async: true,
		success: function(json) {
			if(json.state == 0) {
				tbody.empty();

				if(json.data.length == 0) {

					tbody.append('<tr><td colspan="5">此板块暂无帖子</td></tr>');
					return;
				}
				for(var i = 0; i < json.data.length; i++) {
					var trdata = '<tr><td style="text-align:center" width="5%" >'
					+'<a href="viewthread.go?vid=' + json.data[i].id + '&fid=' + fid + '&page=1" target="_blank"> <img src="static/image/ISSUE.png" /></a></td><td width="55%">'
					+'<a href="viewthread.go?vid=' + json.data[i].id + '&fid=' + fid + '&page=1">' + json.data[i].title + '</a></td><td width="15%"><span>' + json.data[i].author.user + '</span><br/><span class="time">'+formats(json.data[i].issue_time)+'</span></td><td width="10%"><em>' + json.data[i].reply_count + '</em><br/><em class="time">'+json.data[i].see_count+'</em></td>'
					+'<td width="20%"><em>' + json.data[i].last_ue.user + '</em><br/><em class="time">'+formats(json.data[i].last_reply_issue_time)+'</em></td></tr>';
					tbody.append(trdata);
				}
				if(count == 1) {
					return;
				}
				var start = 1;
				var end = page + 5;
				var message = '<span class="UpGobackPageButton"> <a href="index.do">返回</a></span>';
				if(page > 5) {
					start = page - 5;
					message = message + '<span class="UpGobackPageButton"> <a href="javascript:;" onclick="lodForumPage(1)">1...</a></span>';
				}
				if(end > 500) {
					end = 500;
				}
				if(end > count) {
					end = count;
				}
				for(var i = start; i <= end; i++) {
					if(page != i) {
						message = message + '<a class="paging" href="javascript:;" onclick="lodForumPage(' + i + ')">' + i + '</a>';
					}
					if(page == i) {
						message = message + '<strong class="checkpaging">' + i + '</strong>';
					}

				}
				var las = count;
				if(count > 500) {
					las = 500;
				}

				if(page < 500 && count > page) {
					message = message + '<span class="UpGobackPageButton"> <a href="javascript:;" onclick="lodForumPage(' + (page + 1) + ')">下一页</a></span>';
					message = message + '<span class="UpGobackPageButton"> <a href="javascript:;" onclick="lodForumPage(' + las + ')">末页</a></span>';
				}

				paging.append(message);
				
			} else {
				alert(json.message);
			}
		},
		error: function() {
			alert("请求失败,请刷新页面!");
		}
	});
}

function lodForumPage(pagen) {
	page = pagen;
	window.history.pushState({}, 0, "forum.go?fid=" + fid + "&page=" + page);
	ajaxPage();
}

window.onload = function() {
	if(postCount!=0){
		ajaxPage();
	}
}