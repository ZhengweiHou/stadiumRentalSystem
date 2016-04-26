package com.hzw.StadiumRentalSystem.dao;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Operator;

public interface OperatorDao extends GenericDao<Operator, Integer> {
	/**
	 * 根据用户名查找操作员
	 * @param name
	 * @return
	 */
	public Operator getByName(String name);
	
//	/**
//	 * 根据编号查找操作员
//	 * @param name
//	 * @return
//	 */
//	public Operator getByNumber(String number);
	
	/**
	 * 更新用户
	 * @param operator
	 * @return
	 */
	public void update(Operator operator);
	
	/**
	 * 分页查找数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Operator> getPagingList(int start, int number);

	
}
