package com.hzw.StadiumRentalSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hzw.StadiumRentalSystem.dao.NewsDao;
import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.News;
import com.hzw.StadiumRentalSystem.entity.Stadium;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public News get(Integer id) {
		News news = (News) this.session().get(News.class, id);
		return news;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAll() {
		List<News> newss = this.session().createQuery("from News").list();
		return newss;
	}

	@Override
	public Integer save(News entity) {
		return (Integer) this.session().save(entity);
	}

	@Override
	public void saveOrUpdate(News entity) {
		this.session().saveOrUpdate(entity);

	}

	@Override
	public void delete(Integer id) {
		News entity = this.get(id);
		this.session().delete(entity);

	}

	@Override
	public Integer getCount() {
		Criteria c=this.session().createCriteria(News.class);
		c.setProjection(Projections.rowCount());
		String a = c.uniqueResult().toString();
		return Integer.parseInt(a);
	}

	@Override
	public List<News> getPagingList(int start, int number) {
		Query q=this.session().createQuery("from News"); //查询语句
		q.setFirstResult(start);   //从第start条开始
		q.setMaxResults(number);   //一共取number条
//		q.setShort(name, val);// TODO 排序
		List<News> newss =q.list();
		return newss;
	}

	@Override
	public List<News> getByShow(Integer showstatu) {
		 Criteria c=this.session().createCriteria(News.class);
		   c.add(Restrictions.eq("showstatu",showstatu));//eq是等于，gt是大于，lt是小于,or是或
		   List<News> newss = c.list();
		   if(newss==null||newss.size()<1){
			   return null;
					  
		   }else{
			   return newss;
	
		   }
	}

	@Override
	public void update(News news) {
		this.session().update(news);
	}

}
