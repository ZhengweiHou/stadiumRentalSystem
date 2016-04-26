package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Stadium;

/**
 * 体育场服务
 * @author HZW_922
 *
 */
public interface StadiumService {

	/**
	 * 获取页面显示数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Stadium> getPagingList(int start,int number);
	
	/**
	 * 获取数据库中的数据数量
	 * @return
	 */
	public int getStadiumCount();
	
	/**
	 * 验证运动场编号是否重复
	 * @param stadiumNumber
	 * @return 重复则返回true，不重复则放回false
	 */
	public boolean numberIsExist(String stadiumNumber);
	
	/**
	 * 保存运动场
	 * @param stadium
	 * @return
	 */
	public Integer save(Stadium stadium);
	
	/**
	 * 修改运动场
	 * @param stadium
	 * @return
	 */
	public void update(Stadium stadium);
	
	
	/**
	 * 删除运动场
	 * @param id
	 */
	public void delById(Integer id);
}
