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
		//ajax四步操作，得到服务器的响应
		//把响应结果显示到xml文件中
		//1、得到异步对象XMLHttpRequest
		var xmlHttp = createXMLHttpRequest();
		//2、打开与服务器的连接
		//第一个参数：指定请求方式
		//第二个参数：指定请求的URL
		//第三个参数：指定是否为异步请求
		xmlHttp.open("GET","/AjaxStudy/AServlet",true);
		//3、发送请求
		xmlHttp.send(null);  //GET请求没有请求体，但也必须要给null
		//4、给异步对象的onreadystatechange事件注册监听器
		xmlHttp.onreadystatechange = function() {    //当xmlHttp的状态发生变化时执行
			//双重判断：xmlHttp的状态为4(服务器响应结束)以及服务器的响应的状态码为200(服务器响应成功)
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				//获取服务器的响应结果
				var text = xmlHttp.responseText;
				//获取h1元素
				var h1 = document.getElementById("h1");
				h1.innerHTML = text;
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