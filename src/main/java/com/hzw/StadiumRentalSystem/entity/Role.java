package com.hzw.StadiumRentalSystem.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 角色
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_role", catalog = "stadiumrentaldb")
public class Role implements Serializable {

	private static final long serialVersionUID = 1998334713693228344L;

	private int id;// 标识
	
	

	private String name;// 角色名

	private Collection<Operator> operators; // 操作员
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Role(int id) {
		super();
		this.id = id;
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


    @OneToMany(cascade = CascadeType.PERSIST,targetEntity = Operator.class,mappedBy = "role")
	public Collection<Operator> getOperators() {
		return operators;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperators(Collection<Operator> operators) {
		this.operators = operators;
	}
	
	
	
	
}
