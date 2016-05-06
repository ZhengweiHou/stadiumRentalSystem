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
<title>操作员管理</title>
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

	<table id="operatorGrid" class="easyui-datagrid"
		style="width: 100%; height: 100%"
		data-options="pagination:true
		,rownumbers:true
		,singleSelect:true
		,url:'operator!showOperators.action'
		,method:'get'
		,toolbar:toolbar
		,striped:true
		,onRowContextMenu:showRowContextMenu
		,sortName:'id'
		,sortOrder:'asc'
		,remoteSort:false
		">
		<thead>
			<!-- <tr>
				<th data-options="field:'id',width:80">id</th>
				<th data-options="field:'number',width:80,align:'right'">编号</th>
				<th data-options="field:'name',width:100">用户名</th>
				<th data-options="field:'role',width:80,align:'right'"
					formatter="formatRole">角色</th>
			</tr> -->
			<tr>
				<th data-options="field:'id',width:'25%',sortable:true">id</th>
				<!-- <th data-options="field:'number',width:'25%'">编号</th> -->
				<th data-options="field:'name',align:'right',width:'25%'">用户名</th>
				<th data-options="field:'role',align:'right',width:'24%'"
					formatter="formatRole">角色</th>
			</tr>
		</thead>
	</table>

	<div id="opmenu" class="easyui-menu">
		<div name="del" iconCls="icon-remove">删除</div>
	</div>
	<div id="addWin"></div>
	<script type="text/javascript">

	
/*     $(function(){
        $('#operatorGrid').datagrid( {
              loadMsg : "正在加载数据",
              striped:true,
              onRowContextMenu: function (e, rowIndex, rowData) { //右键操作
                  $('#opmenu').menu('show', {
                      left: e.pageX,         //弹出窗口的方位坐标
                      top: e.pageY
                  });
                  // alert(rowData.name); 
                  e.preventDefault();
              },
              onClickRow:function(rowIndex,rowData){// 单击操作
               alert(rowData.name);
              },
              onDblClickRow :function(rowIndex,rowData){// 双击操作
                  alert("12312");
              } });
        
    }); */

    	
	    function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#opmenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	if(item.name=='del'){
	            		opDel(rowData);
	            	}
	               
	            } 
	        });
	        e.preventDefault();
	    };
    
	    function opDel(rowData){
	    	$.messager.confirm("确认", "确认删除【"+rowData.name+"】", function (r) {  
		        if (r) {  
		            $.ajax({
		                type : "post",
		                url : 'operator!delOperator.action',
		                data : {//设置数据源
		                    id : rowData.id  
		                },
		                dataType : "json",//设置需要返回的数据类型
		                success : function(data) {
		    				 if(data.result=="1"){
		    					 alert(data.msg);
		    					 $('#operatorGrid').datagrid('reload');  
		    				 }
		    			}
		    		});
		        }  
		    });    
	    }
	    
		function formatRole(value) {
			return value.name;
		};

		var toolbar = [ {
			text : '添加',
			iconCls : 'icon-add',
			
			handler : function() {
			      $('#addWin').window({
			            width: 600,
			            height: 400,
			            modal: true,
			            href: "<%=bas%>/admin/backPage/operatorAdd.jsp",
						title : "添加操作员"
				});

			}
		}, {
			text : 'Cut',
			iconCls : 'icon-cut',
			handler : function() {
				$('#operatorGrid').
				alert('cut')
			}
		}, '-', {
			text : 'Save',
			iconCls : 'icon-save',
			handler : function() {
				alert('save')
			}
		} ];
	</script>
</body>


</html>

