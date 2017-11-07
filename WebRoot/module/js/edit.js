//编辑后确认提交
function edit(){
	//获取学生信息
	let stuClassNumber = document.getElementById("stuClassNumber").value;
	let stuName = document.getElementById("stuName").value;
	let stuNumber = document.getElementById("stuNumber").value;
	let age = document.getElementById("age").value;
	
	//对修改后的信息进行校检
	if(stuClassNumber.trim() == "" || stuClassNumber == null){
		alert("请输入学号！");
	}else if(stuName.trim() == "" || stuName == null){
		alert("请输入姓名！");
	}else if(stuNumber=="" || stuNumber==null || isNaN(stuNumber)){
		alert("请输入数字！");
	}else{
		$.ajax({
			url:"http://localhost:8080/struts/updateStudent.action?stuClassNumber=" + stuClassNumber + "&stuName=" + stuName + "&age=" + age + "&stuNumber=" + stuNumber,//请求地址
			type:"POST",
			success:function(){
				//alert("搜索成功！");
				window.location.href = "http://localhost:8080/struts/module/html/search.jsp";
			}
		})
	}
	
	
}	


//放弃编辑学生信息
function cancel(){
	let stuClassNumber = document.getElementById("stuClassNumber").value;
	$.ajax({
		url:"http://localhost:8080/struts/getStudentsByClassNumber.action?classNumber=" + stuClassNumber,//请求地址
		type:"POST",
		async:"false",
		success:function(){
			//window.location.href = "http://localhost:8080/struts/module/html/search.jsp?edit=1&classNumber="+stuClassNumber;
			var f = document.createElement("form");
			document.body.appendChild(f);
			var i = document.createElement("input");
			i.type = "hidden";
			f.appendChild(i);
			i.value = stuClassNumber;
			i.name = "stuClassNumber";
			f.action = "http://localhost:8080/struts/getStudentsByClassNumber.action?stuClassNumber=" + stuClassNumber;
			f.submit();

		}
	})
}
