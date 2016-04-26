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
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzw.StadiumRentalSystem.entity.Operator;
import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.service.OperatorService;
import com.hzw.StadiumRentalSystem.service.RoleService;
import com.hzw.StadiumRentalSystem.utils.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 操作员Action
 * 
 * @author HZW_922
 * 
 */
@Action("operator")
@Results({ @Result(name = "backMain", location = "/admin/backMain.jsp"),
		@Result(name = "login", type = "redirect", location = "/back") })
public class OperatorAction extends WWAction {
	private int id;
	private String name;// 操作员名
	private String number;
	private String password; // 登录密码
	private String oldpwd;
	private String newpwd;
	private int roleId;



	@Autowired
	OperatorService operatorService;
	@Autowired
	RoleService roleService;

	private static final long serialVersionUID = 1L;

	public OperatorAction() {
		super();
	}

	/**
	 * 登录操作
	 * 
	 * @return
	 * @throws IOException
	 */
	public void login() throws IOException {
		// 调用服务验证登录信息
		Operator operator = operatorService.validate(new Operator(name,
				password));

		if (operator == null) {
			sendFailMsg("账号或密码错误！");

		} else {
			// 将验证成功的操作员对象赋到session中
			ctx.getSession().put("operator", operator);
			data.put("url", "/back!backMain.action");
			this.sendSuccessMap(data);
		}

	}

	/**
	 * 更新信息操作
	 * 
	 * @throws IOException
	 */
	public void updateInfo() throws IOException {
		data = new HashMap<String, String>();
		Operator op = new Operator();
		op = (Operator) ctx.getSession().get("operator");
		boolean flag = false;
		// 检查用户名是否重复并且已修改
		if (!name.equals(op.getName())) {
			flag = operatorService.nameIsExist(name);
		}

		if (flag) {
			sendFailMsg("用户名已存在！");
		} else {
			if (MD5.MD5(oldpwd).equals(op.getPassword())) {
				op.setName(name);
				if (newpwd != null && !newpwd.isEmpty()) {
					op.setPassword(MD5.MD5(newpwd));
				}
				operatorService.update(op);
				// TODO 是否要更新session中的对象

				sendSuccessMsg("修改成功");
			} else {
				sendFailMsg("密码错误！");
			}
		}


	}

	/**
	 * 显示操作员数据
	 * 
	 * @throws IOException
	 */
	public void showOperators() throws IOException {
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		String s = this.getSortName();
		String a = this.getSortOrder();
		List<Operator> listOperators = operatorService.getPagingList(start,
				number); // 从数据库中查询数据

		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = operatorService.getOperatorCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listOperators);// rows键 存放每页记录 list

		writerToJsp(jsonMap);
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public String logout() {
		ctx.getSession().remove("operator");
		return "login";
	}

	/**
	 * 添加操作员
	 * 
	 * @throws IOException
	 */
	public void addOperator() throws IOException {
		
		if (operatorService.nameIsExist(name)) {
			data.put("result", "0");
			data.put("msg", "用户名已存在！");
		} else {
			Operator operator = new Operator( name, MD5.MD5(password),
					roleService.getById(roleId));
			Integer n = operatorService.save(operator);
			if (n > 0) {
				sendSuccessMsg("【" + operator.getName() + "】添加成功！");
			} else {
				sendFailMsg("添加失败！");
			}
		}
	}

	
	/**
	 * 删除操作员
	 * @throws IOException 
	 */
	public void delOperator() throws IOException{
		operatorService.delById(id);
		
		sendSuccessMsg("已删除！");
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getOldpwd() {
		return oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getNumber() {
		return number;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
