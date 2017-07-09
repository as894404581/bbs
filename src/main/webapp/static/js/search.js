function showPage() {
	var paging=$("#paging");
	var count = PageCount;
	if(count == 1) {
		return;
	}
	var start = 1;
	var end = num + 5;
	var message = '<span class="UpGobackPageButton"> <a href="index.do">返回</a></span>';
	if(num > 5) {
		start = num - 5;
		message = message +
			'<span class="UpGobackPageButton"> <a href="javascript:;" onclick="page(1)">1...</a></span>';
	}
	if(end > 500) {
		end = 500;
	}
	if(end > count) {
		end = count;
	}
	for(var i = start; i <= end; i++) {
		if(num != i) {
			message = message +
				'<a class="paging" href="search.go?name='+SearchName+'&page='+i+'">' + i + '</a>';
		}
		if(num == i) {
			message = message +
				'<strong class="checkpaging">' + i +
				'</strong>';
		}

	}
	var las = count;
	if(count > 500) {
		las = 500;
	}
	if(num < 500 && count > num) {
		message = message +
			'<span class="UpGobackPageButton"> <a href="search.go?name='+SearchName+'&page='+(num + 1)+'">下一页</a></span>';
			message = message +'<span class="UpGobackPageButton"> <a href="search.go?name='+SearchName+'&page='+las+'">末页</a></span>';
	}
	
	paging.append(message);

}
window.onload = function() {
	showPage();
}

//根据变量名获取url传过来的参数
function getUrlParam (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!= null) {
        return unescape(r[2]);
    }else{
        return null;
    }
} 