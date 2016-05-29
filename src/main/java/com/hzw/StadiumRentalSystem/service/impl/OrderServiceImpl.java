package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.OrderDao;
import com.hzw.StadiumRentalSystem.entity.Order;
import com.hzw.StadiumRentalSystem.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;

	@Override
	public int saveOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public List<Order> getPagingList(int start, int number) {
		return orderDao.getPagingList(start, number);
	}

	@Override
	public Integer getOrderCount() {
		return orderDao.getCount();
	}

	@Override
	public Order getOrderById(Integer id) {
		return orderDao.get(id);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
		
	}
}
