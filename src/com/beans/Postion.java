package com.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Postion implements Serializable{
	
	private static final long serialVersionUID = -4809203266499687164L;
	private Integer id;
	private String nameCn;
	private String nameEn;

	public Postion() {
	}

	public Postion(String nameCn, String nameEn) {
		this.nameCn = nameCn;
		this.nameEn = nameEn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Override
	public String toString() {
		return "Postion [id=" + id + ", nameCn=" + nameCn + ", nameEn=" + nameEn + "]";
	}
}
