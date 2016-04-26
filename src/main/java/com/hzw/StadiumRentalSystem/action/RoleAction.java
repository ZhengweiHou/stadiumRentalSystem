package com.hzw.StadiumRentalSystem.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 操作员Action
 * 
 * @author HZW_922
 * 
 */
@Action("role")
@Results({ @Result(name = "backMain", location = "/admin/backMain.jsp"),
		@Result(name = "login", type = "redirect", location = "/back") })
public class RoleAction extends ActionSupport {

	private HttpServletResponse response;
	private ActionContext ctx;
	private JSONObject result; // 返回的json

	@Autowired
	RoleService roleService;

	private static final long serialVersionUID = 1L;

	public RoleAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
	}


	/**
	 * 获取角色数据
	 * 
	 * @return
	 * @throws IOException
	 */
	public void getRoles() throws IOException {
		 List<Role> listRoles=roleService.findAll(); //从数据库中查询数据
//		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
//		jsonMap.put("roles", listRoles);// rows键 存放每页记录 list
//		result = new JSONObject(jsonMap);
		// result=JSONObject.fromObject(CommonUtil.getJsonNotNull(jsonMap));
		JSONArray roles = new JSONArray(listRoles);
//		System.out.println(result.getString("roles"));
//		String rolesJson = result.getString("roles");
		response.getWriter().write(roles.toString());

		// return SUCCESS;
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		ctx.getSession().remove("operator");
		return "login";
	}

	


	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}



}
