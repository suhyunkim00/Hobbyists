package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Class;
import model.User;

/**
* 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
* Class 테이블에서 모임 정보를 추가, 수정, 삭제, 검색 수행
*/
public class ClassDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ClassDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 모임 테이블에 새로운 행 생성 (PK 값은 Sequence 를 이용하여 자동 생성)
	 */
	public Class create(Class cl) throws SQLException {
			String sql = "INSERT INTO Class VALUES (clId_seq.nextval, ?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			Object[] param = new Object[] {cl.getLocation(), cl.getTitle(), cl.getPhoto(),
	cl.getContent(), cl.getUploader(), cl.getView_cnt()};
			jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert 문과 매개 변수 설정
			
			String key[] = {"c_id"}; // PK 컬럼의 이름
			try {
				jdbcUtil.executeUpdate(key); // insert 문 실행
				ResultSet rs = jdbcUtil.getGeneratedKeys();
				if(rs.next()) {
					int generatedKey = rs.getInt(1); // 생성된 PK 값
					cl.setId(generatedKey); // id 필드에 저장
				}
				return cl;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close(); // resource 반환
			}
			return null;
	}
	
	/**
	 * 기존의 모임 정보를 수정
	 */
	public int update(Class cl) throws SQLException {
			String sql = "UPDATE Class "
						+ "SET title=?, cotent=?, photo=? "
						+ "WHERE c_id=?";
			String uploader = cl.getUploader();
			if (uploader.equals("")) uploader = null;
			Object[] param = new Object[] {cl.getTitle(), cl.getContent(),
					uploader, cl.getPhoto()};
			jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 update 문과 매개 변수 설정
			try {
				int result = jdbcUtil.executeUpdate(); // update 문 실행
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}
			finally {
				jdbcUtil.commit();
				jdbcUtil.close(); // resource 반환
			}
			return 0;
	}
	
	/**
	 * 주어진 ID 에 해당하는 모임 정보를 삭제.
	 */
	public int remove(String clId) throws SQLException {
		String sql = "DELETE FROM Class WHERE c_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clId}); // JDBCUtil 에 delete 문과 매개 변수 설정
		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}
	
	/**
	* 주어진 키워드에 해당하는 모임 정보를 데이터베이스에서 찾아 Class 도메인 클래스에
	* 저장하여 반환.
	*/
	public Class findClass(String keyword) throws SQLException {
		String sql = "SELECT location, title, photo, content, uploader, class_view, c_id"
					+ "FROM Class"
					+ "WHERE title LIKE %?% OR content LIKE %?%";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {keyword, keyword}); // JDBCUtil 에 query 문과 매개 변수 설정
		Class cl = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) { // 일치 정보 발견
				cl = new Class( // Class 객체를 생성하여 모임 정보를 저장
					//keyword,
					rs.getString("location"),
					rs.getString("title"),
					rs.getString("photo"),
					rs.getString("content"),
					rs.getString("uploader"),
					rs.getInt("class_view"), 
					rs.getInt("c_id"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close(); // resource 반환
			}
			return cl;
		}
	
	/**
	* 전체 모임 정보를 검색하여(최신순) List 에 저장 및 반환
	*/
	public List<Class> findClassList() throws SQLException {
	String sql = "SELECT c_id, location, title, photo, content, uploadDate, uploader, class_like, class_view"
				+ "FROM Class "
				+ "ORDER BY c_id DESC";
	jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil 에 query 문 설정
	try {
		ResultSet rs = jdbcUtil.executeQuery(); // query 실행
		List<Class> clList = new ArrayList<Class>(); // Class 들의 리스트 생성
		while (rs.next()) {
			Class cl = new Class( // Class 객체를 생성하여 현재 행의 정보를 저장
					//keyword,
					rs.getString("location"),
					rs.getString("title"),
					rs.getString("photo"),
					rs.getString("content"),
					rs.getString("uploader"),
					rs.getInt("class_view"), 
					rs.getInt("c_id"));
			clList.add(cl); // List 에 Class 객체 저장
		}
		return clList;
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		jdbcUtil.close(); // resource 반환
	}
	return null;
	}
	
	//추천수 정렬
	public List<Class> sortLikesClassList() throws SQLException {
		String sql = "SELECT c_id, location, title, photo, content, uploadDate, uploader, class_like, class_view"
					+ "FROM Class"
					+ "ORDER BY class_like DESC, title ASC";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil 에 query 문 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Class> clList = new ArrayList<Class>(); // Class 들의 리스트 생성
			while (rs.next()) {
				Class cl = new Class( // Class 객체를 생성하여 현재 행의 정보를 저장
						//keyword,
						rs.getString("location"),
						rs.getString("title"),
						rs.getString("photo"),
						rs.getString("content"),
						rs.getString("uploader"),
						rs.getInt("class_view"), 
						rs.getInt("c_id"));
					clList.add(cl); // List 에 Class 객체 저장
				}			
				return clList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	
	//추천수 100 개이상인 모임글 가져오기
	public List<Class> BestClassList() throws SQLException {
		String sql = "SELECT c_id, location, title, photo, content, uploadDate, uploader, class_like, class_view"
					+ "FROM Class"
					+ "WHERE class_like >= 100 "
					+ "ORDER BY class_like DESC, title ASC";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil 에 query 문 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Class> clList = new ArrayList<Class>(); // Class 들의 리스트 생성
			while (rs.next()) {
				Class cl = new Class( // Class 객체를 생성하여 현재 행의 정보를 저장
						//keyword,
						rs.getString("location"),
						rs.getString("title"),
						rs.getString("photo"),
						rs.getString("content"),
						rs.getString("uploader"),
						rs.getInt("class_view"), 
						rs.getInt("c_id"));
				clList.add(cl); // List 에 Class 객체 저장
			}
			return clList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	
	/**
	* 주어진 ID 에 해당하는 모임이 존재하는지 검사
	*/
	public boolean existingClass(int clId) throws SQLException {
		String sql = "SELECT count(*) FROM Class WHRE c_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clId}); // JDBCUtil 에 query 문과 매개 변수 설정
		
		try {	
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return false;
	}

	/**
	 * 주어진 ID 에 해당하는 모임 신청 정보를 삭제.
	 */
	public int cancel(String appNum) throws SQLException {
		String sql = "DELETE FROM Apply WHERE appNum=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {appNum}); // JDBCUtil 에 delete 문과 매개 변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
		jdbcUtil.rollback();
		ex.printStackTrace();
	}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
		}
	
	/**
	 * 특정 카테고리에 속한 클래스들을 검색하여 List에 저장 및 반환
	 */
	public List<Class> findClassesInCategory(int categoryId) throws SQLException {
			String sql = "SELECT c_id, location, title, photo, content, uploadDate, uploader, class_like, class_view"
						+ "FROM Class "
						+ "ORDER BY c_id DESC";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {categoryId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Class> classList = new ArrayList<Class>();	// class들의 리스트 생성
			while (rs.next()) {
				Class cl = new Class(			// Class 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("location"),
						rs.getString("title"),
						rs.getString("photo"),
						rs.getString("content"),
						rs.getString("uploader"),
						rs.getInt("class_view"), 
						rs.getInt("c_id"));
				classList.add(cl);			// List에 Class 객체 저장
			}		
			return classList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 특정 카테고리에 속한 클래스들의 수를 count하여 반환
	 */
	public int getNumberOfClassesInCategory(int cateId) {
		String sql = "SELECT COUNT(id) FROM User"
     				+ "WHERE cateId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cateId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
}
