package com.hzw.StadiumRentalSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.OrderDao;
import com.hzw.StadiumRentalSystem.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
}
