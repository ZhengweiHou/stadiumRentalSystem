
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
<!DOCTYPE html>
<html>
<head>
<base href="<%=bas%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息</title>
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
<body class="easyui-layout" onload="pageLoad">
	<form id="stadiumfrom" class="easyui-form" method="post"
		data-options="novalidate:false">
		<input type="text" value="${param.id}" name="id"
			style="display: none;"></input>
		<table cellpadding="5">
			<tr>
				<td>id:</td>
				<td><input id="id" class="easyui-textbox" type="text"
					name="stadiumNumber" readonly="readonly"></input></td>
			</tr>
			<tr>
				<td>账户:</td>
				<td><input id="account" class="easyui-textbox" type="text"
					name="account" readonly="readonly"></input></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input id="name" class="easyui-textbox" type="text"
					name="name" readonly="readonly"></input></td>
			</tr>
			<tr>
				<td>电话:</td>
			<td><input id="tel" class="easyui-textbox" type="text"
				name="tel" readonly="readonly"></input></td>
			</tr>
			<tr>
				
			<td>生日:</td>
			<td><input id="birthday" class="easyui-datebox" type="text"
				name="birthday" ></input></td>
			</tr>
			<tr><td>邮箱
			:</td>
			<td><input id="mail" class="easyui-textbox" type="text"
				name="mail" readonly="readonly"></input></td>

			</tr>
			



		
		</table>
		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton updateBtn">确认修改</a>
		</div>
	</form>



	<script type="text/javascript">
		$(function() {
			<%-- var a = "<%=session.getAttribute("rowData")%>"; --%>

	       $.ajax({
	            type : "post",
	            url : 'member!gitMemberInfo.action',
	            data : {//设置数据
	                id : ${param.id},
	            },
	            dataType : "json",//设置需要返回的数据类型
	            success : function(data) {
	            	/* $("#id").val(data.id);
	            	$("#account").val(data.account);
	            	$("#birthday").val(data.memberInfo.birthday);
	            	$("#mail").val(data.memberInfo.mail);
	            	$("#name").val(data.memberInfo.name);
	            	$("#tel").val(data.memberInfo.tel); */
	            	
	            	/* $("#id").setValue(data.id);
	            	$("#account").attr("value","data.account");
	            	$("#tel").attr("value",data.memberInfo.tel); */
	            	
	            	$("#id").textbox("setValue", data.id);
	            	$("#account").textbox("setValue", data.account);
	            	$("#birthday").datebox("setValue", data.memberInfo.birthday);
	            	$("#mail").textbox("setValue", data.memberInfo.mail);
	            	$("#name").textbox("setValue", data.memberInfo.name);
	            	$("#tel").textbox("setValue", data.memberInfo.tel);
	            	/* $("#startDate").datebox("setValue", ""); */
	            	
	            	
	            	//alert(data.id+data.account+data.memberInfo.birthday+data.memberInfo.mail+data.memberInfo.name+data.memberInfo.tel);
	            	
				}
			}); 
			
	    	//alert("1231");
			//var a = ${rowData};
			//alert(a);	
			
			$(".updateBtn").click(function() {
				alert(${param.id});
			 	//submitForm(); 
			});

		});

	/* 	function submitForm() {
			$('#stadiumfrom').form('submit', {
				url : 'stadium!upDateStadium.action',
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
		} */
		
		function pageLoad(){
			alert(${param.id});
		}
	</script>
</body>


</html>

