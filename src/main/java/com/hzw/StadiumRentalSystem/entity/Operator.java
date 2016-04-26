package com.hzw.StadiumRentalSystem.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 操作员
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_operator", catalog = "stadiumrentaldb")
public class Operator implements Serializable {

	private static final long serialVersionUID = -6570710693147382982L;

	private int id;// 标识

	private String name; // 姓名

	private String password; // 密码

	private Role role;// 角色
	
	public Operator(){
		super();
	}
	
	public Operator(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Operator( String name, String password,
			Role role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}


	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	@ManyToOne(targetEntity = Role.class, cascade=CascadeType.PERSIST)
	@JoinColumn(referencedColumnName="id",nullable=false)
	public Role getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

}
