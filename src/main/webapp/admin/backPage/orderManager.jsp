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
<title>订单管理</title>
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

	<table id="memberGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%; fitColumns: true"
		data-options="pagination:true
			,rownumbers:true
			,singleSelect:true
			,method:'get'
			,url:'order!showorder.action'
			,onRowContextMenu:showRowContextMenu
			,striped:true
			,sortName:'id'
			,sortOrder:'asc'
			,remoteSort:false
			">
		<thead>
			<tr>
				<th data-options="field:'id',sortable:true">id</th>
				<th data-options="field:'member',sortable:true" formatter="formatMember">会员</th>
				<th data-options="field:'stadium',sortable:true" formatter="formatStadium">场地</th>
				<th data-options="field:'createTime',align:'right',sortable:true">创建时间</th>
				<th data-options="field:'destineDay',align:'right',sortable:true">预定时间</th>
				<th data-options="field:'startTime',align:'right',sortable:true">开始时间</th>
				<th data-options="field:'endTime',align:'right',sortable:true">结束时间</th>
				<th data-options="field:'price',align:'right',sortable:true">单价</th>
				<th data-options="field:'totalTime',align:'right',sortable:true">总时间/h</th>
				<th data-options="field:'rebate',align:'right',sortable:true">折扣</th>
				<th data-options="field:'total',align:'right',sortable:true">总价</th>
				<th data-options="field:'state',align:'right',sortable:true">订单状态</th>			
				
			</tr>
		</thead>
	</table>

	<div id="ordermenu" class="easyui-menu">
		<div name="nosure" iconCls="icon-remove">拒绝</div>
		<div name="sure" iconCls="icon-edit">批准</div>
	</div>
	<div id="win"></div>


	<script type="text/javascript">

	    function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#ordermenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	if(item.name=='sure'){
	            		sureOrder(rowData.id);
	            	}else if(item.name=='nosure'){
	            		nosureOrder(rowData.id);
	            	}
	            } 
	        });
	        e.preventDefault();
	    };
    
 		function sureOrder(orderid){
 			$.ajax({
                type : "post",
                url : 'order!sureOrder.action',
                data : {//设置数据源
                    id : orderid  
                },
                dataType : "json",//设置需要返回的数据类型
                success : function(data) {
    				 if(data.result=="1"){
    					 alert(data.msg);
    				 }
    			}
    		});
 		}
 		
 		function nosureOrder(id){
 			$.ajax({
                type : "post",
                url : 'order!nosureOrder.action',
                data : {//设置数据源
                    id : orderid  
                },
                dataType : "json",//设置需要返回的数据类型
                success : function(data) {
    				 if(data.result=="1"){
    					 alert(data.msg);
    				 }
    			}
    		});
 		}
	    
		function formatStadium(value) {
			return value.stadiumNumber;
		};
		
		function formatMember(value) {
	
			return value.account;
		};
	</script>
</body>


</html>

