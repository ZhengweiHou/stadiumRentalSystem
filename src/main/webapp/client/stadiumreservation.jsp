<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="iframe/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场地预定</title>




</head>
<body text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
	<div width="960" align=center border=0 bgColor=#000000>
		<table class=Maintable cellSpacing=0 cellPadding=0 width="960"
			align=center border=0>
			<tbody>
				<tr>
					<td class=Side vAlign=top align=left width="30%" height=400
						style="background-color: green;">
						<!-- 选择时间的表单 -->
						<form id="mRegisterForm" class="easyui-form" method="post"
							data-options="novalidate:false">
							<table cellpadding="3">

								<tr>
									<td>选择日期:</td>
									<td><input id="startDay" class="easyui-datebox"
										type="text" name="birthday" data-options="required:true"></input></td>
								</tr>

								<tr>
									<td>开始时间:</td>
									<td>
										<!-- <div id="StartDT"></div>  --> <input id="startDT"
										class="easyui-timespinner"
										data-options="
										required:true,
										min:'08:00',
										max:'22:00',
										increment:30,
										editable:false,
										highlight:1,
										onChange:upTimeMinMax" />
									</td>
								</tr>
								<tr>
									<td>结束时间:</td>
									<td>
										<!-- <div id="EndDT"></div> --> <input id="endDT"
										class="easyui-timespinner"
										data-options="
										required:true,
										min:'08:00',
										max:'22:00',
										increment:30,
										editable:false,
										highlight:1,
										onChange:upTimeMinMax" />
									</td>
								</tr>



							</table>
						</form>
						<div style="text-align: center; padding: 5px">
							<a href="javascript:void(0)"
								class="easyui-linkbutton findStadiumBtn">查找可预定场地</a>
						</div>
					</td>
					<td class=Side vAlign=top align=left width="69%" height=400>
						<!-- 显示预定场地列表 -->
						<table id="clientStadiumGrid" class="easyui-datagrid"
							style="width: 100%; height: 100%; fitColumns: true"
							data-options="pagination:false
							,rownumbers:false
							,singleSelect:true
							,method:'get'
							,onRowContextMenu:showRowContextMenu
							,url:'mstadium!showBeFindStadiums.action'
							,striped:true
							,sortName:'id'
							,sortOrder:'asc'
							,remoteSort:false
							">
							<thead>
								<tr>
									<th data-options="field:'id',sortable:true">id</th>
									<th
										data-options="field:'stadiumNumber',align:'right',sortable:true">编号</th>
									<th data-options="field:'price',sortable:true">单价</th>
									<th data-options="field:'descriptions'">描述</th>
								</tr>
							</thead>
						</table>
					</td>
				</tr>

			</tbody>
		</table>

		<div id="stadiummenu" class="easyui-menu">
			<div name="createOrder" iconCls="icon-edit">预定</div>
		</div>
		<div id="orderWin"></div>

	</div>
</body>
</html>
<%@ include file="iframe/foot.jsp"%>


<script type="text/javascript">
	$(function() {

		$("#endDT").timespinner('setValue', '22:00');

		$("#startDT").timespinner('setValue', '08:00');

		$(".findStadiumBtn").click(function() {
			var startdt = $('#startDT').timespinner('getValue'); // 获取时间微调组件的值
			var enddt = $('#endDT').timespinner('getValue');
			var startday = $('#startDay').datebox('getValue');

			if (startdt > enddt) {
				alert("开始时间不能大于结束时间!!!");
			} else if (startday == "") {
				alert("请选择日期");
			} else {
				findStadium();
			}

		});

	});

	
	   function showRowContextMenu(e, rowIndex, rowData) { //右键操作
	        $('#stadiummenu').menu('show', {
	            left: e.pageX,         //弹出窗口的方位坐标
	            top: e.pageY,
	            onClick:function(item){
	            	// TODO生成订单
	            	 $.ajax({
			                type : "post",
			                url : 'order!createOrder.action',
			                data : {//设置数据源
			                    stadiumId : rowData.id
			                },
			                dataType : "json",//设置需要返回的数据类型
			                success : function(data) {
			    				 if(data.result=="1"){
			    					 showOrder();
			    				 }else if(data.result=="0"){
			    					 alert(data.msg);
			    					 $('#indexWin').window({
			    				            width: 500,
			    				            height: 200,
			    				            modal: true,
			    				            href: "<%=bas%>/client/mlogin.jsp",
			    							title : "用户登录"
			    				   		});
			    				 }
			    					 

			    			}
			    		}); 
	           
	            } 
	        });
	        e.preventDefault();
	    };
	
	
	    function showOrder(){
	    	$('#orderWin').window({
	            width: 600,
	            height: 400,
	            modal: true,
	            href: "<%=bas%>/client/showorder.jsp",
				title : "确认订单"
	   		});
	    }
	    
	    
	function findStadium() {
		$('#clientStadiumGrid').datagrid('load', {
			startday : $('#startDay').datebox('getValue'),
			startdt : $('#startDT').timespinner('getValue'),
			enddt : $('#endDT').timespinner('getValue')
		});
	}

	function upTimeMinMax() {
		var startdt = $('#startDT').timespinner('getValue'); // 获取时间微调组件的值
		var enddt = $('#endDT').timespinner('getValue');
		if (startdt > enddt) {
			alert("开始时间不能大于结束时间!!!");
		}

		/* $("#endDT").attr("min", '20:00');  */
		/* $("#endDT").timespinner('min','20:00'); */
		/* $("#endDT").timespinner('min',v); */
		/* val endtime = $("#endDT").timespinner('getValue');
		val starttime = $("#startDT").timespinner('getValue'); */
		/* 	$("#startDT").timespinner('max',endtime);
			$("#endDT").timespinner('min','20:00'); */

	};
</script>