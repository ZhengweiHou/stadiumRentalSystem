package com.hzw.StadiumRentalSystem.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class WWAction extends ActionSupport{

	protected Map<String, String> data;
	protected HttpServletResponse response;
	protected ActionContext ctx;

	protected JSONObject result; // 返回的json
	protected String rows; // 每页显示的记录数
	protected String page; // 当前第几页
	protected String sortOrder;// 排序方式
	protected String sortName; // 排序字段
	
	public WWAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
		this.data = new HashMap<String, String>();
	}

	public void sendSuccessMsg(String msg) throws IOException{
		data.put("result", "1");
		data.put("msg", msg);
		this.writerToJsp(data);
	}
	
	public void sendErroMsg(String msg) throws IOException{
		data.put("result", "0");
		data.put("msg", msg);
		this.writerToJsp(data);
	}
	
	public void sendFailMsg(String msg) throws IOException{
		data.put("result", "0");
		data.put("msg", msg);
		this.writerToJsp(data);
	}
	
	/**
	 * @param Map<String, String> data
	 * @throws IOException
	 */
	public void sendSuccessMap(Map<String, String> map) throws IOException{
		map.put("result", "1");
		this.writerToJsp(map);
	}
	
	public void sendSuccessData() throws IOException{
		data.put("result", "1");
		this.writerToJsp(data);
	}
	
	
	public void writerToJsp(Map<?, ?> data) throws IOException{
		result = new JSONObject(data);
		response.getWriter().write(result.toString());
	}
	
	public Map<String, String> getData() {
		return data;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public JSONObject getResult() {
		return result;
	}

	public String getRows() {
		return rows;
	}

	public String getPage() {
		return page;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public String getSortName() {
		return sortName;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	
	
	
}
