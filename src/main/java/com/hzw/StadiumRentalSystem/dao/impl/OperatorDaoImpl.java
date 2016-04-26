package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.OperatorDao;
import com.hzw.StadiumRentalSystem.entity.Operator;

@Repository("operatorDao")
public class OperatorDaoImpl extends BaseDao implements OperatorDao {

	@Override
	public Operator get(Integer id) {
		Operator operator = (Operator) this.session().get(Operator.class, id);
		return operator;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operator> findAll() {
		List<Operator> operators = this.session().createQuery("from Operator").list();
		return operators;
	}

	@Override
	public Integer save(Operator entity) {
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(Operator entity) {
		// TODO Auto-generated method stub
		 this.session().saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Operator entity = this.get(id);
		this.session().delete(entity);
	}

	@Override
	public Operator getByName(String name) {
		// TODO Auto-generated method stub
//		Operator operator = new Operator();
//		Role  role = new Role();
//		role.setId(1);
//		role.setName("管理员");
//		operator.setName("张三");
//		operator.setNumber("111112");
//		operator.setPassword("1234");
//		operator.setRole(role);
//		operatorService.save(operator);
		
//		List<Operator> operators = this.session().createQuery("from Operator where name="+name).list();
		  Criteria c=this.session().createCriteria(Operator.class);
		   c.add(Restrictions.eq("name",name));//eq是等于，gt是大于，lt是小于,or是或
		   List<Operator> operators = c.list();
		   if(operators==null||operators.size()<1){
			   return null;
					  
		   }else{
			   for (Operator operator : operators) {
				return operator;
			}
		   }
		   return null;

	}

	@Override
	public void update(Operator operator) {
		this.session().update(operator);
	}

	@Override
	public List<Operator> getPagingList(int start, int number) {
		Query q=this.session().createQuery("from Operator"); //查询语句
		q.setFirstResult(start);   //从第start条开始
		q.setMaxResults(number);   //一共取number条
//		q.setShort(name, val);// TODO 排序
		List<Operator> operators =q.list();
		return operators;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(Operator.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

//	@Override
//	public Operator getByNumber(String number) {
//		 Criteria c=this.session().createCriteria(Operator.class);
//		   c.add(Restrictions.eq("number",number));//eq是等于，gt是大于，lt是小于,or是或
//		   List<Operator> operators = c.list();
//		   if(operators==null||operators.size()<1){
//			   return null;
//					  
//		   }else{
//			   for (Operator operator : operators) {
//				return operator;
//			}
//		   }
//		   return null;
//
//	}

}
