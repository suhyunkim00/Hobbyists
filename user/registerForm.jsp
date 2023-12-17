<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../css/registerForm.css">
<title>Sign Up</title>
<script>
	function check() {
		if(form.userId.value == ""){
			alert("ID를 입력하세요.");
			form.password.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하세요.");
			form.password.focus();
			return false;
		}
		if (form.password.value != form.password2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			form.password.focus();
			return false;
		}
		if (form.name.value == "") {
			alert("이름을 입력하세요.");
			form.name.focus();
			return false;
			
		}
		if (form.nic.value == "") {
			alert("닉네임을 입력하세요.");
			form.nic.focus();
			return false;
			
		}
		
		var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if (emailExp.test(form.email.value) == false) {
			alert("이메일이 유효하지 않습니다.");
			form.email.focus();
			return false;
		}
	
		var itr = document.getElementsByName("interest");

    	var chkCnt = 0;	
    	for(var i=0;i<itr.length; i++){		
    		if(itr[i].checked){			
    			chkCnt++;		
    			}	
    		}	
    	if(chkCnt>3) {		
    		alert("관심 분야는 3개까지 체크 가능합니다!");		
    		obj.checked = false;		
    		return false;	
    	}
    	else {
    		const frm = document.getElementById("frm");
    		frm.submit();
    	}
	}


</script>
</head>
<body>
	<div class="container">
		<h1>Register With Us</h1>
		<form id="frm" method="post" name="form">
			<table boder="" cellspacing="1">
				<tr>
					<td text-align="center">ID</td>
					<td><input type="text" name="userId" /> <input type="button"
						class="btn" value="check" onclick="" /></td>
				</tr>

				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="password" required /></td>
				</tr>

				<tr>
					<td>PASSWORD CHECK</td>
					<td><input type="password" name="password2" required /></td>
				</tr>

				<tr>
					<td>NAME</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td>NICKNAME</td>
					<td><input type="text" name="nic" /></td>
				</tr>

				<tr>
					<td>GENDER</td>
					<td><input type="radio" name="gender" checked />Male <input
						type="radio" name="gender" />Female</td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="email" name="email" /></td>
				</tr>

				<tr>
					<td>LOCATION</td>
					<td><input type="text" /> <input type="button" class="btn"
						value="Search" /></td>
				</tr>
				<tr>
					<td>DETAIL LOCATION</td>
					<td><input type="text" required /></td>
				</tr>

				<tr>
					<td>PHONE</td>
					<td><input type="radio" name="phone" /> SKT <input
						type="radio" name="phone" /> KT <input type="radio" name="phone" />
						LGU+ <br /> <input type="text" name="phone"></td>
				</tr>

				<tr>
					<td>BIRTH</td>
					<td>
						<div>
							<input type="date" value="2002-01-01">
						</div>
					</td>
				</tr>

				<tr>
					<td>INTEREST <span>(3개까지 선택 가능)</span></td>
					<td>
						<div>
							<input type="checkbox" name="interest" id="game" value="game" />
							<label for="game">게임</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="pet" value="pet" /> <label
								for="pet">반려동물</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="study" value="study" />
							<label for="study">스터디</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="sports" value="sports" />
							<label for="sports">스포츠</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="travel" value="travel" />
							<label for="travel">여행</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="art" value="art" /> <label
								for="art">예술</label>
						</div>
						<div>
							<input type="checkbox" name="interest" id="cooking"
								value="cooking" /> <label for="cooking">요리</label>
						</div>
					</td>
				</tr>
			</table>

			<br />
			<div class="btn2">
				<input type="button" class="btn" value="Sign Up"
					onclick="check()" /> <input type="reset" class="btn"
					value="Reset" />
			</div>
		</form>
	</div>
</body>
</html>
