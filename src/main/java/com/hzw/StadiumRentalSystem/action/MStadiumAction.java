package com.hzw.StadiumRentalSystem.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzw.StadiumRentalSystem.basis.FindStadiumToOrderContent;
import com.hzw.StadiumRentalSystem.basis.SystemData;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.service.StadiumService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户操作运动场Action
 * 
 * @author HZW_922
 * 
 */
@Action("mstadium")
// @Results({ @Result(name = "stadiumUpDate", location =
// "/backpack/stadiumUpdate.jsp")})
public class MStadiumAction extends WWAction {

	private static final long serialVersionUID = 1L;

	private String startdt;

	private String enddt;

	private Timestamp startday;

	@Autowired
	StadiumService stadiumService;

	/**
	 * 显示运动场数据
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public void showBeFindStadiums() throws IOException {
		List<Stadium> listStadiums = new ArrayList<Stadium>();
		if (startdt != null && enddt != null && startday != null) {
			listStadiums = stadiumService.clientFindStadiums(startdt, enddt,
					startday);
			ctx.getSession().put("startdt", startdt);
			ctx.getSession().put("enddt", enddt);
			ctx.getSession().put("startday", startday);
		}

		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = listStadiums.size(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listStadiums);// rows键 存放每页记录 list

		this.writerToJsp(jsonMap);

		// // 当前页
		// int intPage = Integer.parseInt((page == null || page == "0") ? "1"
		// : page);
		// // 每页显示条数
		// int number = Integer.parseInt((rows == null || rows == "0") ? "10"
		// : rows);
		//
		// // 每页的开始记录 第一页为1 第二页为number +1
		// int start = (intPage - 1) * number;
		//
		// List<Stadium> listStadiums = FindStadiumToOrderContent.getStadiums();
		// // 从数据库中查询数据
		//
		// Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		//
		// Integer count = 0; // 求出总记录数
		//
		// // total键 存放总记录数，必须的
		// jsonMap.put("total", count);
		// jsonMap.put("rows", listStadiums);// rows键 存放每页记录 list
		//
		// this.writerToJsp(jsonMap);

	}

	public String getEnddt() {
		return enddt;
	}

	public Timestamp getStartday() {
		return startday;
	}

	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}

	public void setStartday(Timestamp startday) {
		this.startday = startday;
	}

	public String getStartdt() {
		return startdt;
	}

	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}

}
