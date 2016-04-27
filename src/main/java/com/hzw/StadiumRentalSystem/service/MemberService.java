package com.hzw.StadiumRentalSystem.service;

import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.MemberInfo;
import com.hzw.StadiumRentalSystem.entity.UserInfo;

/**
 * 会员服务类
 * 
 * @author HZW_922
 * 
 */
public interface MemberService {
	/**
	 * 保存会员
	 * @param entity
	 * @return
	 */
	Integer save(Member entity);

	/**
	 * 获取所有会员
	 * @return
	 */
	List<Member> findAll();
	
	/**
	 * 获取页面分页显示数据
	 * @param start
	 * @param number
	 * @return
	 */
	List<Member> getPagingList(int start,int number);
	
	/**
	 * 获取数据库中数据数量
	 * @return
	 */
	Integer getStadiumCount();
}
