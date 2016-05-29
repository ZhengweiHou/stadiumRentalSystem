package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.StadiumDao;
import com.hzw.StadiumRentalSystem.entity.Operator;
import com.hzw.StadiumRentalSystem.entity.Stadium;

@Repository("stadiumDao")
public class StadiumDaoImpl extends BaseDao implements StadiumDao {

	@Override
	public Stadium get(Integer id) {
		// TODO Auto-generated method stub
		Stadium stadium = (Stadium) this.session().get(Stadium.class, id);
		return stadium;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stadium> findAll() {
		// TODO Auto-generated method stub
		return this.session().createQuery("from Stadium").list();
	}

	@Override
	public Integer save(Stadium entity) {
		// TODO Auto-generated method stub
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(Stadium entity) {
		// TODO Auto-generated method stub
		this.session().saveOrUpdate(entity);
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Stadium entity = this.get(id);
		this.session().delete(entity);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(Stadium.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

	@Override
	public Stadium getByNumber(String stadiumNumber) {
		  Criteria c=this.session().createCriteria(Stadium.class);
		   c.add(Restrictions.eq("stadiumNumber",stadiumNumber));//eq是等于，gt是大于，lt是小于,or是或
		   List<Stadium> stadiums = c.list();
		   if(stadiums==null||stadiums.size()<1){
			   return null;
					  
		   }else{
			   for (Stadium stadium : stadiums) {
				return stadium;
			}
		   }
		   return null;
	}
	
	@Override
	public List<Stadium> getPagingList(int start, int number) {
		Query q=this.session().createQuery("from Stadium"); //查询语句
		q.setFirstResult(start);   //从第start条开始
		q.setMaxResults(number);   //一共取number条
//		q.setShort(name, val);// TODO 排序
		List<Stadium> stadiums =q.list();
		return stadiums;
	}

	@Override
	public void upDate(Stadium stadium) {
		// TODO Auto-generated method stub
		this.session().update(stadium);

	}

	@Override
	public List<Stadium> getCanAvaliableStadium() {
		// TODO Auto-generated method stub
		 Criteria c=this.session().createCriteria(Stadium.class);
		   c.add(Restrictions.eq("avaliable",0));//eq是等于，gt是大于，lt是小于,or是或
		   List<Stadium> stadiums = c.list();
		   if(stadiums==null||stadiums.size()<1){
			   return null;
					  
		   }
			   return stadiums;

	}
	
}
