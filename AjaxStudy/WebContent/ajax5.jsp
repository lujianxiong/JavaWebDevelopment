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
//在文档加载完毕时发送请求，得到所有省份名称，显示在<select name="province"/>中
window.onload = function(){
	//ajax四步
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.open("GET","/AjaxStudy/ProvinceServlet",true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			//获取服务器的响应
			var text = xmlHttp.responseText;
			//使用逗号分隔，得到数组
			var arr = text.split(",");
			//循环遍历每个省份名称，每个名称生成一个option对象，添加到<select>中
			for(var i=0;i<arr.length;i++){
				var op = document.createElement("option");  //创建一个指定名称的元素
				op.value = arr[i];  //设置op的实际值value为当前省份名
				var textNode = document.createTextNode(arr[i]);  //创建文本节点
				op.appendChild(textNode);    //op元素添加子节点-文本节点
				document.getElementById("p").appendChild(op);
			}
		}
	};
	
	//给<select name="province">添加“改变监听”
	var proSelect = document.getElementById("p");
	proSelect.onchange = function(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("POST","/AjaxStudy/CityServlet",true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttp.send("pname="+proSelect.value);  //把下拉列表中选择的值发送给服务器
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				//把select中的所有option元素移除（除了请选择）
				var citySelect = document.getElementById("c");
				//获取citySelect中所有子元素
				var optionEleList = citySelect.getElementsByTagName("option");
				//循环遍历每个option元素，然后在citySelect中移除
				while(optionEleList.length > 1){  //子元素的个数如果>1就循环
					citySelect.removeChild(optionEleList[1]);  //总是移除第二个，第二个删除了，第三个就是第二个了，依次删除，最后留下0下标的！
				}
				
				var doc = xmlHttp.responseXML;  //接受CityServlet发送的xml文件
				//得到所有名为city的元素
				var cityEleList = doc.getElementsByTagName("city");
				//循环遍历每个city元素
				for (var i = 0; i < cityEleList.length; i++) {
					var cityEle = cityEleList[i];  //得到每个city元素
					var cityName;
					//获取市名称
					//处理在不同浏览器上获取xml元素内容不兼容的问题
					if (window.addEventListener) {
						cityName = cityEle.textContent;  //支持主流浏览器
					}else {
						cityName = cityEle.text;  //支持IE浏览器
					}
					//使用市名称创建option元素，添加到<select name="city">中
					var op = document.createElement("option");
					op.value = cityName;
					//创建文本节点
					var textNode = document.createTextNode(cityName);
					op.appendChild(textNode);  //把文本节点追加到op元素中
					//把op添加到<select name="city">元素中
					citySelect.appendChild(op);
				}
			}
		};
	};
};

</script>

</head>
<body>
<h1>省市联动</h1>

<select name="province" id="p">
	<option>===请选择省===</option>
</select>
   
<select name="city" id="c">
	<option>===请选择市===</option>
</select>

</body>
</html>