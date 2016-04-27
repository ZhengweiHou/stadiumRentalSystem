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
<title>运动场添加</title>
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/demo/demo.css">
<script type="text/javascript" src="<%=bas%>/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body class="easyui-layout">
	<form id="stadiumfrom" class="easyui-form" method="post"
		data-options="novalidate:false">
		<table cellpadding="5">
			<tr>
				<td>场地编号:</td>
				<td><input class="easyui-textbox" type="text"
					name="stadiumNumber" data-options="required:true"></input></td>
			</tr>
			<tr>
				<td>单价/时:</td>
				<td>
					<input class="easyui-numberbox" type="text" name="price" value="0" precision="2" max="99999.99"
					size="8" maxlength="8" data-options="required:true"></input>
				</td>
			</tr>


			<tr>
				<td>可用性:</td>
				<td>
					<input type="radio" checked="checked" name="avaliable" value="0" />可用 
					<br /> 
					<input type="radio" name="avaliable" value="1" />不可用
				</td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><input class="easyui-textbox" type="text"
					name="descriptions" /></td>
			</tr>



		</table>
		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton addStadiumBtn">确认添加</a>
		</div>
	</form>



	<script type="text/javascript">
		$(function() {
			
			$(".addStadiumBtn").click(function() {
				submitStadiumFrom(); 
			});

		});

		function submitStadiumFrom() {
			$('#stadiumfrom').form('submit', {
				url : 'stadium!addStadium.action',
				onSubmit : function() {
					return $(this).form('validate');
				},
				dataType : "json",
				success : function(data) {
					var json = eval("(" + data + ")");
					if (json.result == "0") {
						alert(json.msg);
					} else if (json.result == "1") {
						alert(json.msg);
						parent.$('#stadiumGrid').datagrid('reload');
					}
				}
			});
		}
	</script>
</body>


</html>

