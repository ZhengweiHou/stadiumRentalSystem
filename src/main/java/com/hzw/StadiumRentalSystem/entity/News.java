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
 * 公告
 * 
 * @author HZW_922
 * 
 */
@Entity
@Table(name = "t_news", catalog = "stadiumrentaldb")
public class News implements Serializable {


	private static final long serialVersionUID = 7583723701297162707L;

	private int id;// 标识

	private String title;// 标题

	private String content; // 内容


	private int showstatu=0; // 是否显示 0显示，1不显示

	
	
	public News() {
		super();
	}

	public News(String title, String content, int showstatu) {
		super();
		this.title = title;
		this.content = content;
		this.showstatu = showstatu;
	}

	public News(int id, String title, String content, int showstatu) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.showstatu = showstatu;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}
	
	@Column(name = "showstatu", nullable = false)
	public int getShowstatu() {
		return showstatu;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setShowstatu(int showstatu) {
		this.showstatu = showstatu;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
