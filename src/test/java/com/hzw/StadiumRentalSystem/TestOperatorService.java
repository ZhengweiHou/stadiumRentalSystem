package com.hzw.StadiumRentalSystem;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.util.logging.resources.logging;

import com.hzw.StadiumRentalSystem.dao.OperatorDao;
import com.hzw.StadiumRentalSystem.entity.Operator;
import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.service.OperatorService;
import com.hzw.StadiumRentalSystem.service.RoleService;
import com.hzw.StadiumRentalSystem.utils.MD5;

/**
 * 操作员测试
 * @author HZW_922
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
public class TestOperatorService {

	private static final Logger LOGGER = Logger
			.getLogger(TestOperatorService.class);
	
//	@Autowired
//	OperatorDao operatorDao;
	
	@Autowired
	OperatorService operatorService;
	
	@Test
	public void save() {
		Operator operator = new Operator();
		Role  role = new Role();
		role.setId(1);
		role.setName("管理员");
		operator.setName("hzw");
		operator.setPassword(MD5.MD5("123456"));
		operator.setRole(role);
		operatorService.save(operator);
//		operatorDao.save(operator);
	}
	@Test
	public void findAll(){
		List<Operator> ad = operatorService.findAll();
//		List<Operator> ad = operatorDao.findAll();
		System.out.println("hahaha");
	}
}
