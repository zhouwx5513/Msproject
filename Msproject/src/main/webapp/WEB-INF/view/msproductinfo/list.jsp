<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><a href="toApplymsproduct">申请秒杀商品</a></center>
<table border="2">
	<tr>
		<td>商品id</td>
		<td>商品标题</td>
		<td>图片地址</td>
		<td>秒杀价格</td>
		<td>商家id</td>
		<td>秒杀原价</td>
		<td>申请时间</td>
		<td>审核状态</td>
		<td>秒杀开始时间</td>
		<td>秒杀结束时间</td>
		<td>秒杀商品数</td>
		<td>库存</td>
		<td>商品描述</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
		<td>${item.productid }</td>
		<td>${item.producttitle }</td>
		<td>${item.productpicture }</td>
		<td>${item.miaoshaprice }</td>
		<td>${item.msmerchantid }</td>
		<td>${item.originalprice }</td> 
		<td><fmt:formatDate value="${ item.applydate }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
<td>
<c:if test="${item.auditstate=='1'}">审核已通过</c:if>
<c:if test="${item.auditstate=='2'}">审核未通过</c:if>
<c:if test="${item.auditstate=='0'}">未审核</c:if>
</td>
		<td><fmt:formatDate value="${ item.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
		<td><fmt:formatDate value="${ item.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
		<td>${item.productcount }</td>
		<td>${item.stockcount }</td>
		<td>${item.description }</td>
		<td><a href="toupdatemsproduct?id=${item.id}">修改</a>||<a href="deletemsproductByid?id=${item.id}">删除</a>||<a href="querymsproductByid?id=${item.id}">查看</a>||<a href="toupdatemsproductstate?id=${item.id}">审核</a>
		||<a href="/Msproject/msproductDetailAction/toinsertMsproductdetail?productid=${item.productid}&&merchantid=${item.msmerchantid}">添加商品详情</a>||<a href="/Msproject/msproductDetailAction/queryMsproductdetailByid?productid=${item.productid}">查看商品详情</a>||<a href="/Msproject/msproductDetailAction/toupdateMsproductdetail?productid=${item.productid}">修改商品详情</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>