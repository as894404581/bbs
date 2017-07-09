function search(){
	var text=$("#searchInput").val();
	if(''==$.trim(text)){
		$("#SearchError").html("请写搜索关键字!");
		return;
	}
	window.location.href="search.go?name="+text+"&page=1"; 
	
}

