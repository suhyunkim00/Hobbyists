<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, java.util.ArrayList, java.util.Map" %>
<!DOCTYPE html>
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
            <li><a href="../myPage/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>
	<main>
		<div>
			<ul>
				<li><a href="#">게임</a></li>
				<li><a href="#">반려동물</a></li>
				<li><a href="#">스터디</a></li>
				<li><a href="#">스포츠</a></li>
				<li><a href="#">여행</a></li>
				<li><a href="#">예술</a></li>
				<li><a href="#">요리</a></li>
			</ul>
		</div>
    </main>
</body>
</html>
