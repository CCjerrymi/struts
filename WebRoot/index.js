const basePath="http://localhost:8080/struts/";
//验证输入的用户名和密码，不能为空且长度在3~10


function login(){
	let userName = document.getElementById("userName").value;
	let password = document.getElementById("password").value;
	
	console.log("userName" + userName);
	console.log("password" + password);
	if(checkValue(userName,password)){
		//想后台提交数据
		$.ajax({
			url:basePath+"login.action?userName=" + userName + "&password=" + password,
			type:"GET",
			success:function(result){
				alert(result);
				if(result=="success"){
					//跳轉頁面
					windown.location.href=basePath + "/module/html/search.jsp";
				}
			}
		})
	}
	
}



function checkValue(userName,password){
	if(userName==null || password==null ||userName=="" || password==""){
		alert("请输入用户名或密码!");
		return false;
	}
	
	let len = password.length;
	if(len < 3 || len > 10){
		alert("密码长度为3~10");
		return false;
	}
	
	return true;
}