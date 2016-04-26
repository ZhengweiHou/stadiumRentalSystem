
    <!DOCTYPE html>
    <html>
    <head>
    <%
	String bas = request.getContextPath();
%>
        <meta charset="UTF-8">
        <title>Basic ComboBox - jQuery EasyUI Demo</title>
        <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="<%=bas%>/easyui/demo/demo.css">
		<script type="text/javascript" src="<%=bas%>/js/jquery-1.9.0.js"></script>
       <script type="text/javascript" src="<%=bas%>/easyui/jquery.easyui.min.js" charset="utf-8"></script>
    </head>
    <body>
        <h2>Basic ComboBox</h2>
        <p>Type in ComboBox to try auto complete.</p>
        <div style="margin:20px 0"></div>
        
        <select class="easyui-combobox" name="state" style="width:200px;">
            <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH" selected>Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
        </select>
     
     <br>
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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">Search</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="width:80px">Print</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px">Reload</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help'" style="width:80px">Help</a>
    </div>
     
     
   <hr>
     <div style="margin:20px 0;">
        <span>Select Region Panel:</span>
        <select id="region">
            <option value="north">North</option>
            <option value="south">South</option>
            <option value="east">East</option>
            <option value="west">West</option>
        </select>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPanel()">Add</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="removePanel()">Remove</a>
    </div>
    <div id="cc" class="easyui-layout" style="width:700px;height:350px;">
        <div data-options="region:'north'" style="height:50px"></div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'east',split:true" title="East" style="width:100px;"></div>
        <div data-options="region:'west',split:true" title="West" style="width:100px;"></div>
        <div data-options="region:'center',title:'Center'"></div>
    </div>
    <script type="text/javascript">
        function addPanel(){
            var region = $('#region').val();
            var options = {
                region: region
            };
            if (region=='north' || region=='south'){
                options.height = 50;
            } else {
                options.width = 100;
                options.split = true;
                options.title = $('#region option:selected').text();
            }
            $('#cc').layout('add', options);
        }
        function removePanel(){
            $('#cc').layout('remove', $('#region').val());
        }
    </script>
     
    </body>
    </html>


