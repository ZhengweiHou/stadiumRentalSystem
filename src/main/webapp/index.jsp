<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="client/iframe/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>


<style type="text/css">
.flashBanner {
	width: 700px;
	height: 326px;
	overflow: hidden;
	margin: 0 auto;
}

.flashBanner {
	position: relative;
}

.flashBanner .mask {
	height: 32px;
	line-height: 32px;
	background-color: #000;
	width: 100%;
	text-align: right;
	position: absolute;
	left: 0;
	bottom: -32px;
	filter: alpha(opacity =     70);
	-moz-opacity: 0.7;
	opacity: 0.7;
	overflow: hidden;
}

.flashBanner .mask img {
	vertical-align: middle;
	margin-right: 10px;
	cursor: pointer;
}

.flashBanner .mask img.show {
	margin-bottom: 3px;
}
</style>

</head>
<body text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
	<div width="960" align=center border=0>
		<table class=Maintable cellSpacing=0 cellPadding=0 width="960"
			align=center border=0>
			<tbody>
				<tr>
					<td class=Side vAlign=top align=left width="70%" height=200>
						<!--*******************************新闻资讯开始*******************************-->
						<table class=dragTable cellSpacing=0 cellPadding=0 width="90%"
							align=center border=0>
							<tbody>
								<tr>
									<td align="center">
										<!-- 主页主播区域开始 -->
										<div class="flashBanner">
											<a href="/"><img class="bigImg" width="700" height="326" /></a>
											<div class="mask">
												<img src="<%=basePath%>images/tyc1.jpg"
													uri="<%=basePath%>images/tyc1.jpg" width="60" height="22" />
												<img src="<%=basePath%>images/tyc2.jpg"
													uri="<%=basePath%>images/tyc2.jpg" width="60" height="22" />
												<img src="<%=basePath%>images/tyc3.jpg"
													uri="<%=basePath%>images/tyc3.jpg" width="60" height="22" />


											</div>
										</div> <!-- 主页主播区域结束-->
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td class=Side vAlign=top align=right width="25%">
						<!--*******************************滚动公告开始*******************************-->
						<table width="100%" height="326" border=0 cellPadding=0
							cellSpacing=0 class=dragTable>
							<tbody>
								<tr>
									<td class=head><span class=TAG>
											<P>场馆消息</P>
									</span></td>
								</tr>
								<tr>
									<td class=middle align=left><marquee
											onmouseover=if(document.all!=null){this.stop()}
											onmouseout=if(document.all!=null){this.start()}
											scrollAmount=1 scrollDelay=1 direction=up height=180>

											<table id="operatorGrid" class="easyui-datagrid"
												data-options="pagination:false
												,showHeader:false
												,rownumbers:false
												,singleSelect:true
												,url:'news!clientShowNewss.action'
												,method:'get'
												,autoRowHeight:true
												,fitColumns:false
												">
												<thead>
													<tr>
														<th data-options="field:'title'">标题</th>
														<th data-options="field:'content',align:'left'" f>内容

														</th>
													</tr>
												</thead>
											</table>

											<!-- <table id="pg" class="easyui-propertygrid"
												style="width: 300px"
												data-options="url:'operator!showOperators.action',showGroup:false,scrollbarSize:0"></table> -->
										</marquee></td>
								</tr>
							</tbody>
							<!--*******************************滚动公告结束*******************************-->
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ include file="client/iframe/foot.jsp"%>


<script type="text/javascript">
	$(function() {
		$(".flashBanner")
				.each(
						function() {
							var timer;
							$(".flashBanner .mask img").click(
									function() {
										var index = $(".flashBanner .mask img")
												.index($(this));
										changeImg(index);
									}).eq(0).click();
							$(this).find(".mask").animate({
								"bottom" : "0"
							}, 3000);
							$(".flashBanner")
									.hover(
											function() {
												clearInterval(timer);
											},
											function() {
												timer = setInterval(
														function() {
															var show = $(
																	".flashBanner .mask img.show")
																	.index();
															if (show >= $(".flashBanner .mask img").length - 1)
																show = 0;
															else
																show++;
															changeImg(show);
														}, 3000);
											});
							function changeImg(index) {
								$(".flashBanner .mask img").removeClass("show")
										.eq(index).addClass("show");
								$(".flashBanner .bigImg").parents("a").attr(
										"href",
										$(".flashBanner .mask img").eq(index)
												.attr("link"));
								$(".flashBanner .bigImg").hide().attr(
										"src",
										$(".flashBanner .mask img").eq(index)
												.attr('uri')).fadeIn("slow");
							}
							timer = setInterval(
									function() {
										var show = $(
												".flashBanner .mask img.show")
												.index();
										if (show >= $(".flashBanner .mask img").length - 1)
											show = 0;
										else
											show++;
										changeImg(show);
									}, 3000);
						});
	});

	function formatNewsContent(value) {
		return $("#newsContent");
		/* return $("#newsContent").textbox("setValue", value); */
		/* return"<input class='easyui-textbox' data-options='multiline:true' value="+"松松松松松松松松松松松松松松松松松松松松松松松松松松松松松松送送从送送送送送送送送送送送送送送送送送送"+" style='width:100px;'>" */
		/* return value.content; */
	};
</script>