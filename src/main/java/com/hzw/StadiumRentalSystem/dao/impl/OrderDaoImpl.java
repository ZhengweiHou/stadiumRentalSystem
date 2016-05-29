package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	public List<Order> getPagingList(int start, int number) {
		Query q=this.session().createQuery("from Order"); //查询语句
		q.setFirstResult(start);   //从第start条开始
		q.setMaxResults(number);   //一共取number条
//		q.setShort(name, val);// TODO 排序
		List<Order> orders =q.list();
		return orders;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		this.session().update(order);
		
	}



}
