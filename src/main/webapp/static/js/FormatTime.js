function formatTime() {
	var time = $(".time");
	for(var i = 0; i < time.length; i++) {
		if($(time[i]).html() == null || $(time[i]).html() == '') {
			continue;
		}
		var str=$(time[i]).html();
		str=str.replace("t","");
		var times = parseInt(str);
		console.log(str);
		//alert($(time[i]).html());
		$(time[i]).html(formats(times));

	}
}
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
		//console.log(times);
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
formatTime();
