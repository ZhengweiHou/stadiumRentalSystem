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
<title>运动场管理</title>
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

	<table id="stadiumGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:true
			,singleSelect:true
			,method:'get'
			,url:'stadium!showStadiums.action'
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
				<th data-options="field:'stadiumNumber',align:'right',sortable:true">编号</th>
				<th data-options="field:'price',sortable:true">单价</th>
				<th data-options="field:'avaliable',sortable:true"
					formatter="formatAvaliable">是否可用</th>
				<th data-options="field:'descriptions'">描述</th>
			</tr>
		</thead>
	</table>

	<div id="stadiummenu" class="easyui-menu">
		<div name="del" iconCls="icon-remove">删除</div>
		<div name="update" iconCls="icon-edit">修改</div>
		<div name="update" iconCls="icon-tip">详情</div>
	</div>
	<div id="addWin"></div>


	<script type="text/javascript">

	    function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#stadiummenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	if(item.name=='del'){
	            		stadiumDel(rowData);
	            	}else if(item.name=='update'){
	                	
	            		//request.setAttribute("rowData",rowData);
	            		//Session["rowData"]=rowData;
	            		//session.setAttribute("name",Object);
	            	    <%-- var id = '<%=session.getAttribute("id")%>';  
	            		<%session.setAttribute("rowData",rowData);%> --%>
	            		<%-- location.href = "<%=bas%>/admin/backPage/stadiumUpdate.jsp?id="+rowData.id+"&stadiumNumber="+rowData.stadiumNumber+"&price="+rowData.price+"&avaliable="+rowData.avaliable+"&descriptions="+rowData.descriptions;
	             --%>
	            		stadiumUpdate(rowData);
	            	}
	            } 
	        });
	        e.preventDefault();
	    };
    
	    function stadiumDel(rowData){
	    	$.messager.confirm("确认", "确认删除场地【"+rowData.stadiumNumber+"】", function (r) {  
		        if (r) {  
		        	// 删除运动场
		             $.ajax({
		                type : "post",
		                url : 'stadium!delStadium.action',
		                data : {//设置数据源
		                    id : rowData.id  
		                },
		                dataType : "json",//设置需要返回的数据类型
		                success : function(data) {
		    				 if(data.result=="1"){
		    					 alert(data.msg);
		    					 $('#stadiumGrid').datagrid('reload');  
		    				 }
		    			}
		    		}); 
		        }  
		    });    
	    }
	    
	    function stadiumUpdate(rowData){
	    	$('#addWin').window({
	            width: 600,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/admin/backPage/stadiumUpdate.jsp?id="+rowData.id+"&stadiumNumber="+rowData.stadiumNumber+"&price="+rowData.price+"&avaliable="+rowData.avaliable+"&descriptions="+rowData.descriptions,
				title : "修改场地信息"
	   		});
	    }
	    
<%-- 	    function stadiumUpdate(rowData){
	    	$('#addWin').window({
	            width: 600,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/admin/backPage/stadiumUpdate.jsp?stadiumId="+rowData.id,
				title : "修改场地信息"
	   		});
	    } --%>
	    
		function formatAvaliable(value) {
			if(value==1)
				return "不可用";
			else
				return "可用";
		};

 		var toolbar = [ {
			text : '添加',
			iconCls : 'icon-add',
			
			handler : function() {
			      $('#addWin').window({
			            width: 600,
			            height: 400,
			            modal: true,
			            href: "<%=bas%>/admin/backPage/stadiumAdd.jsp",
					title : "添加场地"
				});

			}
		}];
	</script>
</body>


</html>

