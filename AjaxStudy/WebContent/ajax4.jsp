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
window.onload = function() {  //文档加载完毕后执行
	var btn = document.getElementById("btn");
	btn.onclick = function() {  //给按钮的点击事件注册监听
		//ajax四步操作：
		//1、得到异步对象XMLHttpRequest
		var xmlHttp = createXMLHttpRequest();
		//2、打开与服务器的连接
		xmlHttp.open("GET","/AjaxStudy/BServlet",true);
		//3、发送请求
		xmlHttp.send(null);  //GET请求没有请求体，但也必须要给null
		//4、给异步对象的onreadystatechange事件注册监听器
		xmlHttp.onreadystatechange = function() {    //当xmlHttp的状态发生变化时执行
			//双重判断：xmlHttp的状态为4(服务器响应结束)以及服务器的响应的状态码为200(服务器响应成功)
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				//获取服务器的响应结果(xml)
				var doc = xmlHttp.responseXML;
				//查询xml文档下名为student的所有元素，得到数组，并取下标为0的
				var student = doc.getElementsByTagName("student")[0];
				//获取元素名为name的属性值
				var number = student.getAttribute("number");  
				//获取student元素下name、age、sex元素的值
				var name;
				var age;
				var sex;
				
				if(window.addEventListener){
					name = student.getElementsByTagName("name")[0].textContent;  //其他浏览器都支持
					age = student.getElementsByTagName("age")[0].textContent;  //其他浏览器都支持
					sex = student.getElementsByTagName("sex")[0].textContent;  //其他浏览器都支持
				}else{
					name = student.getElementsByTagName("name")[0].text;  //IE支持
					age = student.getElementsByTagName("age")[0].text;  //IE支持
					sex = student.getElementsByTagName("sex")[0].text;  //IE支持
				}
				var text = number + "、" + name + "、" + age + "、" + sex;
				document.getElementById("h1").innerHTML = text;
			}	
		};
	};
};
	</script>
</head>
<body>
	<button id="btn">点击这里</button>
	<h1 id="h1"></h1>

</body>
</html>