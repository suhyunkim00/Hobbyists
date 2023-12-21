<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/registerForm.css' />" type="text/css">
<script>
	function userCreate() {
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
		if (form.password.value != form.password2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			form.name.focus();
			return false;
		}
		if (form.name.value == "") {
			alert("이름을 입력하십시오.");
			form.name.focus();
			return false;
		}
		
		var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if (emailExp.test(form.email.value) == false) {
			alert("이메일 형식이 올바르지 않습니다.");
			form.email.focus();
			return false;
		}
		
		var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
		if (phoneExp.test(form.phone.value) == false) {
			alert("전화번호 형식이 올바르지 않습니다.");
			form.phone.focus();
			return false;
		}
		
		if (form.interest.value == "") {
			alert("관심사를 입력하십시오.");
			return false;
		}
		
		if (form.loc.value == "") {
			alert("지역을 입력하십시오.");
			form.loc.focus();
			return false;
		}
		
		form.submit();
	}
</script>
</head>

<body>
	<!-- registration form  -->
	
	<c:if test="${registerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    
	<div class="container">
		<h1>회원가입</h1>
	<form name="form" method="POST"
		action="<c:url value='/user/register' />">

		<table cellspacing="1">
			<tr>
				<td text-align="center">아이디</td>
				<td><input type="text" name="userId" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="password2" /></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nic" /></td>
			</tr>

			<tr>
				<td>성별</td>
				<td>
				<input type="radio" name="gender" checked />여
				<input type="radio" name="gender" />남
				</td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" 
				<c:if test="${registerFailed}">value="${user.email}"</c:if>
				/></td>
			</tr>

			<tr>
				<td>지역</td>
				<td><select name="location">
						<option value="Gangwon">강원도</option>
						<option value="Gyeonggi">경기도</option>
						<option value="GyeongN">경상남도</option>
						<option value="GyeongB">경상북도</option>
						<option value="Gwangju">광주광역시</option>
						<option value="Daegu">대구광역시</option>
						<option value="Daejeon">대전광역시</option>
						<option value="Busan">부산광역시</option>
						<option value="Seoul">서울특별시</option>
						<option value="Ulsan">울산광역시</option>
						<option value="Incheon">인천광역시</option>
						<option value="JeonN">전라남도</option>
						<option value="JeonB">전라북도</option>
						<option value="ChungN">충청남도</option>
						<option value="ChungB">충청북도</option>
				</select></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td>생일</td>
				<td>
					<div>
						<input type="date" value="2002-01-01">
					</div>
				</td>
			</tr>

			<tr>
				<td>관심사</td>
				<td>
					<div>
						<input type="radio" name="interest" id="game" value="game" />
						<label for="game">게임</label>
					</div>
					<div>
						<input type="radio" name="interest" id="pet" value="pet" /> <label
							for="pet">반려동물</label>
					</div>
					<div>
						<input type="radio" name="interest" id="study" value="study" />
						<label for="study">스터디</label>
					</div>
					<div>
						<input type="radio" name="interest" id="sports" value="sports" />
						<label for="sports">스포츠</label>
					</div>
					<div>
						<input type="radio" name="interest" id="travel" value="travel" />
						<label for="travel">여행</label>
					</div>
					<div>
						<input type="radio" name="interest" id="art" value="art" /> <label
							for="art">예술</label>
					</div>
					<div>
						<input type="radio" name="interest" id="cooking"
							value="cooking" /> <label for="cooking">요리</label>
					</div>
				</td>
			</tr>
		</table>

		<div class="btn2">
			<input type="button" class="btn" value="회원가입"
				onclick="userCreate()" /> <input type="reset" class="btn"
				value="초기화" />
		</div>
	</form>
	</div>
</body>
</html>
