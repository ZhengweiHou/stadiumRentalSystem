package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.OperatorDao;
import com.hzw.StadiumRentalSystem.entity.Operator;
import com.hzw.StadiumRentalSystem.service.OperatorService;
import com.hzw.StadiumRentalSystem.utils.MD5;

/**
 * 操作员服务实现
 * 
 * @author HZW_922
 * 
 */
@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorDao operatorDao;

	@Override
	public Operator validate(Operator operator) {
		Operator operatorTemp = operatorDao.getByName(operator.getName());
		if (operatorTemp == null) {
			return null;
		} else {
			if (MD5.MD5(operator.getPassword()).equals(
					operatorTemp.getPassword())) {
				return operatorTemp;
			}
			return null;
		}
	}

	@Override
	public Integer save(Operator operator) {
		return operatorDao.save(operator);
	}

	@Override
	public List<Operator> findAll() {

		return operatorDao.findAll();
	}

	@Override
	public Boolean nameIsExist(String name) {
		Operator operatorTemp = operatorDao.getByName(name);
		if (operatorTemp != null)
			return true;
		else
			return false;
	}

	@Override
	public void update(Operator operator) {

		operatorDao.update(operator);
	}

	@Override
	public List<Operator> getPagingList(int start, int number) {
		return operatorDao.getPagingList(start, number);
	}

	@Override
	public Integer getOperatorCount() {
		Integer conut = operatorDao.getCount();
		return conut;
	}

//	@Override
//	public Operator getByNumber(String number) {
//		return operatorDao.getByNumber(number);
//	}

	@Override
	public void delById(int id) {
		operatorDao.delete(id);

	}
}
