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
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.service.OperatorService;
import com.hzw.StadiumRentalSystem.service.RoleService;
import com.hzw.StadiumRentalSystem.service.StadiumService;
import com.hzw.StadiumRentalSystem.utils.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 运动场Action
 * 
 * @author HZW_922
 * 
 */
@Action("stadium")
//@Results({ @Result(name = "stadiumUpDate", location = "/backpack/stadiumUpdate.jsp")})
public class StadiumAction extends WWAction {
	
	private static final long serialVersionUID = 1L;
	
	// 特殊属性
	private int id;
	private int avaliable;
	private double price;
	private String stadiumNumber;
	private String descriptions;

	private Stadium stadium;


	@Autowired
	StadiumService stadiumService;
	
	
	/**
	 * 构造方法
	 */
	public StadiumAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
		this.data = new HashMap<String, String>();
	}

	
	/**
	 * 显示运动场数据
	 * @throws IOException 
	 * 
	 * 
	 */
	public void showStadiums() throws IOException{
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<Stadium> listStadiums = stadiumService.getPagingList(start,
				number); // 从数据库中查询数据
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = stadiumService.getStadiumCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listStadiums);// rows键 存放每页记录 list

		this.writerToJsp(jsonMap);
	
		
		
	}
	

	/**
	 * 添加运动场
	 * @throws IOException 
	 */
	public void addStadium() throws IOException{
		// 如果运动场编号不存在则保存
		if (stadiumService.numberIsExist(stadiumNumber)) {
			this.sendFailMsg("运动场编号【"+stadiumNumber+"】已存在！");
		} else {
			Stadium stadium = new Stadium(stadiumNumber, avaliable, descriptions, price);
			Integer n = stadiumService.save(stadium);
			if (n > 0) {
				sendSuccessMsg("运动场【" + stadium.getStadiumNumber() + "】添加成功！");
			} else {
				sendFailMsg("添加失败！");
			}
		}
	}
	
	/**
	 * 修改运动场信息
	 * @throws IOException 
	 * 
	 */
	public void upDateStadium() throws IOException{
		Stadium stadium = new Stadium(id,stadiumNumber, avaliable, descriptions, price);
		stadiumService.update(stadium);
		sendSuccessMsg("运动场【" + stadium.getStadiumNumber() + "】修改成功！");
	}
	
	
	/**
	 * 删除运动场
	 * @throws IOException 
	 */
	public void delStadium() throws IOException{
		stadiumService.delById(id);
		sendSuccessMsg("已删除！");
	}
	
//	public String getUpStadium(){
//		
//		System.out.println(id);
//		
//		
//		return "stadiumUpDate";
//	}
	
	public int getId() {
		return id;
	}


	public int getAvaliable() {
		return avaliable;
	}


	public double getPrice() {
		return price;
	}


	public String getStadiumNumber() {
		return stadiumNumber;
	}


	public String getDescriptions() {
		return descriptions;
	}


	public Stadium getStadium() {
		return stadium;
	}


	public String getRows() {
		return rows;
	}


	public String getPage() {
		return page;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setAvaliable(int avaliable) {
		this.avaliable = avaliable;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setStadiumNumber(String stadiumNumber) {
		this.stadiumNumber = stadiumNumber;
	}


	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}


	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}


	public void setRows(String rows) {
		this.rows = rows;
	}


	public void setPage(String page) {
		this.page = page;
	}
	
	
	
	
	
	
}
