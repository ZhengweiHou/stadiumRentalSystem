package com.hzw.StadiumRentalSystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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

import org.springframework.test.annotation.Timed;

/**
 * 会员信息
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_memberInfo", catalog = "stadiumrentaldb")
public class MemberInfo implements Serializable {

	private static final long serialVersionUID = 6350704354014479923L;

	private int id;

	private String name;

	private Timestamp birthday;

	private String mail;

	private String tel;

	private Member member;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "birthday")
	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "tel", nullable = false)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "account", referencedColumnName = "account")
	// @JoinColumn(name = "account", referencedColumnName = "account", unique =
	// true,insertable=false,updatable=false)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
