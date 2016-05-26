<%@ page import="org.aspectj.weaver.ast.Var" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String bas = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
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

<style type="text/css">
.btn {
BORDER-RIGHT: #7b9ebd 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7b9ebd 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); BORDER-LEFT: #7b9ebd 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #7b9ebd 1px solid
}
</style>

</head>
<body class="easyui-layout">
	<div align=center>
		<div style="margin: 20px 0;"></div>
		<div class="easyui-panel" align=center style="width: 400px">
			<span>用户注册</span>
			<div style="padding: 10px 60px 20px 60px">
				<form id="mRegisterForm" class="easyui-form" method="post"
					data-options="novalidate:false">
					<table cellpadding="5">

						<tr>
							<td>账　　户:</td>
							<td><input id="account" class="easyui-textbox" type="text"
								name="account"
								data-options="required:true,validType:'checkMemberAccount'"></input></td>
						</tr>

						<tr>
							<td>密　　码:</td>
							<td><input id="password" class="easyui-textbox"
								type="password" name="password"
								data-options="required:true,validType:'length[6,9]'"></input></td>
						</tr>
						<tr>
							<td>确认密码:</td>
							<td><input id="rpassword" class="easyui-textbox"
								type="password" name="rpassword"
								data-options="required:true,validType:['equals[\'#password\']','length[6,9]']" /></td>
						</tr>

						<tr>
							<td>电　　话:</td>
							<td><input id="tel" class="easyui-textbox" type="text"
								name="tel" data-options="required:true"></input></td>
						</tr>

						<tr>
							<td>姓　　名:</td>
							<td><input id="name" class="easyui-textbox" type="text"
								name="name"></input></td>
						</tr>

						<tr>
							<td>生　　日:</td>
							<td><input id="birthday" class="easyui-datebox" type="text"
								name="birthday"></input></td>
						</tr>
						<tr>
							<td>邮　　箱 :</td>
							<td><input id="mail" class="easyui-textbox" type="text"
								name="mail"></input></td>

						</tr>


					</table>
				</form>
				<div style="text-align: center; padding: 5px;width: 100px">
					<a href="javascript:void(0)" class="easyui-linkbutton registerBtn">注册</a>
				</div>
			</div>
		</div>

	</div>
	<script>
	$(function(){
		
		$.extend($.fn.validatebox.defaults.rules, {
			equals : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '输入新密码不一致'
			},
			checkMemberAccount:{//检查账户
		        validator: function (value) {  
		            var checkAccount=$.ajax({  
		                async : false,    
		                cache : false,  
		                type : 'post',    
		                url : 'member!checkAccount.action',    
		                data : {    
		                	account : value  
		                }   
		            }).responseText;    
		            return checkAccount==="false";   
		        },  
		        message: '账号已存在'  
		    } 
			
		});
		
		$(".registerBtn").click(function(){
			submitForm(); 
		}); 
		
		
	});
	
		 function submitForm() {
			$('#mRegisterForm').form('submit', {
				url : 'member!register.action',
				onSubmit : function() {
					return $(this).form('validate');
				},
				dataType : "json", 
				success : function(data) {
					var json = eval("(" + data + ")");
					/* var obj = jQuery.parseJSON(data); */
					if(json.result=="0"){
						/* 注册失败 */
						alert(json.msg);
					}
					else if(json.result=="1"){
						/* 注册成功 */
						alert(json.msg);
						location.href="<%=bas%>";
					}
				}
			});
		}

		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</body>
</html>
