package com.hzw.StadiumRentalSystem.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzw.StadiumRentalSystem.basis.BackPage;
import com.hzw.StadiumRentalSystem.basis.PageStore;
import com.hzw.StadiumRentalSystem.entity.Operator;
import com.hzw.StadiumRentalSystem.service.OperatorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Action("back")
@Results({ @Result(name = "backMain", location = "/admin/backMain.jsp"),
		@Result(name = "login", type = "redirect", location = "/back") })
public class BackAction extends ActionSupport {
	HttpServletResponse response;
	ActionContext ctx;

	private String pagename;

	private Map<String, String> data;
	
	@Autowired
	OperatorService operatorService;

	private static final long serialVersionUID = 1L;

	public BackAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
	}

	/**
	 * 进入后台页面时的验证(将来添加页面权限控制)
	 * 
	 * @return
	 */
	public String backMain() {
		Operator operator = (Operator) ctx.getSession().get("operator");
		if (operator == null) {
			return "login";
		} else {
			// TODO 获取当前登录用户的权限，根据权限获取显示的菜单项（暂不实现）
			return "backMain";
		}
	}

	public void addTab() throws IOException {
		BackPage backPage = PageStore.pages.get(pagename);
		
		
		data = new HashMap<String, String>();
		if (backPage!=null) {
			// 页面通过验证
			data.put("result", "1");
			data.put("pagetitle", backPage.getPageTitle());
			data.put("pageurl",backPage.getPageurl());
			
		} else {
			// 页面未通过验证
			data.put("result", "0");
			data.put("msg", "您没有访问这个页面的权限，请联系管理员！");
		}

		JSONObject jsonObject = new JSONObject(data);
//		JSONObject jsonObject = JSONObject.fromObject(data);
		response.getWriter().write(jsonObject.toString());
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

}
