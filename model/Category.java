package model;

import java.util.List;

/**
 * 카테고리 관리를 위해 필요한 도메인 클래스. Category 테이블과 대응됨
 */
public class Category {
	private int id;
	private String name;
	private List<Category> categoryList;
	
	public Category() { }		// 기본 생성자
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	public void setMemberList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
