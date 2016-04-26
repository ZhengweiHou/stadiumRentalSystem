<%@page import="com.hzw.StadiumRentalSystem.entity.Operator"%>
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
<title>操作员添加</title>
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
	<form id="operatorfrom" class="easyui-form" method="post"
		data-options="novalidate:false">
		<table cellpadding="5">
			<tr>
				<td>用户名:</td>
				<td><input class="easyui-textbox" type="text" name="name"
					data-options="required:true"></input></td>
			</tr>
			<!-- <tr>
				<td>编号:</td>
				<td><input class="easyui-textbox" type="text" name="number"
					data-options="required:true"></input></td>
			</tr> -->
			<tr>
				<td>密码:</td>
				<td><input id="pwd" class="easyui-textbox" type="password"
					name="password"
					data-options="required:true,validType:'length[6,9]'"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input id="rpwd" class="easyui-textbox" type="password"
					name="rpwd"
					data-options="required:true,validType:['equals[\'#pwd\']','length[6,9]']" /></td>
			</tr>
			<tr>
				<td>角色:</td>
				<td><input id="role" name="roleId" required="required" /></td>
			</tr>


		</table>
		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton addOpBtn">确认添加</a>
		</div>
	</form>



	<script type="text/javascript">
	
	$(function() {
		// extend the 'equals' rule
		$.extend($.fn.validatebox.defaults.rules, {
			equals : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '输入新密码不一致'
			}
		});

		$(".addOpBtn").click(function() {
			submitForm();
		});
		
		$('#role').combobox({    
		    url:'role!getRoles.action',    
		    valueField:'id',    
		    textField:'name'
		});  
		
	});
	
	function submitForm(){
		$('#operatorfrom').form('submit', {
			url : 'operator!addOperator.action',
			onSubmit : function() {
				return $(this).form('validate');
			},
			dataType : "json", 
			success : function(data) {
				var json = eval("(" + data + ")");
				if(json.result=="0"){
					alert(json.msg);
				}
				else if(json.result=="1"){
					alert(json.msg);
					parent.$('#operatorGrid').datagrid('reload');
				}
			}
		});
	}
	
	</script>
</body>


</html>

