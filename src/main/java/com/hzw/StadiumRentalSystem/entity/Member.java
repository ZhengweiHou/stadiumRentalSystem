package com.hzw.StadiumRentalSystem.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 会员
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_member", catalog = "stadiumrentaldb")
public class Member implements Serializable {

	private static final long serialVersionUID = -8205329715606233936L;

	private int id;// 标识

	private String account;// 账户

	private String password; // 密码

//	private String tel;

	private MemberInfo memberInfo; // 账户信息

	
	
	public Member() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "account", unique = true, nullable = false)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	public MemberInfo getMemberInfo() {
//		return memberInfo;
//	}
//
//	public void setMemberInfo(MemberInfo memberInfo) {
//
//		this.memberInfo = memberInfo;
////		this.tel = memberInfo.getTel();
//		this.memberInfo.setMember(this);
//	}
	
//	@OneToOne(targetEntity = MemberInfo.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToOne(cascade = CascadeType.ALL)
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {

		this.memberInfo = memberInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	public String getTel() {
//		return tel;
//	}

//	public void setTel(String tel) {
//		this.tel = tel;
//	}

}
