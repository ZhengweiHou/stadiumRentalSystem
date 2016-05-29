package com.hzw.StadiumRentalSystem.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.StadiumTimeDao;
import com.hzw.StadiumRentalSystem.entity.Order;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.service.StadiumTimeService;

@Service("stadiumTimeService")
public class StadiumTimeServiceImpl implements StadiumTimeService {
	@Autowired
	StadiumTimeDao stadiumTimeDao;

	@Override
	public void updateStadiumTimeByEnsureOrder(Order order) {
		Timestamp day = order.getDestineDay();
		Integer timeState = order.getUseTimeState();
		Stadium stadium = order.getStadium();
		
		stadiumTimeDao.updateStadiumTimeByEnsureOrder(stadium, day, timeState);
	}

	@Override
	public void updateStadiumTimeByNosureOrder(Order order) {
		Timestamp day = order.getDestineDay();
		Integer timeState = order.getUseTimeState();
		Stadium stadium = order.getStadium();
		
		stadiumTimeDao.updateStadiumTimeByNosureOrder(stadium, day, timeState);
		
	}
}
