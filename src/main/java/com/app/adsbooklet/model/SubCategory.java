package com.app.adsbooklet.model;

public class SubCategory {
	private int id;
	private int mainCategoryId;
	private String name;
	private String form_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMainCategoryId() {
		return mainCategoryId;
	}
	public void setMainCategoryId(int mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForm_name() {
		return form_name;
	}
	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}
	
}
