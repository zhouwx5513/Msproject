<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add">
	秒杀商品的id: ${msproductinfo.productid }</br>
		秒杀商品的标题: ${msproductinfo.producttitle }</br>
		秒杀商品的图片地址: ${msproductinfo.productpicture }</br>
		秒杀商品价格: ${msproductinfo.miaoshaprice }</br>
		商家的id: ${msproductinfo.msmerchantid }</br>
		商品原价: ${msproductinfo.originalprice }</br>
		秒杀商品的申请时间: <fmt:formatDate value="${ msproductinfo.applydate }" pattern="yyyy-MM-dd HH:mm:ss"/></br>
		秒杀商品的审核状态:
<c:if test="${msproductinfo.auditstate=='1'}">审核已通过</br></c:if>
<c:if test="${msproductinfo.auditstate=='2'}">审核未通过</br></c:if>
<c:if test="${msproductinfo.auditstate=='0'}">未审核</br></c:if>
		秒杀商品的审核时间: <fmt:formatDate value="${ msproductinfo.auditdate }" pattern="yyyy-MM-dd HH:mm:ss"/></br>
		秒杀的开始时间: <fmt:formatDate value="${ msproductinfo.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/></br>
		秒杀的结束时间: <fmt:formatDate value="${ msproductinfo.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/></br>
		秒杀数量: ${msproductinfo.productcount }</br>
		秒杀的库存: ${msproductinfo.stockcount }</br>
		秒杀的描述: ${msproductinfo.description }</br>
</form>
</body>
</html>