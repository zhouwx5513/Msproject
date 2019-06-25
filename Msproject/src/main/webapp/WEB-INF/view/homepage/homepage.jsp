<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
欢迎：${msuser.useraccount}
<a href="/Msproject/userregiterloginAction/toregiter">注册</a></br>
<a href="/Msproject/userregiterloginAction/tologin">登录</a>
<a href="/Msproject/userregiterloginAction/exit">退出登录</a>
<a href="/Msproject/orderAction/queryorderbyuserid">订单查询</a>
<table border="2">
<tr>
		<td>商品标题</td>
		<td>图片地址</td>
		<td>秒杀价格</td>
		<td>秒杀原价</td>
		<td>秒杀开始时间</td>
		<td>秒杀结束时间</td>
		<td>操作</td>
	</tr>

	<c:forEach items="${list}" var="item">
		<tr>
		<td>${item.producttitle}</td>
		<td>${item.productpicture}</td>
		<td>${item.miaoshaprice}</td>
		<td>${item.originalprice}</td>
		<td><fmt:formatDate value="${ item.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
		<td><fmt:formatDate value="${ item.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
		<td><a href="viewproductdetail?id=${item.id}&productid=${item.productid}">查看</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>