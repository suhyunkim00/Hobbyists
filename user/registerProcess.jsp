<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join Action</title>
</head>
<body>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String userId = request.getParameter("userId");
		String name = request.getParameter("name");
    	String nickName = request.getParameter("nickName");
    	String password = request.getParameter("password");
    	String phone = request.getParameter("phone");
    	String email = request.getParameter("email");
    	String gender = request.getParameter("gender");
    	String birth = request.getParameter("birth");
    	String region = request.getParameter("region");

    	String dbURL = "jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb"; 
		String dbID = "dbp0104";
		String dbPW = "112026";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet re = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPW);

            String sql = "INSERT INTO MEMBER userId, name, nickName, password, phone, eamil, gender, birth, region) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,name);
            pstmt.setString(3,nickName);
            pstmt.setString(4,password);
            pstmt.setString(5,phone);
            pstmt.setString(6,email);
            pstmt.setString(7,gender);
            pstmt.setString(8,birth);
            pstmt.setString(9,region);
            int result = pstmt.executeUpdate();

            out.println("Join Successful");
            
            if(result!=0){
                out.println("<script>");
                out.println("location.href='loginForm.jsp'");
                out.println("</script>");
            }else {
                out.println("<script>");
                out.println("location.href='registerForm.jsp'");
                out.println("</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    %>
</body>
</html>
