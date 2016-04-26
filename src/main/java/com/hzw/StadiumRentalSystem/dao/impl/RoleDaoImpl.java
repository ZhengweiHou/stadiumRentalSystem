package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.RoleDao;
import com.hzw.StadiumRentalSystem.entity.Order;
import com.hzw.StadiumRentalSystem.entity.Role;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDao implements RoleDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		List<Role> roles = this.session().createQuery("from Role").list();
		return roles;
	}

	@Override
	public Role get(Integer id) {
		// TODO Auto-generated method stub
		Role role = (Role) this.session().get(Role.class, id);
		return role;
	}

	@Override
	public Integer save(Role entity) {
		
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		this.session().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Role entity = this.get(id);
		this.session().delete(entity);
		
	}
	
	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Criteria c=this.session().createCriteria(Role.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}
}
