/*const equalIteam=new Option("等于","0");
const containItem=new Option("包含","1");
const moreIteam=new Option("大于","3");
const greaterOrEqualIteam=new Option("大于等于","4");
const lessIteam=new Option("小于","5");
const lessOrEqualIteam=new Option("小于等于","6");*/
const equalIteam=new Option("等于","=");
const containItem=new Option("包含","like");
const moreIteam=new Option("大于",">");
const greaterOrEqualIteam=new Option("大于等于",">=");
const lessIteam=new Option("小于","<");
const lessOrEqualIteam=new Option("小于等于","<=");
const basePath="http://localhost:8080/struts/";
var argumentFlag = 0;


//页面加载时调用方法
window.onload=function(){
	//document.getElementById("upload").style.display = "hidden";
	//加载的时候获取参数默认参数的类型
	//解析连接，看是否是编辑修改的跳转
	
	argumentsChange();
}

function clickLoad(){
	document.getElementById("okUp").click();
	//upload
	document.getElementById("upload").style.visibility = "visible";
}

function argumentsChange(){
	console.log("页面调用js方法！");
	//获取下拉框中被选中的value
	let obj = document.getElementById("argumentsType");
	//获取被选中的下标
	let index = obj.selectedIndex;
	//获取选中文本
	let text = obj.options[index].text;
	console.log("获取到的text:" + text);
	//获取选中的值
	let value = obj.options[index].value;
	console.log("获取到的value:" + value);
	//清空下拉框中原有的选项
	clearSelects();
	chargeTheOp(value);
}

function chargeTheOp(value){
	//因为不同的元素范围不一样，所以需要动态创建下拉框中的内容
	let selectObj = document.getElementById("selects");
	if(value==="stuName" || value==="stuNumber"){
		//字符型:包含&等于	
		selectObj.options.add(containItem);
		selectObj.options.add(equalIteam);
		argumentFlag=0;//参数类型为字符型，校检输入值的时候需要
	}else if(value==="age"){
		//整型:大于&大于等于&小于&小于等于
		selectObj.options.add(moreIteam);
		selectObj.options.add(greaterOrEqualIteam);
		selectObj.options.add(lessIteam);
		selectObj.options.add(lessOrEqualIteam);
		argumentFlag=1;//参数类型为整型
	}else{

	}
}
//清空下拉框中的option
function clearSelects(){
	let selects=document.getElementById("selects");
	let length=selects.options.length;
	console.log("selectsde的长度为:" + length); 
	let index=0;

  	for(index=0;index<length;index++) {
  		console.log("selectsde的长度为:" + selects.options.length); 
  		console.log("移除option" + index);
  		//因为每移除一个option后,length都会改变,后面的option会往前移，所以不能使用selects.removeChild(selects.options[index]),
  		//而是每次都只移除第一个，知道全部移除，循环结束。难道这是一个坑？ 
        selects.removeChild(selects.options[0]);     
  }

}


//根据用户输入的条件进行信息查询
function searchResult(){
	//获取选中的option的value和text
	var conditionArgus=getSelectedById("argumentsType");//查找的元素
	var conditionOperator=getSelectedById("selects");//符号
	var conditionValue=document.getElementById("inputValue").value;//值

	var arguValue=conditionArgus.get("value");
	var operatValue=conditionOperator.get("value");
	
	console.log("输入的条件值为" + conditionValue);
	if(checkTheEnter(conditionValue)){
		//验证通过，向后台发送请求
		$.ajax({
			url:basePath+"search.action?arguValue=" + arguValue + "&operatValue=" + operatValue + "&conditionValue=" + conditionValue.trim(),//请求地址
			type:"POST",
			success:function(){
				//alert("搜索成功！");
				location.reload();
			}
		})
	}
}

//通过id获取下拉框中选中的值,返回map对象
function getSelectedById(selectId){
	let mySelect=document.getElementById(selectId);
	let selectedIndex=mySelect.selectedIndex;
	let selectedValue=mySelect.options[selectedIndex].value;
	let selectedText=mySelect.options[selectedIndex].text;
	
	let map=new Map();
	map.set("value",selectedValue);
	map.set("text",selectedText);
	return map; 
}

//参数校验
function checkTheEnter(enterValue){
	//return true;
	//考虑用正则表达式编写，但是教程看起来太头疼了，暂时放弃采用正则表达式校检的方式而采用简单的if判断
	//根据选择不同的参数对输入的值进行验证
	console.log("进行参数校检！参数为：" + enterValue);
	console.log("参数类型标志位:"+argumentFlag);
	
	let resultFlag = true;
	switch(argumentFlag){
		case 0:{
			//字符型
			console.log("参数类型为字符型");
			if(enterValue==""||enterValue==null){
				alert("请输入查找条件!");
				return false;
			}else{
				return true;
			}		
		}
		case 1:{
			//整型
			console.log("参数类型为整型");
			console.log(isNaN(enterValue));
			if(enterValue=="" || enterValue==null || isNaN(enterValue)){
				alert("请输入数字");
				return false;
			}
			else{
				return true;
			}
			
		}
		default:return false;
	}
  
}


//提供下载方法
function downLoad(){
/*	//获取文件名
	let fileName = document.getElementById("fileName").value;
	//获取文件格式
	let selects = document.getElementById("fileType");
	let index = selects.selectedIndex;//获取索引
	let text = selects.options[index].text;//获取选中的文本
	let value = selects.options[index].value;//获取选中值
	
	//对输入进行简单的校检
	if(fileName == null || fileName == ""){
		alert("请输入文件名！");
	}else{
		//验证通过后进行下载，请求后天接口，
		 传送下载结果
	}*/
	var link= $('<a href="'+$scope.url+'" target="_blank"></a>');
	link.get(0).click();
}


//提供上传方法
function upload(){
	
	let path = document.getElementById("okUp").value;
	if(path=="" || path == null) {
		alert("请选择文件！");
	}else{
		document.getElementById("fileForm").submit();
	}
}


//提供学生修改编辑功能函数
function edit(stuNumber){

/*	$.ajax({
		url:basePath+"getStudentByNumber.action?stuNumber = " + stuNumber,//请求地址
		type:"POST",
		success:function(){
			alert("搜索成功！");
			location.location.href = "edit.jsp";
		}
	})*/
	
	
	var f = document.createElement("form");
	document.body.appendChild(f);
	var i = document.createElement("input");
	i.type = "hidden";
	f.appendChild(i);
	i.value = stuNumber;
	i.name = "stuNumber";
	f.action = "http://localhost:8080/struts/getStudentByNumber.action";
	f.submit();
}


function deleteStu(stuNumber){
	var f = document.createElement("form");
	document.body.appendChild(f);
	var i = document.createElement("input");
	i.type = "hidden";
	f.appendChild(i);
	i.value = stuNumber;
	i.name = "stuNumber";
	f.action = "http://localhost:8080/struts/deleteStudentByNumber.action";
	f.submit();
	
}
function backToGrade(){
	window.location.href = "http://localhost:8080/struts/module/html/grade.jsp";
}
	

