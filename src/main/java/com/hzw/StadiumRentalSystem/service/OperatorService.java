package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Operator;

/**
 * 操作员服务
 * 
 * @author HZW_922
 * 
 */
public interface OperatorService {
	/**
	 * 操作员验证
	 * @param operator
	 * @return
	 */
	public Operator validate(Operator operator);
	
	/**
	 * 保存
	 * @param operator
	 * @return
	 */
	public Integer save(Operator operator);
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Operator> findAll();
	
	/**
	 * 检查用户名是否存在
	 * @param name
	 * @return 存在返回true，不存在返回false
	 */
	public Boolean nameIsExist(String name);
	
	/**
	 * 修改用户
	 * @param operator
	 * @return
	 */
	public void update(Operator operator);
	
	
	/**
	 * 分页获取数据
	 * @param start 开始位置
	 * @param number 条数
	 * @return
	 */
	public List<Operator> getPagingList(int start,int number);
	
	/**
	 * 获取数据量
	 * @return
	 */
	public Integer getOperatorCount();
	
//	/**
//	 * 根据编号查操作员
//	 * @param number
//	 * @return
//	 */
//	public Operator getByNumber(String number);
	
	/**
	 * 根据id删除操作员
	 * @param id
	 * @return
	 */
	public Operator delById(int id);
}
