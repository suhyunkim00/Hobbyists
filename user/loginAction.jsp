<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.UserDAO" %>
<%@ page import="java.io.PrintWriter" %> <!-- 자바스크립트 문장을 작성하기 위해 사용 -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="model.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<!-- 이렇게되면 이제 이 페이지 안에 넘어온 id와 password가 담기게 됨 usebean의 id와 setProperty의 name은 같다. 매개변수 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>실질적으로 로그인 시도를 처리해주는 페이지</title>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user.getUserId(), user.getPassword()); // UserDAO의 login 메소드에 아이디와 패스워드를 가져온것?
		
		if(result==1){ // userDAO에서 만들어준 로그인이 성공했을때
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href=../index.jsp");
			script.println("</script>");
		}else if(result==0){ // userDAO에서 만들어준 비밀번호가 틀릴때
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()"); // 로그인페이지로 돌려보내는거
			script.println("</script>");
		}else if(result==-1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result==-2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>
