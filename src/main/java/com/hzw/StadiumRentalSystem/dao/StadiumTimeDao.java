package com.hzw.StadiumRentalSystem.dao;

import java.sql.Timestamp;

import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.entity.StadiumTime;

public interface StadiumTimeDao extends GenericDao<StadiumTime, Integer> {

	/**
	 * 查找指定场地指定日期的时间状态对象
	 * @param stadium
	 * @param day
	 * @return
	 */
	public StadiumTime getByStadiumAndDay(Stadium stadium,Timestamp day);
	
	/**
	 * 修改场地时间状态（提交订单）
	 * @param stadium
	 * @param day
	 * @param timeState
	 */
	public void updateStadiumTimeByEnsureOrder(Stadium stadium,Timestamp day,Integer timeState);
	
	/**
	 * 修改场地时间状态（拒绝订单）
	 * @param stadium
	 * @param day
	 * @param timeState
	 */
	public void updateStadiumTimeByNosureOrder(Stadium stadium,Timestamp day,Integer timeState);
	
	
}
