package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.StadiumTimeDao;
import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.entity.StadiumTime;

@Repository("stadiumTimeDao")
public class StadiumTimeDaoImpl extends BaseDao implements StadiumTimeDao {

	@Override
	public StadiumTime get(Integer id) {
		// TODO Auto-generated method stub
		StadiumTime stadiumTime = (StadiumTime) this.session().get(StadiumTime.class, id);
		return stadiumTime;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StadiumTime> findAll() {
		// TODO Auto-generated method stub
		return this.session().createQuery("from StadiumTime").list();
	}

	@Override
	public Integer save(StadiumTime entity) {
		// TODO Auto-generated method stub
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(StadiumTime entity) {
		// TODO Auto-generated method stub
		this.session().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		StadiumTime entity = this.get(id);
		this.session().delete(entity);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(StadiumTime.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

}
