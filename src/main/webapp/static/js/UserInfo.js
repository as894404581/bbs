function Change(mods){
	window.history.pushState({}, 0, "userInfo.do?mods=" + mods );
	var arr=getByClass('a');
	for(var i =0;i<arr.length;arr++){
		arr[i].className="";
	}
	document.getElementById(mods).className="a";
	$('#result').load("loadUserSetting.do",{"mods":mods});
}
window.onload=function(){
	Change(mods);
}

function getByClass(sClass){
    var aResult=[];
    var aEle=document.getElementsByTagName('*');
    for(var i=0;i<aEle.length;i++){
       /*当className相等时添加到数组中*/
       if(aEle[i].className==sClass){
            aResult.push(aEle[i]);
        }
    }
    return aResult;
}