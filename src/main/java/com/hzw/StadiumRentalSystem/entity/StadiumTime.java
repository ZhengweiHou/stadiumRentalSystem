/**
 * 
 */
package com.hzw.StadiumRentalSystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
 * 运动场每日预定状态
 * @author HZW_922
 *
 */
@Entity
@Table(name = "t_stadiumTime", catalog = "stadiumrentaldb")
public class StadiumTime implements Serializable {


	private static final long serialVersionUID = -2329637858165241401L;

	private Integer id;// 标识
	
	private Stadium stadium; // 运动场

	private Timestamp day;// 日期（标识某一天运动场的状态）
	
	private Integer timeState;// 时间标识数

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}
	
	@ManyToOne(targetEntity = Stadium.class, cascade=CascadeType.PERSIST)
	@JoinColumn(referencedColumnName="id",nullable=false)
	public Stadium getStadium() {
		return stadium;
	}

	@Column(name = "day", nullable = false, unique = true)
	public Timestamp getDay() {
		return day;
	}
	
	@Column(name = "timeState", nullable = false, unique = false)
	public Integer getTimeState() {
		return timeState;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}
	

	public void setDay(Timestamp day) {
		this.day = day;
	}

	public void setTimeState(Integer timeState) {
		this.timeState = timeState;
	}
}
