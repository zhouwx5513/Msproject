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
<form action="payorder">
商品名称：${msproductinfo.producttitle}
购买数量：${productnum}
支付总额：${payamount}
<input type="hidden" name="productid" value="${msproductinfo.productid}">
<input type="hidden" name="userid" value="${msuserid}">
<input type="hidden" name="merchantid" value="${msproductinfo.msmerchantid}">
<input type="hidden" name="payamount" value="${payamount}">
<input type="hidden" name="num" value="${productnum}">

收货人地址:<input type="text" name="receivingaddress"></br>
收货人电话:<input type="text" name="receivingphone"></br>
收货人名称:<input type="text" name="receivingname"></br>
<input type="button" value="立即付款" onclick="submit(this)"/>
</form>
</body>
<script type="text/javascript">
function submit(obj){
	obj.parent.sumbit();
}
</script>
</html>