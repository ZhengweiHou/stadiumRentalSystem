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
import com.hzw.StadiumRentalSystem.utils.StadiumTimeUtil;


/**
 * 测试-分时段操作工具
 * @author HZW_922
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
public class TestStadiumTimeUtil {

	private static final Logger LOGGER = Logger
			.getLogger(TestStadiumTimeUtil.class);

	@Autowired
	private StadiumTimeUtil stadiumTimeUtil;

	@Test
	public void save() {
	
	}
	
	

}
