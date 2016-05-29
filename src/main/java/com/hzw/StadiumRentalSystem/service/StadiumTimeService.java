package com.hzw.StadiumRentalSystem.service;

import com.hzw.StadiumRentalSystem.entity.Order;

/**
 * 体育场时间服务
 * @author HZW_922
 *
 */
public interface StadiumTimeService {

	/**
	 * 提交订单修改场地时间状态
	 * @param order
	 */
	public void updateStadiumTimeByEnsureOrder(Order order);
	
	/**
	 * 拒绝订单修改场地时间状态
	 * @param order
	 */
	public void updateStadiumTimeByNosureOrder(Order order);
}
