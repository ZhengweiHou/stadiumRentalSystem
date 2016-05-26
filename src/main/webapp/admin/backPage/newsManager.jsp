<%@page import="com.hzw.StadiumRentalSystem.entity.Operator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
<title>公告管理</title>
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

	<table id="newsGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:true
			,singleSelect:true
			,method:'get'
			,url:'news!showNewss.action'
			,toolbar:toolbar
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'id'
			,sortOrder:'asc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'title',align:'right'">标题</th>
				<th data-options="field:'content'">内容</th>
				<th data-options="field:'showstatu'" formatter="formatNewsShow">显示状态</th>
			</tr>
		</thead>
	</table>

	<div id="newsmenu" class="easyui-menu">
		<div name="updateshowstatu" iconCls="icon-edit">切换显示状态</div>
		<div name="del" iconCls="icon-remove">删除</div>

	</div>
	<div id="win"></div>


	<script type="text/javascript">

	    function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#newsmenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	if(item.name=='del'){
	            		newsDel(rowData);
	            	}else if(item.name=='updateshowstatu'){
	            		newsUpdateShowstatu(rowData);
	            	}
	            } 
	        });
	        e.preventDefault();
	    };
    
	    function newsDel(rowData){
	    	$.messager.confirm("确认", "确认删除公告【"+rowData.title+"】", function (r) {  
		        if (r) {
		        	// 删除公告
		             $.ajax({
		                type : "post",
		                url : 'news!delnews.action',
		                data : {//设置数据源
		                    id : rowData.id  
		                },
		                dataType : "json",//设置需要返回的数据类型
		                success : function(data) {
		    				 if(data.result=="1"){
		    					 alert(data.msg);
		    					 $('#newsGrid').datagrid('reload');  
		    				 }
		    			}
		    		}); 
		        }  
		    });    
	    }
	    

	    function newsUpdateShowstatu(rowData){
 	    	// 修改显示状态
            $.ajax({
               type : "post",
               url : 'news!updateShowstatu.action',
               data : {//设置数据源
                   id : rowData.id  
               },
               dataType : "json",//设置需要返回的数据类型
               success : function(data) {
   				 if(data.result=="1"){
   					 alert(data.msg);
   					 $('#newsGrid').datagrid('reload');  
   				 }
   			}
   		}); 
	    }

 		var toolbar = [ {
			text : '添加',
			iconCls : 'icon-add',
			
			handler : function() {
			      $('#win').window({
			            width: 600,
			            height: 400,
			            modal: true,
			            href: "<%=bas%>/admin/backPage/newsAdd.jsp",
					title : "添加公告"
				});

			}
		} ];

		function formatNewsShow(value) {
			if(value == 0){
				return "显示";
			}else{
				return "不显示";
			}
		};
	</script>
</body>


</html>

