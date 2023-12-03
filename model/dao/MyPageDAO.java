package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.JDBCUtil;
import model.User;

public class myPageDAO {
	private JDBCUtil jdbcUtil = null; public myPageDAO() { 
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/*현재 로그인된 사용자 정보를 가져옴*/
	public List<User> getUserInfo(int userId) throws SQLException { 
		String sql = "SELECT userId, password, name, nickname, gender, birth, phone, email, region " 
				+ "FROM USERINFO " 
				+ "WHERE userID=? "; 
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<User> memList = new ArrayList<User>();
			while (rs.next()) { User user = new User(
					rs.getString("userId"),
					rs.getString("password"),
					rs.getString("name"), 
					rs.getString("nickname"),
					rs.getString("gender"),
					rs.getString("birth"), 
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("region")); 

			memList.add(user);
			} 
			return memList;

		} catch (Exception ex) { 
			ex.printStackTrace();
		}  finally { 
			jdbcUtil.close(); // resource 반환
		} 
		return null; 
	}

	/*기존의 사용자 정보를 수정*/
	public int modifyProfile(User user) throws SQLException { 
		String sql = "UPDATE USERINFO " 
				+ "SET password=?, name=?, nickname=?, birth=?, phone=?, email=?, region=? " 
				+ "WHERE UserId=?"; 
		Object[] param = new Object[] {user.getPassword(), user.getName(), 
				user.get() user.getEmail(), user.getPhone(),
				(user.getCommId()!=0) ? user.getCommId() : null, user.getuserId()};

		jdbcUtil.setSqlAndParameters(sql, param);

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

	/*새 게시물 작성*/
	public int addPost(Post post) throws SQLException { 
		String sql = "INSERT INTO POSTINFO VALUES (?, ?, ?)"; 
		Object[] param = new Object[] {post.getPostId(), post.getPostTitle(), 
				post.getContent(), (post.getPostId()!=0) ? post.getPostId() : null }; 
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정 

		try { 
			int result = jdbcUtil.executeUpdate(); // insert 문 실행 
			return result;
		} catch (Exception ex) { 
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally { 
			jdbcUtil.commit(); 
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}


	/*게시물 ID에 해당하는 게시물을 삭제.*/
	public int deletePost(String postId) throws SQLException { 
		String sql = "DELETE FROM USERINFO WHERE postId=?"; 
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});
		try { 
			int result = jdbcUtil.executeUpdate(); return result;
		} catch (Exception ex) { 
			jdbcUtil.rollback(); ex.printStackTrace();
		} finally {
			jdbcUtil.commit(); jdbcUtil.close();
		} return 0;
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