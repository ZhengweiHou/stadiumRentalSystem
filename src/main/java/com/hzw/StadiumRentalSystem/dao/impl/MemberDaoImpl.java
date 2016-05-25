package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.MemberDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.Operator;
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
		Member entity = this.get(id);
		this.session().delete(entity);
		
	}
	
	@Override
	public Integer getCount() {
		Criteria c=this.session().createCriteria(Member.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

	@Override
	public List<Member> getPagingList(int start, int number) {
		Query q=this.session().createQuery("from Member"); //查询语句
		q.setFirstResult(start);   //从第start条开始
		q.setMaxResults(number);   //一共取number条
//		q.setShort(name, val);// TODO 排序
		List<Member> members =q.list();
		return members;
	}

	@Override
	public Member getByAccount(String account) {
		Criteria c=this.session().createCriteria(Member.class);
		   c.add(Restrictions.eq("account",account));//eq是等于，gt是大于，lt是小于,or是或
		   List<Member> members = c.list();
		   if(members==null||members.size()<1){
			   return null;
					  
		   }else{
			   for (Member member : members) {
				return member;
			}
		   }
		   return null;
	}
	

	
	
}
