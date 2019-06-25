<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><a href="toadd">添加商家</a></center>
<table border="2">
	<tr>
		<td>支付金额</td>
		<td>订单生成时间</td>
		<td>支付转态</td>
		<td>收货人地址</td>
		<td>收货人电话</td>
		<td>收货人名称</td>
		<td>交易流水号</td>
		<td>购买数量</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.payamount }</td>
			<td><fmt:formatDate value="${ item.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/></br></td>
			<td>${item.paystatus }</td>
			<td>${item.receivingaddress }</td>
			<td>${item.receivingphone }</td>
			<td>${item.receivingname }</td>
			<td>${item.tradeserialnumber }</td>
			<td>${item.num }</td>
			<td><c:if test="${item.paystatus == 1 }"><a href="topaywithorder?id=${item.id}&&tradeserialnumber=${item.tradeserialnumber}&&payamount=${item.payamount}">继续支付</a></c:if><c:if test="${item.paystatus == 2 }">支付完成<input type="button" value="发起退款" onclick="applyrefund('${item.id}','${item.paytype}')"></c:if><c:if test="${item.paystatus == 3 }">退款成功</c:if><c:if test="${item.paystatus == 4 }">退款申请中</c:if><c:if test="${item.paystatus == 5 }">退款申请不成功</c:if></td>
		</tr>
	</c:forEach>
</table>
<script type="text/javascript">
	function applyrefund(orderid,paytype){
		window.location.href="applyrefund?orderid="+orderid+"&&paytype="+paytype;
	}
</script>
</body>
</html>