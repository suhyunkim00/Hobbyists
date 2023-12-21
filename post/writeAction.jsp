<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="model.Post" %>
<%@ page import="model.dao.PostDAO" %>
<%@ page import="java.io.PrintWriter" %>

<jsp:useBean id="board" class="model.Post" scope="page" />
<jsp:setProperty name="board" property="title" />
<jsp:setProperty name="board" property="content" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<%
	String userID = null;
	if(session.getAttribute("userID") != null) {
		userID = (String)session.getAttribute("userID");
	}
	if(userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 이후 이용가능한 서비스 입니다.')");
		script.println("location.href = '../user/loginForm.jsp'");
		script.println("</script>");
	} else {
		if(board.getTitle() == null || board.getContent() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('모든 칸을 입력해주십시오.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			PostDAO postDao = new PostDAO();
			int result = postDao.write(board.getTitle(), userID, board.getContent());
			 
			if(result >= 0) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'showAllPost.jsp'"); // 경로 수정해야함
				script.println("</script>");
			} else if(result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글 등록에 실패하였습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}
		}
	}
	%>
</body>
</html>
