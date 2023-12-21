package model.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.service.UserNotFoundException;


public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb";
			String dbID = "dbp0104";
			String dbPW = "112026";
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			// 여기까지가 mysql에 접속 할 수 있게 해주는 부분
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인을 시도하는 하나의 함수
	public int login(String userID, String userPassword) {
		
		String SQL = "SELECT userPassword FROM MEMBER WHERE userID =?";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; // 로그인성공
				}else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}
	
    /*private JDBCUtil jdbcUtil = null;

    public UserDAO() {
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }


    public int create(User user) throws SQLException {
        String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] { user.getUserId(), user.getPassword(),
                user.getName(), user.getNickName(), user.getGender(), user.getBirth(),
                user.getPhone(),
                user.getEmail(), user.getRegion() };
        jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert 문과 매개 변수 설정
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


    public int modifyProfile(User user) throws SQLException {  
        String sql = "UPDATE USERINFO "
        + "SET password=?, name=?, email=?, phone=?, nickName=?, birth=?, region=?"
        + "WHERE userid=?";
    Object[] param = new Object[] {user.getPassword(), user.getName(), 
        user.getEmail(), user.getPhone(), user.getNickName(),
        user.getBirth(), user.getRegion()};
    
        jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 update 문과 매개 변수 설정

        try {
            int result = jdbcUtil.executeUpdate(); // update 문 실행
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


    public int deleteProfile(String memberId) throws SQLException {
        String sql = "DELETE FROM USERINFO WHERE userid=?";
        JDBCUtil jdbcUtil2 = new JDBCUtil();
		jdbcUtil2.setSqlAndParameters(sql, new Object[] {User.getUserId()}); // JDBCUtil 에 delete 문과 매개 변수설정
        
        try {
            int result = jdbcUtil.executeUpdate(); // delete 문 실행
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
    
    public User getUserData(String userId) throws SQLException {
        String sql = "SELECT password, name, email, phone, nickName, gender, birth, region "
        + "FROM USERINFO "
        + "WHERE userid=? ";
        
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId}); // JDBCUtil 에 query 문과 매개 변수설정
        
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
            if (rs.next()) { // 학생 정보 발견
                User user = new User( // User 객체를 생성하여 학생 정보를 저장
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("nickName"),
                rs.getString("gender"),
                rs.getString("birth"),
                rs.getString("region"));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }

 
    public List<User> getHost() throws SQLException {
        String sql = "SELECT userId, nickName, email, region, NVL(commId,0) AS commId, cName "
                + "FROM USERINFO "
                + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null);
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("nickName"),
                    rs.getString("gender"),
                    rs.getString("birth"),
                    rs.getString("email"),
                    rs.getString("region"),
                    rs.getString("phone")) ;
                	userList.add(user); // List 에 User 객체 저장
            }
            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }

	public User findUser(String userId) throws UserNotFoundException {
		User[] users = null;
		for(User user : users) {
			if(user.getUserId().equals(Long.valueOf(userId))) {
				return user;
			}
		}
		throw new UserNotFoundException();
		//throw new ClientException(String.format("User id: %d not found!", user.getId()));
	}

	public List<User> findUserList(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existingUser(String userId) {
		// TODO Auto-generated method stub
		return false;
	}*/

}
