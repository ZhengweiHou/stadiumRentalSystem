package com.hzw.StadiumRentalSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.StadiumTimeDao;
import com.hzw.StadiumRentalSystem.service.StadiumTimeService;

@Service("stadiumTimeService")
public class StadiumTimeServiceImpl implements StadiumTimeService {
	@Autowired
	StadiumTimeDao stadiumTimeDao;
}
