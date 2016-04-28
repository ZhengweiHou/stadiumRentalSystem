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
import com.hzw.StadiumRentalSystem.service.MemberService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 会员Action
 * 
 * @author HZW_922
 * 
 */
@Action("member")
//@Results({ @Result(name = "stadiumUpDate", location = "/backpack/stadiumUpdate.jsp")})
public class MemberAction extends WWAction {
	
	private static final long serialVersionUID = 1L;
	



	// 特殊属性
	private int id;
	private String account;
	private String password;
	private int infoId; // 信息表id
	private String name;
	private Timestamp birthday;
	private String mail;
	private String tel;

	private Member member;
	private MemberInfo memberInfo;


	@Autowired
	MemberService memberService;
	
	
	/**
	 * 构造方法
	 */
	public MemberAction() {
		super();
		this.ctx = ActionContext.getContext();
		this.response = ServletActionContext.getResponse();
		this.data = new HashMap<String, String>();
	}

	
	/**
	 * 显示会员列表数据
	 * @throws IOException 
	 * 
	 * 
	 */
	public void showMembers() throws IOException{
		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		// 每页显示条数
		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		// 每页的开始记录 第一页为1 第二页为number +1
		int start = (intPage - 1) * number;

		List<Member> listMembers = memberService.getPagingList(start,number); // 从数据库中查询数据
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Integer count = memberService.getStadiumCount(); // 求出总记录数

		// total键 存放总记录数，必须的
		jsonMap.put("total", count);
		jsonMap.put("rows", listMembers);// rows键 存放每页记录 list

		this.writerToJsp(jsonMap);
	
		
		
	}

	public void gitMemberInfo() throws IOException{
		Member members = memberService.findMemberById(id);
		result = new JSONObject(members);
		response.getWriter().write(result.toString());
	}
	
	
	public int getId() {
		return id;
	}


	public String getAccount() {
		return account;
	}


	public String getPassword() {
		return password;
	}


	public int getInfoId() {
		return infoId;
	}


	public String getName() {
		return name;
	}


	public Timestamp getBirthday() {
		return birthday;
	}


	public String getMail() {
		return mail;
	}


	public String getTel() {
		return tel;
	}


	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	

	
	
	
	
	
	
	
}
