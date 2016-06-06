<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="iframe/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人订单</title>

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
<body text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
	<div width="960" align=center border=0 bgColor=#000000>
		<table class=Maintable cellSpacing=0 cellPadding=0 width="960"
			align=center border=0>
			<tbody>
				<tr>
					<td class=Side vAlign=top align=left width="100%" height=400>
						<!-- 显示预定场地列表 -->
						<table id="memberGrid" class="easyui-datagrid"
							style="width: 100%; height: 400; fitColumns: true"
							data-options="pagination:true
							,rownumbers:true
							,singleSelect:true
							,method:'get'
							,url:'order!showorder.action'
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
									<th
										data-options="field:'createTime',align:'right',sortable:true">创建时间</th>
									<th
										data-options="field:'destineDay',align:'right',sortable:true">预定时间</th>
									<th
										data-options="field:'startTime',align:'right',sortable:true">开始时间</th>
									<th data-options="field:'endTime',align:'right',sortable:true">结束时间</th>
									<th data-options="field:'price',align:'right',sortable:true">单价</th>
									<th
										data-options="field:'totalTime',align:'right',sortable:true">总时间/h</th>
									<th data-options="field:'rebate',align:'right',sortable:true">折扣</th>
									<th data-options="field:'total',align:'right',sortable:true">总价</th>
									<th data-options="field:'state',align:'right',sortable:true">订单状态</th>

								</tr>
							</thead>
						</table>
					</td>
				</tr>

			</tbody>
		</table>

	</div>
</body>
</html>
<%@ include file="iframe/foot.jsp"%>


<script type="text/javascript">
	function formatStadium(value) {
		return value.stadiumNumber;
	};

	function formatMember(value) {

		return value.account;
	};
</script>