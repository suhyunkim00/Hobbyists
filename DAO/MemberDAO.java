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
public class MemberDAO {
	private JDBCUtil jdbcUtil = null;
	
	public MemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Member member) throws SQLException {
		String sql = "INSERT INTO MEMBERINFO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {member.getMemberId(), member.getPassword(), 
						member.getName(), member.getNickname(), member.getGender(), member.getBirth, member.getPhone(),
						member.getEmail(), member.getRegion(), 
						(user.getCommId()!=0) ? user.getCommId() : null };				
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

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int modifyProfile(Member member) throws SQLException {
		String sql = "UPDATE MEMBERINFO "
					+ "SET password=?, name=?, email=?, phone=?, commId=?,
					nickName=?, birth=?, region=?"
					+ "WHERE userid=?";
		Object[] param = new Object[] {member.getPassword(), member.getName(), 
					member.getEmail(), member.getPhone(), member.getNickname(),
					member.getBirth(), member.getRegion(),
					(user.getCommId()!=0) ? user.getCommId() : null, 
					user.getMemberId()};				
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
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int deleteProfile(String memberId) throws SQLException {
		String sql = "DELETE FROM MEMBERINFO WHERE memberid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정

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


	public Member getMemberData(String memberId) throws SQLException {
        String sql = "SELECT password, name, email, phone, ,nickName, gender, birth, region, commId, cName "
        			+ "FROM MEMBERINFO "
        			+ "WHERE userid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {memberId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Member member = new Member(		// Member 객체를 생성하여 학생 정보를 저장
					memberId,
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("nickName"),
					rs.getString("gender"),
					rs.getString("birth"),
					rs.getString("region"),
					rs.getInt("commId"),					
					rs.getString("cName"));
				return member;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Member> getHost() throws SQLException {
        String sql = "SELECT memberId, nickName, email, region, NVL(commId,0) AS commId, cName " 
        		   + "FROM MEMBERINFO "
        		   + "ORDER BY memberId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Member> memberList = new ArrayList<Member>();	// Member들의 리스트 생성
			while (rs.next()) {
				Member member = new Member(			// Member 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("memberId"),
					null,
					rs.getString("nickName"),
					rs.getString("email"),
					rs.getString("region"),
					null,
					rs.getInt("commId"),
					rs.getString("cName"));
				memberList.add(member);				// List에 User 객체 저장
			}		
			return memberList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

}
