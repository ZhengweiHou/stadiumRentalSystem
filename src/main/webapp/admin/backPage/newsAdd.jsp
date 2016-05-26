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
<title>添加公告</title>
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
<body class="easyui-layout">
	<form id="newsfrom" class="easyui-form" method="post"
		data-options="novalidate:false">
		<table cellpadding="5">
			<tr>
				<td>标题:</td>
				<td><input class="easyui-textbox" type="text" name="title"
					data-options="required:true"></input></td>
			</tr>
			<tr>
				<td>内容:</td>
				<td>
					<%-- <TEXTAREA  NAME="content" ROWS="20" COLS="10">123</TEXTAREA>	
				<FCK:editor id="infoContent" basePath="<%=bas%>/FCKeditor/"
		              width="550"
		              height="400"
		              skinPath="<%=bas%>/FCKeditor/editor/skins/silver/"
		              defaultLanguage="zh-cn"
		              tabSpaces="8"
		              imageBrowserURL="<%=bas%>/FCKeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector"
		              linkBrowserURL="<%=bas%>/FCKeditor/editor/filemanager/browser/default/browser.html?Connector=connectors/jsp/connector"
		              flashBrowserURL="<%=bas%>/FCKeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector"
		              imageUploadURL="<%=bas%>/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Image"
		              linkUploadURL="<%=bas%>/FCKeditor/editor/filemanager/upload/simpleuploader?Type=File"
		              flashUploadURL="<%=bas%>/FCKeditor/editor/filemanager/upload/simpleuploader?Type=Flash">
      			</FCK:editor>   --%> <!--<input class="easyui-textbox" type="text" name="content" data-options="required:true"></input>  -->
					<input class="easyui-textbox" name="content" data-options="multiline:true,required:true"
					style="width: 300px; height: 100px">

				</td>
			</tr>


			<tr>
				<td>显示:</td>
				<td><input type="radio" checked="checked" name="showstatu"
					value="0" />显示 <br /> <input type="radio" name=showstatu
					value="1" />不显示</td>
			</tr>



		</table>
		<div style="text-align: left; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton addNewsBtn">确认添加</a>
		</div>
	</form>



	<script type="text/javascript">
		$(function() {

			$(".addNewsBtn").click(function() {
				submitNewsFrom();
			});

		});

		function submitNewsFrom() {
			$('#newsfrom').form('submit', {
				url : 'news!addNews.action',
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
						parent.$('#newsGrid').datagrid('reload');
					}
				}
			});
		}
	</script>
</body>


</html>

