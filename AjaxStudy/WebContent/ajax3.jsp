<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
//创建异步对象XMLHttpRequest
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();    //支持大多数浏览器
	} catch (e) {
		try {
			return ActiveXObject("Msxml2.XMLHTTP");    //支持IE6.0
		} catch (e) {
			try {
				return ActiveXObject("Microsoft.XMLHTTP");    //支持IE5.5以及更早版本
			} catch (e) {
				alter("哥们儿，您用的是什么浏览器？！");
				throw e;
			}
		}
	}
}
window.onload = function() {
	//1、获取文本框对象，给失去焦点事件注册监听
	var userEle = document.getElementById("usernameEle");
	userEle.onblur = function(){
		//1、得到异步对象
		var xmlHttp = createXMLHttpRequest();
		//2、打开连接
		xmlHttp.open("POST","/AjaxStudy/ValidateUsernameServlet",true);
		//3、设置请求头
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//4、发送请求，给出请求体
		xmlHttp.send("username="+userEle.value);   //userEle.value 是文本框的内容
		//5、给xmlHttp的onreadystatechange事件注册监听
		xmlHttp.onreadystatechange = function(){
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {  //双重判断
				//获取服务器的响应，判断是否是1
				var text = xmlHttp.responseText;
				var span = document.getElementById("errorSpan");
				if(text == "1"){
					//是：获取span，添加内容"用户名已被注册"
					span.innerHTML = "用户名已被注册！";
				}else{
					span.innerHTML = "";
				}
			}
		};
	};
};
</script>

</head>
<body>

<h1>用户名是否被注册</h1>
<form action="" method="post">
用户名:<input type="text" name="username" id="usernameEle" /><span id="errorSpan"></span><br/>
密    码:<input type="password" name="password" /><br/>
<input type="submit" value="注册" />
</form>

</body>
</html>