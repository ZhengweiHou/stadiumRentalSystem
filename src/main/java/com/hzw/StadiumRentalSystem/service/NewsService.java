package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.News;

/**
 * 公告服务类
 * 
 * @author HZW_922
 * 
 */
public interface NewsService {
	/**
	 * 保存公告
	 * @param entity
	 * @return
	 */
	public Integer save(News entity);

	/**
	 * 获取所有公告
	 * @return
	 */
	public List<News> findAll();
	
	/**
	 * 获取页面分页显示数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<News> getPagingList(int start,int number);
	
	/**
	 * 获取数据库中数据数量
	 * @return
	 */
	public Integer getCount();
	
	/**
	 * 获取指定id的公告
	 * @param id
	 * @return
	 */
	public News findNewsById(Integer id);
	
	/**
	 * 根据显示状态获取所有公告
	 * @param show
	 * @return
	 */
	public List<News> getByshow(Integer showstatu);
	
	/**
	 * 根据id删除公告
	 * @param id
	 */
	public void delNewsById(Integer id);
	
	
	/**
	 * 切换指定id公告的显示状态
	 * @param id
	 * @return
	 */
	public News switchShowstatu(Integer id);
	
}
