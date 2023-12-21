<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
<title>로그인</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/loginForm.css' />" type="text/css">
<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}

</script>
</head>

<body>
<div class="container">
      <h1>로그인</h1>
      <form name="form" method="POST" action="<c:url value='/user/login' />">
        <div class="form-control">
          <input type="text" placeholder="아이디" name="userId" />
        </div>

        <div class="form-control">
          <input type="password" placeholder="비밀번호" name="password" />
        </div>

        <input class="btn" type="button" value="로그인" onClick="login()">
        <p>
        <input class="btn" type="button" value="회원가입" onClick="userCreate('<c:url value='/user/register' />')">
      </form>
    </div>
  </body>

</html>
