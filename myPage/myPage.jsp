<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/style.css">
<title>Mypage</title>
</head>
<body>
	<header>
		<div>
			<a href="../main.jsp"><img id="logo" src="../img/logo.png"></a>
		</div>
		<div id="sign">
			<a href="../user/loginForm.jsp" target="_blank">Sign In</a>
			<div></div>
			<a href="../user/registerForm.jsp" target="_blank">Sign Up</a>
		</div>
	</header>
	<nav>
		<ul>
			<li><a href="../category.jsp">Category</a></li>
			<li><a href="../class/best.jsp">Best</a></li>
			<li><a href="./hobbyists.html">Hobbyists</a></li>
			<li><a href="#">Mypage</a></li>
		</ul>
	</nav>
	<main>
		<!--실제로는 사용자 데이터 삽입됨-->
		<span> <img id="pfPic" src="./img/pfSample.png">
			<h4>위치</h4>
			<div>
				<p id="colored">서울특별시 성북구</p>
			</div> <br>
			<h4>관심사</h4>
			<div>
				<ul>
					<li id="colored">일본어</li>
					<li id="colored">프로그래밍</li>
					<li id="colored">베이킹</li>
				</ul>
			</div>
			<h4>취미 신청 리스트</h4>
			<div id="colored">
				<ol>
					<li>This is sample hobby list</li>
					<li>This is sample hobby list</li>
					<li>This is sample hobby list</li>
				</ol>
			</div>
		</span>

		<div class="profile">
			<table width="400px">
				<tr>
					<td>이름</td>
					<td>홍길동</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>둘리야</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>010-0000-0000</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>1234@naver.com</td>
				</tr>
			</table>
		</div>

		<div>
			<button id="colored">수정/탈퇴</button>
			<!--수정 페이지로 이동/하단에 탈퇴 버튼-->
		</div>

		<div id="bdLine"></div>

		<div class="BoardList">
			<h3>내가 쓴 게시물</h3>
			<table>
				<th>
				<td id="tbColored" width="5%">번호</td>
				<td id="tbColored">제목</td>
				<td id="tbColored" width="5%">조회수</td>
				<td id="tbColored" width="5%">추천수</td>
				</th>
				<tr>
					<td id="underline" colspan="5">1</td>
				</tr>
				<tr>
					<td id="underline" colspan="5">2</td>
				</tr>
				<tr>
					<td id="underline" colspan="5">3</td>
				</tr>
			</table>
			<button id="underB">글쓰기</button>
		</div>
	</main>
</body>
</html>
