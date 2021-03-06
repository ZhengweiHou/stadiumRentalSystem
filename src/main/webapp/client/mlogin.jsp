<%@ page import="org.aspectj.weaver.ast.Var" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String bas = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
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
	<div align=center>
		<div style="margin: 20px 0;"></div>
		<div class="easyui-panel" align=center style="width: 400px">
			<span>用户登录</span>
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" class="easyui-form" method="post"
					data-options="novalidate:false">
					<table cellpadding="5">
						<tr>
							<td>用户名:</td>
							<td><input class="easyui-textbox" type="text" name="account"
								data-options="required:true" validType="checkMemberAccount"></input></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="easyui-textbox" type="password"
								name="password"
								data-options="required:true,validType:'length[6,9]'"></input></td>
						</tr>
					</table>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton loginBtn">登录</a>
					<a href="javascript:void(0)" class="easyui-linkbutton registerBtn">注册</a>
				</div>
			</div>
		</div>

	</div>
	<script>
	$(function(){
		
		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				submitForm();
			}
		});
		
		$(".loginBtn").click(function(){
			submitForm(); 
		}); 
		
		$(".registerBtn").click(function(){
			parent.registWin();
		}); 
		
		
		
	});
	
		 function submitForm() {
			$('#ff').form('submit', {
				url : 'member!login.action',
				onSubmit : function() {
					return $(this).form('validate');
				},
				dataType : "json", 
				success : function(data) {
				 	var json = eval("(" + data + ")");
					/* var obj = jQuery.parseJSON(data); */
					if(json.result=="0"){
						/* 登录失败 */
						alert(json.msg);
					}
					else if(json.result=="1"){
						/* 登录成功 */
						/* 返回主页 */
						<%-- location.href="<%=bas%>"+index.jsp; --%>
						/* alert(json.msg); */
						location.href="<%=bas%>";
						/* parent.loads(); */
						/* parent.$('#newsGrid').datagrid('reload'); */
					}
				}
			});
		} 

		
		 $.extend($.fn.validatebox.defaults.rules, {  
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
			            return checkAccount==="true";   
			        },  
			        message: '账号不存在'  
			    }  
			      
			}); 
		
	</script>
</body>
</html>
