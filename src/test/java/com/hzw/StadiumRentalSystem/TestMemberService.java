package com.hzw.StadiumRentalSystem;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.MemberInfo;
import com.hzw.StadiumRentalSystem.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
public class TestMemberService {

	private static final Logger LOGGER = Logger
			.getLogger(TestMemberService.class);
	
	@Autowired
	MemberService memberService;
	
	
	@Test
	public void save(){
		Member  member = new Member();
		MemberInfo memberinfo = new MemberInfo();
//		memberinfo.setId(1);
//		memberinfo.setMail("qe1qee");
//		memberinfo.setName("q1wee");
		memberinfo.setTel("222111tel");
//		memberinfo.setBirthday(new Timestamp(1929, 12, 12, 12, 11, 11, 11));
//		memberinfo.setMember(member);
//		member.setId(1);
		member.setAccount("account12");
		member.setPassword("passw1ord");
		member.setMemberInfo(memberinfo);
		memberService.save(member);
	}

	@Test
	public void findAll(){
	List<Member> members = memberService.findAll();
	System.out.println(members.size());
	}
}
