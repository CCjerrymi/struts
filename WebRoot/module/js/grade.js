window.onload = function(){
	//获取所有的班级信息
	var f = document.createElement("form");
	document.body.appendChild(f);
	f.action = "http://localhost:8080/struts/getAllGradeInfo.action";
	f.submit();
}