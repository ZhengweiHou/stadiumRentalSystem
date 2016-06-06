<%@page import="com.hzw.StadiumRentalSystem.entity.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String bas = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ bas + "/";
%>
<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>images/css.css" type=text/css rel=stylesheet>
<link href="<%=basePath%>images/default.css" type=text/css
	rel=stylesheet>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>

<script language=JavaScript src="<%=basePath%>images/Common.js"></script>
<script language=JavaScript src="<%=basePath%>images/index.js"></script>
<script language=JavaScript src="<%=basePath%>images/calendar.js"></script>


<!-- //////////头文字特效////////// -->
<style type="text/css">
.milky {
	text-transform: uppercase;
	font-size: 20px;
	color: #f1ebe5;
	text-shadow: 0 8px 9px #c4b59d, 0px -2px 1px #fff;
	font-weight: bold;
	text-align: center;
	background: linear-gradient(to bottom, #ece4d9 0%, #e9dfd1 100%);
	border-radius: 5px;
	margin: 0;
	padding: 0；
}
</style>
<!-- //////////////////// -->
</head>


<body text=#000000 leftMargin=0 topMargin=0>
	<div width="960" align=center topMargin=0>
		<h1>欢迎使用HZW体育馆场地租赁系统</h1>
	</div>
	<div id="indexWin"></div>
	<!--****************主菜单开始****************-->
	<div class="nav" align="center" topMargin=0>
		<ul>
			<li><a href="<%=basePath%>" name="navurl" target="">首 页</a></li>
			<%-- <li><a href="<%=basePath%>" name="navurl" target="">场馆介绍</a></li>
			<li><a href="<%=basePath%>" name="navurl" target="">新闻信息</a></li> --%>
			<li><a href="<%=basePath%>client/stadiumreservation.jsp"
				name="navurl" target="">场地预定</a></li>
			<%
				Member member = (Member) session.getAttribute("member");
				if (member != null) {
			%>
			<li><a href="<%=basePath%>client/mOrder.jsp"
				name="navurl" target="">个人订单</a></li>
			<%
				}
			%>
			<!-- <li><a href="admin/login.jsp" target="">管理员登陆</a></li>  -->
			<li style="margin-left: 20%;">
				<%
					if (member == null) {
				%> <a style="color: red;" href="javascript:void(0)"
				onclick="loginWin()" target="">未登录</a> <%
 	} else {
 %> <a
				style="color: blue;" href="javascript:void(0)" target="">用户<%=member.getAccount()%>已登录
			</a> <a style="color: red;" href="javascript:void(0)" onclick="logout()"
				target="">注销 </a> <%
 	}
 %>
			</li>

		</ul>

	</div>

	<!--****************主菜单结束****************-->


	<script language="javascript">
	
	function loginWin(){

	 	$('#indexWin').window({
            width: 500,
            height: 200,
            modal: true,
            href: "<%=bas%>/client/mlogin.jsp",
			title : "用户登录"
   		});
	}
	
	function registWin(){
		$('#indexWin').window({
            width: 500,
            height: 400,
            modal: true,
            href: "<%=bas%>/client/mregister.jsp",
			title : "用户注册"
   		}); 
	}
	
	function logout(){
		$.messager.confirm("确认", "确认退出登录？", function (r) {  
	        if (r) {  
	        	// 用户注销
	             $.ajax({
	                type : "post",
	                url : 'member!logout.action',
	                dataType : "json",//设置需要返回的数据类型
	                success : function(data) {
	    				 if(data.result=="1"){
	    					 alert(data.msg);
	    					 location.href="<%=bas%>";
	    				 }else if(data.result=="0"){
	    					 location.href="<%=bas%>";
								alert(data.msg);

							}
						}
					});
				}
			});
		}

		function nav() {
			var url = document.URL;
			var urls = document.getElementsByName("navurl");
			for ( var i = 0; i < urls.length; i++) {
				if (urls[i] == url) {
					urls[i].parentNode.className = 'select';
					return;
				}
			}
			urls[0].parentNode.className = 'select';
		}
		nav();
		// jQuery	
		$(function() {
			var a1 = document.URL;
			var a2 = $(".nav_other a");
			for ( var i = 0; i < a2.length; i++) {
				if (a2[i] == a1) {
					$(a2[i]).parent().addClass("select");
					return;
				}
			}
			$(a2[0]).parent().addClass("select");
		});
	</script>