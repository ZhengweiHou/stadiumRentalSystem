
<!DOCTYPE html>
<html>
<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<head>
<%
	String bas = request.getContextPath();
%>
<meta charset="UTF-8">
<title>Basic ComboBox - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=bas%>/easyui/demo/demo.css">
<script type="text/javascript" src="<%=bas%>/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
	<!-- 上导航栏 -->   
    <div data-options="region:'north',border:false" style="height:70px;">
   	顶部
    </div>   
    
    <!-- 主内容区 -->
    <div class="easyui-layout" data-options="region:'center',border:false" style="background:#eee; ">
    	<!-- 左侧导航 -->
	    <div class="easyui-accordion" data-options="region:'west',title:'导航',collapsible:false" style="width:100px;">
		   	<div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
	       		content1 
		    </div>   
		    <div title="Title2">   
		        content2    
		    </div>   
		    <div title="Title3">   
		        content3    
		    </div>  
	    	
	    </div> 
	    
	    <div data-options="region:'center',border:false,maxHeight:10000" style="padding:5px;background:#eee;">
	    	中1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>
	    </div>
	    
	    <!-- 右侧公告 --> 
	    <div data-options="region:'east'" style="width:100px;">
	   		右侧
	    </div>  
	    
    </div> 
    
    <!-- 页脚 -->
    <div data-options="region:'south',border:false" style="height:100px;">
  	 底部
    </div>   
    

    
     
   
  
</body>

</html>


