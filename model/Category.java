package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

/**
 * 카테고리 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * Category 테이블에서 카테고리 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class CategoryDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CategoryDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 카테고리 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Category create(Category cate) throws SQLException {
		String sql = "INSERT INTO Category VALUES (cateId_seq.nextval, ?)";		
		Object[] param = new Object[] {cate.getName()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		String key[] = {"Id"};	// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		cate.setId(generatedKey); 	// id필드에 저장  
		   	}
		   	return cate;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return null;			
	}

	/**
	 * 기존의 커뮤니티 정보를 수정
	 */
	public int update(Category cate) throws SQLException {
		String sql = "UPDATE Category "
					+ "SET Name=? "
					+ "WHERE Id=?";
		Object[] param = new Object[] {cate.getName(), cate.getId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/**
	 * 주어진 ID에 해당하는 커뮤니티 정보를 삭제.
	 */
	public int remove(String cateId) throws SQLException {
		String sql = "DELETE FROM Category WHERE cId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cateId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진  ID에 해당하는 커뮤니티 정보를 데이터베이스에서 찾아 Category 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Category findCategory(int cateId) throws SQLException {
        String sql = "SELECT Name"
        			+ "FROM Category"
        			+ "WHERE Id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cateId});	// JDBCUtil에 query문과 매개 변수 설정
		Category cate = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 정보 발견
				cate = new Category(		// Category 객체를 생성하여 커뮤니티 정보를 저장
					cateId,
					rs.getString("Name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return cate;
	}

	/**
	 * 전체 카테고리 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Category> findCategoryList() throws SQLException {
        String sql = "SELECT Id, Name"
        		   + "FROM Category"
        		   + "ORDER BY Name";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Category> cateList = new ArrayList<Category>();	// Category들의 리스트 생성
			while (rs.next()) {
				Category cate = new Category(			// Category 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("Id"),
						rs.getString("Name"));
				cateList.add(cate);				// List에 Category 객체 저장
			}		
			return cateList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진  ID에 해당하는 카테고리가 존재하는지 검사 
	 */
	public boolean existingCategory(int cateId) throws SQLException {
		String sql = "SELECT count(*) FROM Category WHRE Id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cateId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
}
