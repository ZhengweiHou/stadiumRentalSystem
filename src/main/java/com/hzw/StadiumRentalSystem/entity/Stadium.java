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
import javax.persistence.Table;

/**
 * 运动场实体
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_stadium", catalog = "stadiumrentaldb")
public class Stadium implements Serializable {

	private static final long serialVersionUID = 5029368507821278646L;

	private Integer id;// 标识

	private String stadiumNumber;// 运动场编号

	/**
	 * 可用性（0：可用，1：不可用）
	 */
	private Integer avaliable;// 可用性

	private String descriptions;// 描述

	private double price;// 价格/时
	
	private Collection<StadiumTime> stadiumTimes; // 预定时间状态


	
	
	
	
	public Stadium() {
		super();
	}

	public Stadium(String stadiumNumber, Integer avaliable,
			String descriptions, double price) {
		super();
		this.stadiumNumber = stadiumNumber;
		this.avaliable = avaliable;
		this.descriptions = descriptions;
		this.price = price;
	}
	
	

	public Stadium(Integer id, String stadiumNumber, Integer avaliable,
			String descriptions, double price) {
		super();
		this.id = id;
		this.stadiumNumber = stadiumNumber;
		this.avaliable = avaliable;
		this.descriptions = descriptions;
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}

	@Column(name = "stadiumNumber", nullable = false, unique = true)
	public String getStadiumNumber() {
		return stadiumNumber;
	}

	@Column(name = "avaliable", nullable = false, unique = false)
	public Integer getAvaliable() {
		return avaliable;
	}

	@Column(name = "descriptions",nullable = true, unique = false)
	public String getDescriptions() {
		return descriptions;
	}

	@Column(name = "price", nullable = false)
	public double getPrice() {
		return price;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST,targetEntity = StadiumTime.class,mappedBy = "stadium")
	public Collection<StadiumTime> getStadiumTimes() {
		return stadiumTimes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStadiumNumber(String stadiumNumber) {
		this.stadiumNumber = stadiumNumber;
	}

	public void setAvaliable(Integer avaliable) {
		this.avaliable = avaliable;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStadiumTimes(Collection<StadiumTime> stadiumTimes) {
		this.stadiumTimes = stadiumTimes;
	}
}
