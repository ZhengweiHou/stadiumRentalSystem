package com.hzw.StadiumRentalSystem;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.util.logging.resources.logging;

import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.service.RoleService;

/**
 * 角色测试
 * @author HZW_922
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
public class TestRoleService {

	private static final Logger LOGGER = Logger
			.getLogger(TestRoleService.class);
	
	@Autowired
	RoleService roleService;
	
	@Test
	public void save() {
		Role role = new Role();
		role.setName("管理员");
		roleService.save(role);
	}
	@Test
	public void findAll(){
		List<Role> roles = roleService.findAll();
		System.out.println(roles.size());
	}
}
