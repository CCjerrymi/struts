//编辑后确认提交
function edit(){
	//获取学生信息
	let stuClassNumber = document.getElementById("stuClassNumber").value;
	let stuName = document.getElementById("stuName").value;
	let stuNumber = document.getElementById("stuNumber").value;
	let age = document.getElementById("stuAge").value;
	
	$.ajax({
		url:"http://localhost:8080/struts/updateStudent.action?stuClassNumber=" + stuClassNumber + "&stuName=" + stuName + "&age=" + age + "&stuNumber=" + stuNumber,//请求地址
		type:"POST",
		success:function(){
			//alert("搜索成功！");
			window.location.href = "http://localhost:8080/struts/module/html/search.jsp";
		}
	})
}	


//放弃编辑学生信息
function cancle(){
	
}