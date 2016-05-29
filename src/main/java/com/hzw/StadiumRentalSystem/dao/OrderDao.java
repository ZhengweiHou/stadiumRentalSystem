package com.hzw.StadiumRentalSystem.dao;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Order;

public interface OrderDao extends GenericDao<Order, Integer> {
	/**
	 * 获取页面数据
	 * 
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Order> getPagingList(int start, int number);
	
	/**
	 * 更新订单
	 * @param order
	 */
	public void updateOrder(Order order);
}
