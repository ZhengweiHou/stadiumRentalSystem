package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.UserInfoDao;
import com.hzw.StadiumRentalSystem.entity.UserInfo;
import com.hzw.StadiumRentalSystem.service.UserInfoService;

/**
 * 创建时间：2015-2-13 下午1:03:47
 * 
 * @author andy
 * @version 2.2 描述：
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo load(Integer id) {
		return null;
	}

	@Override
	public UserInfo get(Integer id) {
		return userInfoDao.get(id);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.findAll();
	}

	@Override
	public void persist(UserInfo entity) {
		userInfoDao.persist(entity);
	}

	@Override
	public Integer save(UserInfo entity) {
		return userInfoDao.save(entity);
	}

	@Override
	public void saveOrUpdate(UserInfo entity) {
		userInfoDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		userInfoDao.delete(id);
	}

	@Override
	public void flush() {
		userInfoDao.flush();
	}

}
