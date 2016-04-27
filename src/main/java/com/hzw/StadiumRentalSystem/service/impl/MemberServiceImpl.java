package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.MemberDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	@Override
	public Integer save(Member entity) {
		return memberDao.save(entity);
	}

	@Override
	public List<Member> findAll() {
		
		return memberDao.findAll();
	}

	@Override
	public List<Member> getPagingList(int start, int number) {
		return memberDao.getPagingList(start, number);
	}

	@Override
	public Integer getStadiumCount() {
		return memberDao.getCount();
	}

	
}
