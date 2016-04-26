package com.hzw.StadiumRentalSystem.dao;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Stadium;

public interface StadiumDao extends GenericDao<Stadium, Integer> {

	/**
	 * 根据运动场编号查找运动场
	 * @param stadiumNumber
	 * @return
	 */
	public Stadium getByNumber(String stadiumNumber);
	
	/**
	 * 分页查找数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Stadium> getPagingList(int start, int number);
	
	/**
	 * 更新体育场
	 * @param stadium
	 * @return
	 */
	public void upDate(Stadium stadium);
}
