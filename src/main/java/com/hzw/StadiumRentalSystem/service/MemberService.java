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
}
