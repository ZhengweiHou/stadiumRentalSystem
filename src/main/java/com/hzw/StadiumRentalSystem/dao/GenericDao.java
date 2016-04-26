package com.hzw.StadiumRentalSystem.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 通用接口
 * @author HZW_922
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	T get(PK id);

	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();

	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	PK save(T entity);

	/**
	 * 保存或更新
	 * @param entity
	 */
	void saveOrUpdate(T entity);

	/**
	 * 删除
	 * @param id
	 */
	void delete(PK id);
	
	
	/**
	 * 获取数据数量
	 * @return
	 */
	public Integer getCount();
}
