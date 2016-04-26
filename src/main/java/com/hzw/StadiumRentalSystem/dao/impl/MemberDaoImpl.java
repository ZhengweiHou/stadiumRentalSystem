package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.MemberDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.Stadium;

@Repository("memberDao")
public class MemberDaoImpl extends BaseDao implements MemberDao {
	@Override
	public Integer save(Member entity) {
		return (Integer) this.session().save(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findAll() {
		List<Member> members = this.session().createQuery("from Member").list();
		
		return members;
	}

	@Override
	public Member get(Integer id) {
		Member member = (Member) this.session().get(Member.class, id);
		return member;
	}

//	@Transactional
	@Override
	public void saveOrUpdate(Member entity) {
		this.session().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Member entity = this.get(id);
		this.session().delete(entity);
		
	}
	
	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(Member.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}
	

	
	
}
