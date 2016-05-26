package com.hzw.StadiumRentalSystem.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzw.StadiumRentalSystem.entity.Member;
import com.hzw.StadiumRentalSystem.entity.MemberInfo;
import com.hzw.StadiumRentalSystem.entity.News;
import com.hzw.StadiumRentalSystem.service.NewsService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 公告Action
 * 
 * @author HZW_922
 * 
 */
@Action("news")
// @Results({ @Result(name = "stadiumUpDate", location =
// "/backpack/stadiumUpdate.jsp")})
public class NewsAction extends WWAction {

	private static final long serialVersionUID = 1L;

	// 特殊属性
	private int id;// 标识
	private String title;// 标题
	private String content; // 内容
	private int showstatu; // 是否显示 0显示，1不显示

	@Autowired
	NewsService newsService;

	/**
	 * 构造方法
	 */
	public NewsAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
		this.data = new HashMap<String, String>();
	}

	/**
	 * 显示公告列表数据
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public void showNewss() throws IOException {
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<News> listNewss = newsService.getPagingList(start, number); // 从数据库中查询数据

		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = newsService.getCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listNewss);// rows键 存放每页记录 list

		this.writerToJsp(jsonMap);

	}

	/**
	 * 前台显示可显示公告
	 * 
	 * @throws IOException
	 */
	public void clientShowNewss() throws IOException {
		List<News> listNewss = newsService.getByshow(0); // 从数据库中查询可显示公告
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		Integer count = newsService.getCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listNewss);// rows键 存放每页记录 list
		this.writerToJsp(jsonMap);

	}

	/**
	 * 删除公告
	 * 
	 * @throws IOException
	 */
	public void delnews() throws IOException {
		newsService.delNewsById(id);
		sendSuccessMsg("已删除！");
	}

	/**
	 * 修改公告的显示状态
	 * 
	 * @throws IOException
	 */
	public void updateShowstatu() throws IOException {
		News news = newsService.switchShowstatu(id);
		if (news != null) {
			// int
			// a=news.getShowstatu()==0?sendSuccessMsg("已删除！"):sendSuccessMsg("已删除！");

			switch (news.getShowstatu()) {
			case 1:
				sendSuccessMsg("切换【" + news.getTitle() + "】为【不显示】");
				break;

			case 0:
				sendSuccessMsg("切换【" + news.getTitle() + "】为【显示】");
				break;
			default:
				break;
			}

		}
		;
	}
	
	/**
	 * 添加公告
	 * @throws IOException 
	 */
	public void addNews() throws IOException{
		News news = new News(title, content, showstatu);
		int n = newsService.save(news);
		if (n > 0) {
			sendSuccessMsg("【" + news.getTitle() + "】添加成功！");
		} else {
			sendFailMsg("添加失败！");
		}
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getShowstatu() {
		return showstatu;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setShowstatu(int showstatu) {
		this.showstatu = showstatu;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

}
