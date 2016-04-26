package com.hzw.StadiumRentalSystem;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.hzw.StadiumRentalSystem.entity.UserInfo;
import com.hzw.StadiumRentalSystem.service.UserInfoService;

/**
 * 创建时间：2015-2-13 下午3:31:07
 * 
 * @author andy
 * @version 2.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
public class TestUserService {

	private static final Logger LOGGER = Logger
			.getLogger(TestUserService.class);

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void save() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("zty");
		userInfo.setAge(23);
		userInfo.setTelephone("13212221333");
		Integer id = userInfoService.save(userInfo);
		JSON.toJSONString(id);
	}
	
	@Test
	public void find(){
		List<UserInfo> userinfos = userInfoService.findAll();
		System.out.println("222222+"+userinfos.size());
		
	}

}
