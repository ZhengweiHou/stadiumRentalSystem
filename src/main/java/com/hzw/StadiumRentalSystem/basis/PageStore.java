package com.hzw.StadiumRentalSystem.basis;

import java.util.HashMap;
import java.util.Map;

public class PageStore {
	public static Map<String, BackPage> pages;
	static{
		pages = new HashMap<String, BackPage>();
		pages.put("personalCenter", new BackPage("personalCenter", "个人中心", "/admin/backPage/personalCenter.jsp"));
		pages.put("operatorManager", new BackPage("operatorManager", "操作员管理", "/admin/backPage/operatorManager.jsp"));
		pages.put("stadiumManager", new BackPage("stadiumManager", "运动场管理", "/admin/backPage/stadiumManager.jsp"));
		
		
		
		}
}