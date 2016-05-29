package com.hzw.StadiumRentalSystem.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.basis.SystemData;
import com.hzw.StadiumRentalSystem.dao.StadiumDao;
import com.hzw.StadiumRentalSystem.dao.StadiumTimeDao;
import com.hzw.StadiumRentalSystem.entity.Stadium;
import com.hzw.StadiumRentalSystem.entity.StadiumTime;
import com.hzw.StadiumRentalSystem.service.StadiumService;
import com.hzw.StadiumRentalSystem.utils.StadiumTimeUtil;

@Service("stadiumService")
public class StadiumServiceImpl implements StadiumService {
	@Autowired
	StadiumDao stadiumDao;
	@Autowired
	StadiumTimeDao stadiumTimeDao;

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
		if (stadium != null) {
			return true;
		} else {
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

	@Override
	public List<Stadium> clientFindStadiums(String startdt, String enddt,
			Timestamp startday) {
		// TODO Auto-generated method stub

		int indexOfStartdt = SystemData.indexMapTime.indexOf(startdt);
		int indexOfEnddt = SystemData.indexMapTime.indexOf(enddt);
		int timeState = StadiumTimeUtil.bothIndexToDecimal(indexOfStartdt,
				indexOfEnddt);

		// 获取可用场地
		List<Stadium> stadiums = stadiumDao.getCanAvaliableStadium();

		List<Stadium> findStadiums = new ArrayList<Stadium>();
		// 遍历可用场地，根据条件判断该场地是否符合条件
		Iterator<Stadium> iteratorStadiums = stadiums.iterator();
		while(iteratorStadiums.hasNext()){
			Stadium tempStadium = iteratorStadiums.next();
			StadiumTime stadiumTime = stadiumTimeDao.getByStadiumAndDay(tempStadium, startday);
			
			if(stadiumTime==null||!StadiumTimeUtil.bitsIsRepeat(stadiumTime.getTimeState(), timeState)){
				findStadiums.add(tempStadium);
			}			
		}
		
		
		// stadiumDao.

		return findStadiums;
	}

	@Override
	public Stadium getStadiumById(int id) {
		// TODO Auto-generated method stub
		return stadiumDao.get(id);
	}
}
