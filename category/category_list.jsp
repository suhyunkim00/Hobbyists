<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.Category" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
	<br>
	<table style="width:100%">
		<c:forEach var="cate" items="${cateList}">
			<tr>
			  <td class="cateCell">			
				  <a href="<c:url value='/category/category_detail'>
						   <c:param name='cateId' value='${cate.cateId}'/>
						 </c:url>">
				  ${cate.name}</a>
			  </td>
			</tr>
		</c:forEach> 	
</table>	  	 
</main>
</body>
</html>
