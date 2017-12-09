package com.book.boot.model;

import java.sql.Date;

public class HistoryDto {
	private String _id;
	private String title;
	private String pic;
	private int year;
	private int month;
	private int day;
	private String des;
	private String lunar;
	private String content;
	private Date createdDate;
	private Date lastupdataDate;
	
	public HistoryDto() {
		super();
	}

	

	public HistoryDto(String _id, String title, String pic, int year, int month, int day, String des, String lunar,
			String content, Date createdDate, Date lastupdataDate) {
		super();
		this._id = _id;
		this.title = title;
		this.pic = pic;
		this.year = year;
		this.month = month;
		this.day = day;
		this.des = des;
		this.lunar = lunar;
		this.content = content;
		this.createdDate = createdDate;
		this.lastupdataDate = lastupdataDate;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getLastupdataDate() {
		return lastupdataDate;
	}



	public void setLastupdataDate(Date lastupdataDate) {
		this.lastupdataDate = lastupdataDate;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return _id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDes() {
		return des;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	public String getLunar() {
		return lunar;
	}
}
