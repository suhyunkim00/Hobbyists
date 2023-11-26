import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.member;
import model.post;
import model.dao.JDBCUtil;

public class myPageDAO {
	private JDBCUtil jdbcUtil = null;
	
	public myPageDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/*현재 로그인된 사용자 정보를 가져옴*/
    public List<Member> getMemberInfo(int memberId) throws SQLException {
        String sql = "SELECT memberId, password, name, nickname, gender, birth, phone, email, region "
     				+ "FROM MEMBERINFO "
                    + "WHERE memberID=? ";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {memberId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Member> memList = new ArrayList<Member>();	// member들의 리스트 생성
			while (rs.next()) {
				Member member = new Member(			// User 객체를 생성하여 현재 행의 정보를 저장
				rs.getString("memberId"),
                    		rs.getString("password"),
				rs.getString("name"),
                    		rs.getString("nickname"),
                    		rs.getString("gender"),
                    		rs.getString("birth"),
				rs.getString("phone"),
				rs.getString("email"),
                    		rs.getString("region"));
				
				memList.add(member);			// List에 Community 객체 저장
			}		
			return memList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/*기존의 사용자 정보를 수정*/
	public int modifyProfile(Member member) throws SQLException {
		String sql = "UPDATE MEMBERINFO "
					+ "SET password=?, name=?, nickname=?, birth=?, phone=?, email=?, region=? "
					+ "WHERE MemberId=?";
		Object[] param = new Object[] {member.getPassword(), member.getName(), member.get()
					member.getEmail(), member.getPhone(), 
					(member.getCommId()!=0) ? member.getCommId() : null, 
					member.getmemberId()};				
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

    /*새 게시물 작성*/
    public int addPost(Post post) throws SQLException {
		String sql = "INSERT INTO POSTINFO VALUES (?, ?, ?)";		
		Object[] param = new Object[] {post.getPostId(),
                            post.getPostTitle(), post.getContent(), 
						    (post.getPostId()!=0) ? post.getPostId() : null };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/*게시물 ID에 해당하는 게시물을 삭제.*/
	public int deletePost(String postId) throws SQLException {
		String sql = "DELETE FROM MEMBERINFO WHERE postId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	/*전체 게시물을 검색하여 List에 저장 및 반환*/
	public List<post> showList() throws SQLException {
        String sql = "SELECT postId, postTitle "
                    + "FROM POSTINFO ";
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<post> postList = new ArrayList<post>();
			while (rs.next()) {
				Post post = new post(
					rs.getString("postId"),
					rs.getString("postTitle"),
					null);
				postList.add(post);
			}		
			return postList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
