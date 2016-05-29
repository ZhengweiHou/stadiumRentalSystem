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
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.Order;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.service.OrderService;
import com.hzw.StadiumRentalSystem.service.StadiumService;
import com.hzw.StadiumRentalSystem.service.StadiumTimeService;
import com.hzw.StadiumRentalSystem.utils.StadiumTimeUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * 订单action
 * 
 * @author HZW_922
 * 
 */
@Action("order")
// @Results({ @Result(name = "stadiumUpDate", location =
// "/backpack/stadiumUpdate.jsp")})
public class OrderAction extends WWAction {

	private static final long serialVersionUID = 1L;

	private String startdt;

	private String enddt;

	private Timestamp startday;

	private int stadiumId;
	
	private int id;

	private Member member;

	@Autowired
	StadiumService stadiumService;

	@Autowired
	OrderService orderService;

	@Autowired
	StadiumTimeService stadiumTimeService;

	/**
	 * 生成订单
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public void createOrder() throws IOException {
		member = (Member) ctx.getSession().get("member");
		startdt = (String) ctx.getSession().get("startdt");
		enddt = (String) ctx.getSession().get("enddt");
		startday = (Timestamp) ctx.getSession().get("startday");

		Stadium stadium = stadiumService.getStadiumById(stadiumId);
		if (member == null) {
			this.sendFailMsg("请先登录!");
		} else {
			Order order = new Order();
			{
				order.setCreateTime(new Timestamp(System.currentTimeMillis()));
				order.setDestineDay(startday);
				order.setStartTime(startdt);
				order.setEndTime(enddt);
				order.setMember(member);
				order.setStadium(stadium);
				order.setPrice(stadium.getPrice());
				int indexOfStartdt = SystemData.indexMapTime.indexOf(startdt);
				int indexOfEnddt = SystemData.indexMapTime.indexOf(enddt);
				double totalTime = StadiumTimeUtil.bothIndexToBitsList(
						indexOfStartdt, indexOfEnddt).size() - 1;
				order.setTotalTime(totalTime / (60.0 / SystemData.FINENESS));
				order.setTotal(order.getPrice() * order.getTotalTime()
						* order.getRebate());
				order.setUseTimeState(StadiumTimeUtil.bothIndexToDecimal(
						indexOfStartdt, indexOfEnddt));
			}
			ctx.getSession().put("order", order);

			this.sendSuccessMsg("订单生成成功！");
		}
	}

	/**
	 * 确认订单
	 * 
	 * @throws IOException
	 */
	public void ensureOrder() throws IOException {
		Order order = (Order) ctx.getSession().get("order");
		int orderId = orderService.saveOrder(order);
		stadiumTimeService.updateStadiumTimeByEnsureOrder(order);
		ctx.getSession().remove("order");
		this.sendSuccessMsg("订单提交成功，订单号为：" + orderId);
	}

	/**
	 * 显示订单
	 * 
	 * @throws IOException
	 */
	public void showorder() throws IOException {
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<Order> listMembers = orderService.getPagingList(start, number); // 从数据库中查询数据

		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = orderService.getOrderCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listMembers);// rows键 存放每页记录 list

		this.writerToJsp(jsonMap);
	}

	/**
	 * 拒绝订单
	 * @throws IOException 
	 */
	public void nosureOrder() throws IOException {
		Order order = orderService.getOrderById(id);
		order.setState("N");
		orderService.updateOrder(order);
		stadiumTimeService.updateStadiumTimeByNosureOrder(order);
		this.sendSuccessMsg("订单【"+id+"】已拒绝");
	}

	/**
	 * 批准订单
	 * @throws IOException 
	 */
	public void sureOrder() throws IOException {
		Order order = orderService.getOrderById(id);
		order.setState("Y");
		orderService.updateOrder(order);
		this.sendSuccessMsg("订单【"+id+"】审核通过");
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

	public int getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
