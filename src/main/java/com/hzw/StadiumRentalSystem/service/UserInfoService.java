package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.UserInfo;



/**  
 * 创建时间：2015-2-13 下午1:00:51  
 * @author andy  
 * @version 2.2  
 * 描述： 
 */

public interface UserInfoService {
	UserInfo load(Integer id);

	UserInfo get(Integer id);

	List<UserInfo> findAll();

	void persist(UserInfo entity);

	Integer save(UserInfo entity);

	void saveOrUpdate(UserInfo entity);

	void delete(Integer id);

	void flush();
}
