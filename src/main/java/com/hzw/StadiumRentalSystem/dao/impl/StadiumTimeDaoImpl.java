package com.hzw.StadiumRentalSystem.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.StadiumTimeDao;
import com.hzw.StadiumRentalSystem.entity.Role;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.entity.StadiumTime;

@Repository("stadiumTimeDao")
public class StadiumTimeDaoImpl extends BaseDao implements StadiumTimeDao {

	@Override
	public StadiumTime get(Integer id) {
		// TODO Auto-generated method stub
		StadiumTime stadiumTime = (StadiumTime) this.session().get(
				StadiumTime.class, id);
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
		Criteria c = this.session().createCriteria(StadiumTime.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

	@Override
	public StadiumTime getByStadiumAndDay(Stadium stadium, Timestamp day) {
		// TODO Auto-generated method stub

		// 查找
		Criteria c = this.session().createCriteria(StadiumTime.class);
		c.add(Restrictions.eq("day", day));// eq是等于，gt是大于，lt是小于,or是或
		c.add(Restrictions.eq("stadium", stadium));
		List<StadiumTime> stadiumTimes = c.list();
		if (stadiumTimes == null || stadiumTimes.size() < 1) {
			// 若果查找不到,保存数据
			StadiumTime newStadiumTime = new StadiumTime();
			newStadiumTime.setDay(day);
			newStadiumTime.setStadium(stadium);
			newStadiumTime.setTimeState(0);
			int a = this.save(newStadiumTime);
			return null;
		}
		for (StadiumTime stadiumTime : stadiumTimes) {
			return stadiumTime;
		}
		return null;

	}

	@Override
	public void updateStadiumTimeByEnsureOrder(Stadium stadium, Timestamp day,
			Integer timeState) {
		StadiumTime stadiumTime = this.getByStadiumAndDay(stadium, day);
		Integer oldTimeState = stadiumTime.getTimeState();
		stadiumTime.setTimeState(oldTimeState+timeState);
		
		this.session().update(stadiumTime);
		
	}

	@Override
	public void updateStadiumTimeByNosureOrder(Stadium stadium, Timestamp day,
			Integer timeState) {
		StadiumTime stadiumTime = this.getByStadiumAndDay(stadium, day);
		Integer oldTimeState = stadiumTime.getTimeState();
		stadiumTime.setTimeState(oldTimeState-timeState);
		
		this.session().update(stadiumTime);
		
	}

}
