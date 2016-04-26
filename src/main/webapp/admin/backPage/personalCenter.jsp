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
	Operator op = (Operator) session.getAttribute("operator");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=bas%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
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
	用户名：<%=op.getName()%>，编号：<%=op.getId()%>，角色:<%=op.getRole().getName()%>
	<form id="personalfrom" class="easyui-form" method="post"
		data-options="novalidate:false">
		<table cellpadding="5">
			<tr>
				<td>用户名:</td>
				<td><input class="easyui-textbox" type="text" name="name"
					data-options="required:true" value="<%=op.getName()%>"></input></td>
			</tr>
			<tr>
				<td>编号:</td>
				<td><input class="easyui-textbox" type="text" name="number"
					data-options="required:true" value="<%=op.getId()%>"
					readonly="readonly"></input></td>
			</tr>

			<tr>
				<td>原密码:</td>
				<td><input id="oldPwd" class="easyui-textbox" type="password"
					name="oldpwd"
					data-options="required:true,validType:'length[6,9]'"></input></td>
			</tr>



			<tr>
				<td>新密码:</td>
				<td><input id="newPwd" name="newpwd" type="password"
					class="easyui-textbox" data-options="required:true,validType:['unequals[\'#oldPwd\']','length[6,9]']"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input id="rpwd" name="rpwd" type="password"
					class="easyui-textbox" required="required"
					validType="equals['#newPwd']"></td>
			</tr>
		</table>
	</form>
	<div style="text-align: left; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton loginBtn">修改信息</a>
	</div>

	<script>
		$(function() {
			// extend the 'equals' rule
			$.extend($.fn.validatebox.defaults.rules, {
				equals : {
					validator : function(value, param) {
						return value == $(param[0]).val();
					},
					message : '输入新密码不一致'
				},
				unequals  : {
					validator : function(value, param) {
						return value != $(param[0]).val();
					},
					message : '新旧密码相同'
				}
			});

			$(".loginBtn").click(function() {
				submitForm();
			});
		});
		
		 function submitForm() {
				$('#personalfrom').form('submit', {
					url : 'operator!updateInfo.action',
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
						}
					}
				});
			}
	</script>
</body>

</html>

