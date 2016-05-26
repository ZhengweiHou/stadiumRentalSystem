package com.hzw.StadiumRentalSystem;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzw.StadiumRentalSystem.entity.News;
import com.hzw.StadiumRentalSystem.service.NewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-hibernate.xml"})
public class TestNewsService {

	private static final Logger LOGGER = Logger
			.getLogger(TestNewsService.class);
	
	@Autowired
	NewsService newsService;
	
	
	@Test
	public void save(){
		News news = new News();
		news.setTitle("ha阿斯扥啊三扥as发送ha");
		news.setContent("哈防监控很空狠辣放啊哈");
		news.setShowstatu(0);
		newsService.save(news);
	}

	@Test
	public void findAll(){
	List<News> newss = newsService.findAll();
	System.out.println(newss.size());
	}
}
