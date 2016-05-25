package com.hzw.StadiumRentalSystem.dao;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Member;

public interface MemberDao extends GenericDao<Member, Integer>{
	/**
	 * 获取分页数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Member> getPagingList(int start, int number);
	
	
	/**
	 * 根据账户获取用户
	 * @param account
	 * @return
	 */
	public Member getByAccount(String account);
}
