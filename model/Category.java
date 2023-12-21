package model;

import java.util.List;

/**
 * 카테고리 관리를 위해 필요한 도메인 클래스. Category 테이블과 대응됨
 */
public class Category {
	private int id;
	private String name;
	private int numOfClasses;
	private List<Class> classList;

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

	public int getNumOfClasses() {
		return numOfClasses;
	}

	public void setNumOfClasses(int numOfClasses) {
		this.numOfClasses = numOfClasses;
	}
	
	public List<Class> getClassList() {
		return classList;
	}

	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
