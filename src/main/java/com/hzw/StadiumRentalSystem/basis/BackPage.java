package com.hzw.StadiumRentalSystem.basis;

public class BackPage {
	String pagename;
	String pageTitle;
	String pageurl;
	
	
	
	public BackPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BackPage(String pagename, String pageTitle, String pageurl) {
		super();
		this.pagename = pagename;
		this.pageTitle = pageTitle;
		this.pageurl = pageurl;
	}
	public String getPagename() {
		return pagename;
	}
	public String getPageurl() {
		return pageurl;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
}
