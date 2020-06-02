var flag = true;
var pageNum=$("#pageNum").text();
var pages = $("#pages").text();

var pathName = window.location.pathname;

$(document).ready(function () {
});

function toBefore(){
	
	if(pageNum == 1)
	{
		alert("当前页已经是第一页了！！");
	}else{
		window.location.href=pathName+"?pageNum="+pageNum+"&flag=before";
	}
}

function toNext(){
	
	if(pages > pageNum){
		window.location.href=pathName+"?pageNum="+pageNum+"&flag=next"; 
	}else
	{
		alert("当前已经是最后一页了！！");
	}
	
}
