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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
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

	<!-- 头部 -->
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">
		用户名【
		<%=op.getName()%>】，角色【
		<%=op.getRole().getName()%>】 <a href="javascript:void(0)"
			onclick="logout()" class="easyui-linkbutton logoutBtn">logout</a>
	</div>

	<!-- 功能菜单 -->
	<div data-options="region:'west',split:true" style="width: 200px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="Title2">
				<ul>
					<li style="width: 90"><a href="#" class="easyui-linkbutton"
						onclick="addTab('personalCenter')"
						data-options="toggle:true,group:'g1',plain:true">个人中心</a></li>
					<li style="width: 90"><a href="#" class="easyui-linkbutton"
						onclick="addTab('operatorManager')"
						data-options="toggle:true,group:'g1',plain:true">操作员管理</a></li>
					<li style="width: 90"><a href="#" class="easyui-linkbutton"
						onclick="addTab('stadiumManager')"
						data-options="toggle:true,group:'g1',plain:true">运动场管理</a></li>
					<li style="width: 90"><a href="#" class="easyui-linkbutton"
						onclick="addTab('memberManager')"
						data-options="toggle:true,group:'g1',plain:true">会员管理</a></li>
					<li style="width: 90"><a href="#" class="easyui-linkbutton"
						data-options="toggle:true,group:'g1',plain:true,text:'hahaaah'"></a>
					</li>
				</ul>

			</div>
			<div title="Title3" style="padding: 10px">content3</div>
		</div>
	</div>

	<!-- 右侧副显示 -->
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>

	<!-- 页脚 -->
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">
		<table id=footer cellSpacing=0 cellPadding=0 width="100%" align=center
			border=0>
			<tbody>
				<tr>
					<td align=middle>
						<div align=center>Copyright@2007-2016 stadiumRentalSystem</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- 主显示区 -->
	<div data-options="region:'center'">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>
</body>

<script type="text/javascript">
	function logout(){
		$.messager.confirm("确认", "确认注销？", function (r) {  
	        if (r) {  
	        	window.location.href="operator!logout.action";  
	        }  
	    });    
	};
	
	function addTab(pagename){
		 //login1为Action类命名空间名称；AjaxExecute为Action方法名称
        $.ajax({
            type : "post",
            url : 'back!addTab.action',
            data : {//设置数据
                pagename : pagename,
            },
            dataType : "json",//设置需要返回的数据类型
            success : function(data) {
				if(data.result=="0"){
					alert(data.msg);
					}
				else if(data.result=="1"){
					var url = "<%=bas%>" + data.pageurl;
					doAddTab(url, data.pagetitle);
				}
			}
		});
	};
	function doAddTab(url, title) {
		if ($('#tabs').tabs('exists', title)) {
			$('#tabs').tabs('select', title);
			var currTab = $('#tabs').tabs('getSelected');
			$('#tabs').tabs('update', {
				tab : currTab,
				closable : true,
				options : {
					href : url
				}
			});
		} else {
			$('#tabs').tabs('add', {
				title : title,
				href : url,
				closable : true
			});
		}
	};
</script>
</html>

