package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.Order;

/**
 * 订单服务
 * @author HZW_922
 *
 */
public interface OrderService {

	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order);
	
	/**
	 * 获取页面显示的订单数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Order> getPagingList(int start, int number);
	
	/**
	 * 获取订单数量
	 * @return
	 */
	public Integer getOrderCount();
	
	/**
	 * 根据id获取订单
	 * @param id
	 * @return
	 */
	public Order getOrderById(Integer id);
	
	/**
	 * 更新订单
	 * @param order
	 */
	public void updateOrder(Order order);

}
