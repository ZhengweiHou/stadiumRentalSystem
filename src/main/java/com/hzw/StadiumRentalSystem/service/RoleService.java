package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Role;

/**
 * 角色服务
 * @author HZW_922
 *
 */
public interface RoleService {
	public List<Role> findAll();
	public Integer save(Role role);
	public Role getById(int id);
}
