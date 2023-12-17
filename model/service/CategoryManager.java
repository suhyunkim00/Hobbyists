package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Category;
import model.dao.CategoryDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * CategoryDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를
 * 별도로 둘 수 있다.
 */
public class CategoryManager {
	private static CategoryManager cateMan = new CategoryManager();
	private CategoryDAO categoryDAO;
	private CategoryAnalysis categoryAanlysis;

	private CategoryManager() {
		try {
			categoryDAO = new CategoryDAO();
			categoryAanlysis = new CategoryAnalysis(categoryDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CategoryManager getInstance() {
		return cateMan;
	}

	public Category create(Category category) throws SQLException, ExistingUserException {
		if (categoryDAO.existingCategory(category.getId())) {
			throw new ExistingUserException(category.getId() + "는 존재하는 카테입니다.");
		}
		return categoryDAO.create(category);
	}

	public int update(Category category) throws SQLException {
		return categoryDAO.update(category);
	}

	public int remove(int cateId) throws SQLException {
		return categoryDAO.remove(cateId);
	}

	public Category findCategory(int categoryId)
		throws SQLException, CategoryNotFoundException {
		Category category = categoryDAO.findCategory(categoryId);

		if (category == null) {
			throw new CategoryNotFoundException(category + "는 존재하지 않습니다.");
		}
		return category;
	}

	public List<Category> findCategoryList() throws SQLException {
			return categoryDAO.findCategoryList();
	}

	public CategoryDAO getCategoryDAO() {
		return this.categoryDAO;
	}
}
