window.onload = function(){
  		let stuClassNumber = window.location.href.split("=")[1];
  		//alert(stuClassNumber);
  		document.getElementById("stuClassNumber").value = stuClassNumber;
  	}
  	
function cancel(){
  	window.location.href = "http://localhost:8080/struts/module/html/grade.jsp";
}