package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.StadiumDao;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.service.StadiumService;

@Service("stadiumService")
public class StadiumServiceImpl implements StadiumService {
	@Autowired
	StadiumDao stadiumDao;

	@Override
	public List<Stadium> getPagingList(int start, int number) {
		return stadiumDao.getPagingList(start, number);
	}

	@Override
	public int getStadiumCount() {
		return stadiumDao.getCount();
	}

	@Override
	public boolean numberIsExist(String stadiumNumber) {
		Stadium stadium = stadiumDao.getByNumber(stadiumNumber);
		if(stadium!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Integer save(Stadium stadium) {
		return stadiumDao.save(stadium);
	}

	@Override
	public void update(Stadium stadium) {
		stadiumDao.upDate(stadium);
	}

	@Override
	public void delById(Integer id) {
		stadiumDao.delete(id);
	}
}
