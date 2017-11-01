window.onload = function(){
	
}

function getAllInfo(){
	//获取所有的班级信息
	//alert("here");
	/*var f = document.createElement("form");
	document.body.appendChild(f);
	f.action = "http://localhost:8080/struts/getAllGradeInfo.action";
	f.submit();*/
	
	alert("here");
	$.ajax({
		url:"http://localhost:8080/struts/getAllGradeInfo.action",//请求地址
		type:"POST",
		success:function(){
			alert("搜索成功！");
			window.location.href = "http://localhost:8080/struts/module/html/grade.jsp";
		}
	})
}

function getStudents(classNumber){
	$.ajax({
		url:"http://localhost:8080/struts/getStudentsByClassNumber.action?classNumber=" + classNumber,//请求地址
		type:"POST",
		success:function(){
			alert("搜索成功！");
			window.location.href = "http://localhost:8080/struts/module/html/search.jsp";
		}
	})
}


function addStudent(classNumber){
	window.location.href = "http://localhost:8080/struts/module/html/addStudent.jsp?stuClassNumber="+classNumber;
}