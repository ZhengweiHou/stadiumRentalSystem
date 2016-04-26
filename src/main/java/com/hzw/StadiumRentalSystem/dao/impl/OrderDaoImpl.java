package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.OrderDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.Order;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public Order get(Integer id) {
		// TODO Auto-generated method stub
		Order order = (Order) this.session().get(Order.class, id);
		return order;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		List<Order> orders = this.session().createQuery("from Order").list();
		return orders;
	}

	@Override
	public Integer save(Order entity) {
		// TODO Auto-generated method stub
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(Order entity) {
		// TODO Auto-generated method stub
		this.session().saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Order entity = this.get(id);
		this.session().delete(entity);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(Order.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}



}
