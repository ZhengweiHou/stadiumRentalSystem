package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.RoleDao;
import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.service.RoleService;

/**
 * 角色服务实现
 * @author HZW_922
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();

	}

	@Override
	public Integer save(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role getById(int id) {
		return roleDao.get(id);
	}

}
