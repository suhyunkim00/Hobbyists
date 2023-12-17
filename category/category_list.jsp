<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*" %>
<!DOCTYPE html>
<%
	@SuppressWarnings("unchecked") 
	List<Category> categoryList = (List<Category>)request.getAttribute("categoryList");
	String CategoryId = (String)request.getAttribute("categoryId");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <title>category</title>
</head>
<body>
    <header>
        <div>
            <a href="../index.jsp"><img id="logo" src="../img/logo.png"></a>
        </div>
        <div id="sign">
            <a href="../user/loginForm.jsp">Sign In</a>
            <div></div>
            <a href="../user/registerForm.jsp">Sign Up</a>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="#">Category</a></li>
            <li><a href="../post/showBestPost.jsp">Best</a></li>
            <li><a href="../post/showAllPost.jsp">Hobbyists</a></li>
            <li><a href="../user/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>
<main>
	<p id="categoryList"></p>
		<br>
		<table style="width:100%">
<% 
	if (categoryList != null) {	
	  Iterator<Category> categoryIter = categoryList.iterator();
	
	  //카테고리 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( categoryIter.hasNext() ) {
		Category category = (Category)categoryIter.next();
%>	  	
	  <c:forEach var="category" items="${categoryList}">  			  	
  		<tr>
		  <td width="190" align="center" height="20">
		  	${category.categoryId}       <%=category.getId() %>
		  </td>
		  <td width="200" style="padding-left: 10">
			<a href="<c:url value='/category/view'>
					   <c:param name='categoryId' value='${category.categoryId}'/>
			 		 </c:url>">
			  ${category.name}	 <%=category.getName()%></a>
		  </td>
		</tr>
	  </c:forEach> 
<%
	  }
	}
%>	 
</table>	  	 
</main>
</body>
</html>
