
<%@page import="com.hzw.StadiumRentalSystem.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String bas = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ bas + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=bas%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单</title>
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/demo/demo.css">
<script type="text/javascript" src="<%=bas%>/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<%
	Order order = (Order) session.getAttribute("order");
%>
<body>
	<table cellpadding="5" border="1">
		<tr>
			<td>场地编号</td>
			<td>用户</td>
			<td>电话</td>
			<td>日期</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>时长(小时)</td>
			<td>单价</td>
			<td>折扣</td>
			<td>总价</td>
		</tr>
		<tr>
			<td><%=order.getStadium().getId() %></td>
			<td><%=order.getMember().getAccount()%></td>
			<td><%=order.getMember().getMemberInfo().getTel()%></td>
			<td><%=order.getDestineDay()%></td>
			<td><%=order.getStartTime()%></td>
			<td><%=order.getEndTime()%></td>
			<td><%=order.getTotalTime()%></td>
			<td><%=order.getPrice()%></td>
			<td><%=order.getRebate()%></td>
			<td><%=order.getTotal()%></td>
		</tr>


	</table>
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton ensureOrderBtn">确认订单</a>
		<a href="javascript:void(0)" class="easyui-linkbutton cancelOrderBtn">取消订单</a>
	</div>



	<script type="text/javascript">
	$(function() {

		$(".ensureOrderBtn").click(function() {
			 $.ajax({
	                type : "post",
	                url : 'order!ensureOrder.action',
	                dataType : "json",//设置需要返回的数据类型
	                success : function(data) {
	    				 if(data.result=="1"){
	    					 alert(data.msg);
	    				 }else if(data.result=="0"){
	    					 alert(data.msg);
	    				 }
	    					 

	    			}
	    		});
		});

	});
	</script>
</body>


</html>

