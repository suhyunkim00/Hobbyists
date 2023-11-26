package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * Category 테이블에서 커뮤니티 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class CategoryDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CategoryDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	/**
	 * 주어진  Category에 해당하는 커뮤니티 정보를 데이터베이스에서 찾아 Category 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Category findCategory(String category) throws SQLException {
        String sql = "SELECT title, contents, image, interest "
        			+ "FROM Post"
        			+ "WHERE category=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {category});	// JDBCUtil에 query문과 매개 변수 설정
		Category cat = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 해당 정보 발견
				cat = new Category(		// Category 객체를 생성하여 커뮤니티 정보를 저장
					category,
					rs.getString("title"),
					rs.getString("contents"),
					rs.getString("image"),
					rs.getString("interest"),
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return cat;
	}
}
