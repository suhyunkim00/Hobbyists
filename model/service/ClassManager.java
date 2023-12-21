package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Category;
import model.Class;
import model.dao.CategoryDAO;
import model.dao.ClassDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * ClassDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class ClassManager {
	private static ClassManager classMan = new ClassManager();
	private ClassDAO classDAO;
	private CategoryDAO cateDAO;
//	private ClassAnalysis ClassAanlysis;

	private ClassManager() {
		try {
			classDAO = new ClassDAO();
			cateDAO = new CategoryDAO();
			//ClassAanlysis = new ClassAnalysis(ClassDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static ClassManager getInstance() {
		return classMan;
	}
	
	public Class create(Class cl) throws SQLException, ExistingClassException {
		if (classDAO.existingClass(cl.getId()) == true) {
			throw new ExistingClassException(cl.getId() + "는 존재하는 클래스입니다.");
		}
		return classDAO.create(cl);
	}

	public int update(Class cl) throws SQLException, ClassNotFoundException {
		int oldCateId = findClass(cl.getTitle()).getCateId();
		if (cl.getCateId() != oldCateId) { 	// 소속 카테고리가 변경됨
			Category cate = cateDAO.findCategory(oldCateId);  // 기존 소속 카테고리
		}
		return classDAO.update(cl);
	}	

	public int remove(String title) throws SQLException, ClassNotFoundException {
		int cateId = findClass(title).getCateId();
		Category cate = cateDAO.findCategory(cateId);  // 소속 커뮤니티
		return classDAO.remove(title);
	}

	public Class findClass(String keyword)
		throws SQLException, ClassNotFoundException {
		Class cl = classDAO.findClass(keyword);
		
		if (keyword == null) {
			throw new ClassNotFoundException(keyword + "는 존재하지 않는 클래스입니다.");
		}		
		return cl;
	}

	public List<Class> findClassList() throws SQLException {
			return classDAO.findClassList();
	}
	
	public Category createCategory(Category cate) throws SQLException {
		return cateDAO.create(cate);		
	}

	public int updateCategory(Category cate) throws SQLException {
		return cateDAO.update(cate);				
	}
	
	public Category findCategory(int cateId) throws SQLException {
		Category cate = cateDAO.findCategory(cateId); 
		
		List<Class> classList = classDAO.findClassesInCategory(cateId);
		cate.setClassList(classList);
		
		int numOfClasses = classDAO.getNumberOfClassesInCategory(cateId);
		cate.setNumOfClasses(numOfClasses);
		return cate;
	}
	
	public List<Category> findCategoryList() throws SQLException {
		return cateDAO.findCategoryList();
	}
	
	public List<Class> findCategoryClasses(int cateId) throws SQLException {
		return classDAO.findClassesInCategory(cateId);
	}

	public ClassDAO getClassDAO() {
		return this.classDAO;
	}
}
