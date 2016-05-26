package com.hzw.StadiumRentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.StadiumRentalSystem.dao.NewsDao;
import com.hzw.StadiumRentalSystem.entity.News;
import com.hzw.StadiumRentalSystem.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	@Autowired
	NewsDao newsDao;

	@Override
	public Integer save(News entity) {

		return newsDao.save(entity);
	}

	@Override
	public List<News> findAll() {
		return newsDao.findAll();
	}

	@Override
	public List<News> getPagingList(int start, int number) {
		return newsDao.getPagingList(start, number);
	}

	@Override
	public Integer getCount() {
		return newsDao.getCount();
	}

	@Override
	public News findNewsById(Integer id) {
		return newsDao.get(id);
	}

	@Override
	public List<News> getByshow(Integer showstatu) {
		return newsDao.getByShow(showstatu);
	}

	@Override
	public void delNewsById(Integer id) {
		newsDao.delete(id);
		
	}

	@Override
	public News switchShowstatu(Integer id) {
		News news = newsDao.get(id);
		int showStatu = news.getShowstatu();
		news.setShowstatu(showStatu==0?1:0);
		newsDao.update(news);
		return news;
	}

}
