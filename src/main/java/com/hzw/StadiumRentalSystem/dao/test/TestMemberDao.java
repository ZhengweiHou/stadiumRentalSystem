package com.hzw.StadiumRentalSystem.dao.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzw.StadiumRentalSystem.dao.MemberDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.MemberInfo;
import com.opensymphony.xwork2.inject.Inject;

/**
 * 操作员测试
 * @author HZW_922
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
public class TestMemberDao {

	private static final Logger LOGGER = Logger
			.getLogger(TestMemberDao.class);
	
	@Autowired
	MemberDao memberDao;
	
	@Test
	public void save() {

		Member  member = new Member();
		MemberInfo memberinfo = new MemberInfo();
//		memberinfo.setId(1);
//		memberinfo.setMail("qe1qee");
//		memberinfo.setName("q1wee");
		memberinfo.setTel("111111tel");
//		memberinfo.setBirthday(new Timestamp(1929, 12, 12, 12, 11, 11, 11));
//		memberinfo.setMember(member);
//		member.setId(1);
		member.setAccount("account1");
		member.setPassword("passw1ord");
		member.setMemberInfo(memberinfo);
		memberDao.save(member);
	
		
		
	}
	@Test
	public void findAll(){
		
	}
}
