package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * Post 테이블에서 커뮤니티 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class PostDAO {
	private JDBCUtil jdbcUtil = null;
	
	public PostDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 커뮤니티 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Post create(Post post) throws SQLException {
		String sql = "INSERT INTO POST VALUES (commId_seq.nextval, ?, ?, SYSDATE, ?)";		
		Object[] param = new Object[] {post.getTitle(), post.getContents(),
			post.getImage(), post.getInterest()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		String key[] = {"title"};	// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		comm.setId(generatedKey); 	// id필드에 저장  
		   	}
		   	return post;
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
	 * 전체 커뮤니티 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Post> sortPostDAO() throws SQLException {
        String sql = "SELECT title, contents, image, interest "
        		   + "GROUP BY contents, image, interest "
        		   + "ORDER BY title";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Post> postList = new ArrayList<Post>();	// Post들의 리스트 생성
			while (rs.next()) {
				Post post = new Post(			// Post 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("title"),
						rs.getString("contents"),
						rs.getString("image"),
						rs.getString("interest"));
				postList.add(post);				// List에 Post 객체 저장
			}		
			return postList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
