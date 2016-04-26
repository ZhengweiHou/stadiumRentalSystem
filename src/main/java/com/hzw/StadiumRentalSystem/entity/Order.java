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
 * 订单
 * @author HZW_922
 *
 */
@Entity
@Table(name = "t_order", catalog = "stadiumrentaldb")
public class Order implements Serializable {


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -4658494588999978113L;

	private Integer id;// 标识
	
//	private String memberAccount;// 会员账号
	private Member member;// 会员
	
//	private String stadiumNum;// 场地编号
	private Stadium stadium; // 运动场
	
	private Timestamp createTime;// 订单创建时间
	
	private Timestamp startTime;// 运动开始时间
	
	private Integer useTimeState; // 时间段标识数
	
	private String state;// 订单状态
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}

	@ManyToOne(targetEntity = Member.class, cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id",nullable=false)
	public Member getMember() {
		return member;
	}

	@ManyToOne(targetEntity = Stadium.class, cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id",nullable=false)
	public Stadium getStadium() {
		return stadium;
	}

	@Column(name = "createTime", unique = false, nullable = false)
	public Timestamp getCreateTime() {
		return createTime;
	}

	@Column(name = "startTime", unique = false, nullable = false)
	public Timestamp getStartTime() {
		return startTime;
	}

	@Column(name = "useTimeState", unique = false, nullable = false)
	public Integer getUseTimeState() {
		return useTimeState;
	}

	@Column(name = "state", unique = false, nullable = false)
	public String getState() {
		return state;
	}

	@Column(name = "rebate", unique = false, nullable = false)
	public double getRebate() {
		return rebate;
	}

	@Column(name = "price", unique = false, nullable = false)
	public double getPrice() {
		return price;
	}

	@Column(name = "total", unique = false, nullable = false)
	public double getTotal() {
		return total;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public void setUseTimeState(Integer useTimeState) {
		this.useTimeState = useTimeState;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private double rebate=1;// 折扣
	
	private double price;// 单价/时
	
	private double total;// 总价
	
}
