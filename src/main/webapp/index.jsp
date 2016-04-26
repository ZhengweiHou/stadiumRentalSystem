<%@ page import="org.aspectj.weaver.ast.Var" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<% String bas=request.getContextPath(); %>
<head>
    <title>esayHello</title>
    <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/demo/demo.css"> 
    <script type="text/javascript" src="<%=bas%>/js/jquery-1.9.0.js"></script>
    <script type="text/javascript" src="<%=bas%>/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=bas%>/easyui/locale/easyui-lang-zh_CN.js"></script>
    
</head>
<body>
<h2>Hello World!</h2>

<a href="<%=bas%>/user/userinfo.action">userinfo</a>

        <h2>Basic哈哈哈哈 Tree</h2>
    <p>Click the arrow on the left to expand or collapse nodes.</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="padding:5px">
        <ul class="easyui-tree">
            <li>
                <span>My Documents</span>
                <ul>
                    <li data-options="state:'closed'">
                        <span>Photos</span>
                        <ul>
                            <li>
                                <span>Friend</span>
                            </li>
                            <li>
                                <span>Wife</span>
                            </li>
                            <li>
                                <span>Company</span>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span>Program Files</span>
                        <ul>
                            <li>Intel</li>
                            <li>Java</li>
                            <li>Microsoft Office</li>
                            <li>Games</li>
                        </ul>
                    </li>
                    <li>index.html</li>
                    <li>about.html</li>
                    <li>welcome.html</li>
                </ul>
            </li>
        </ul>
    </div>
    
    <h2>Basic LinkButton</h2>
    <p>Buttons can be created from &lt;a&gt; or &lt;button&gt; elements.</p>
    <div style="margin:10px 0 40px 0;"></div>
    <p>Basic Buttons</p>
    <div style="padding:5px 0;">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">Save</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut',disabled:true">Cut</a>
        <a href="#" class="easyui-linkbutton">Text Button</a>
    </div>
    <p>Fixed Width Buttons</p>
    <div style="padding:5px 0;">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:50px">Search</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="width:50px">Print</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:50px">Reload</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help'" style="width:50px">Help</a>
    </div>
</body>
</html>
