package com.kh.notice.model.vo;

public class Category {
	private int categoryNo;
	private String categoryContent;
	public Category() {
		super();
	}
	public Category(int categoryNo, String categoryContent) {
		super();
		this.categoryNo = categoryNo;
		this.categoryContent = categoryContent;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryContent() {
		return categoryContent;
	}
	public void setCategoryContent(String categoryContent) {
		this.categoryContent = categoryContent;
	}
	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryContent=" + categoryContent + "]";
	}
	
	
}
