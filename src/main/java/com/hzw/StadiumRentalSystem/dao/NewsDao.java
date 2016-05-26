package com.hzw.StadiumRentalSystem.dao;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.News;
import com.hzw.StadiumRentalSystem.entity.Stadium;

public interface NewsDao extends GenericDao<News, Integer>{
	
	/**
	 * 获取分页数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<News> getPagingList(int start, int number);
	
	/**
	 * 根据显示状态获取所有公告
	 * @param Show
	 * @return
	 */
	public List<News> getByShow(Integer showstatu);
	
	/**
	 * 更新
	 * @param news
	 */
	public void update(News news);
}
