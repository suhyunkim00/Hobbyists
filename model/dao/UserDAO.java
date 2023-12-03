package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행
 */
public class UserDAO {
    private JDBCUtil jdbcUtil = null;

    public UserDAO() {
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }

    /**
     * 사용자 관리 테이블에 새로운 사용자 생성.
     */
    public int create(User user) throws SQLException {
        String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] { user.getUserId(), user.getPassword(),
                user.getName(), user.getNickname(), user.getGender(), user.getBirth(),
                user.getPhone(),
                user.getEmail(), user.getRegion(),
                (user.getCommId() != 0) ? user.getCommId() : null };
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

    /**
    * 기존의 사용자 정보를 수정.
    */
    public int modifyProfile(User user) throws SQLException {  
        String sql = "UPDATE USERINFO "
        + "SET password=?, name=?, email=?, phone=?, commId=?, nickName=?, birth=?, region=?"
        + "WHERE userid=?";
    Object[] param = new Object[] {user.getPassword(), user.getName(), 
        user.getEmail(), user.getPhone(), user.getNickname(),
        user.getBirth(), user.getRegion(), (user.getCommId()!=0) ? user.getCommId() : null, user.getUserId()};
    
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

    /**
    * 사용자 ID 에 해당하는 사용자를 삭제.
    */
    public int deleteProfile(String memberId) throws SQLException {
        String sql = "DELETE FROM USERINFO WHERE userid=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId}); // JDBCUtil 에 delete 문과 매개 변수설정
        
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
        String sql = "SELECT password, name, email, phone, ,nickName, gender, birth, region, commId, cName "
        + "FROM USERINFO "
        + "WHERE userid=? ";
        
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId}); // JDBCUtil 에 query 문과 매개 변수설정
        
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
            if (rs.next()) { // 학생 정보 발견
                User user = new User( // User 객체를 생성하여 학생 정보를 저장
                userId,
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("nickName"),
                rs.getString("gender"),
                rs.getString("birth"),
                rs.getString("email"),
                rs.getString("region"),
                rs.getString("phone"));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }

    /**
     * 전체 사용자 정보를 검색하여 List 에 저장 및 반환
     */
    public List<User> getHost() throws SQLException {
        String sql = "SELECT userId, nickName, email, region, NVL(commId,0) AS commId, cName "
                + "FROM USERINFO "
                + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil 에 query 문 설정
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
            List<User> userList = new ArrayList<User>(); // Member 들의 리스트 생성
            while (rs.next()) {
                User user = new User( // Member 객체를 생성하여 현재 행의 정보를 저장
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("nickName"),
                    rs.getString("gender"),
                    rs.getString("birth"),
                    rs.getString("email"),
                    rs.getString("region"),
                    rs.getString("phone"));
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
}