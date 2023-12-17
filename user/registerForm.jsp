<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../css/registerForm.css">
<title>Form Validator</title>
<script>
	function userCreate() {
		if (form.userId.value == "") {
			alert("Enter a user ID.");
			form.userId.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("Enter a user Password.");
			form.password.focus();
			return false;
		}
		if (form.password.value != form.password2.value) {
			alert("Password does not match.");
			form.name.focus();
			return false;
		}
		if (form.name.value == "") {
			alert("Enter a your name.");
			form.name.focus();
			return false;
		}
		var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if (emailExp.test(form.email.value) == false) {
			alert("Email format is not valid.");
			form.email.focus();
			return false;
		}
		var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
		if (phoneExp.test(form.phone.value) == false) {
			alert("Phone number format is not valid.");
			form.phone.focus();
			return false;
		}
		form.submit();
	}

	function userList(targetUri) {
		form.action = targetUri;
		form.submit();
	}

	function selectChkBox(obj){
	    	var itr = document.getElementsByName("interest");
	
	    	var chkCnt = 0;	
	    	for(var i=0;i<itr.length; i++){		
	    		if(itr[i].checked){			
	    			chkCnt++;		
	    			}	
	    		}	
	    	if(chkCnt>3){		
	    		alert("3개까지 체크 가능합니다!");		
	    		obj.checked = false;		
	    		return false;	
	    	}
    }
</script>
</head>
<body>
	<div class="container">
		<h1>Register With Us</h1>
		<form>
			<table boder="" cellspacing="1">
				<tr>
					<td text-align="center">ID</td>
					<td><input type="text" name="userId" /> <input type="button"
						class="btn" value="check" /></td>
				</tr>

				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<tr>
					<td>PASSWORD CHECK</td>
					<td><input type="password" name="password2" /></td>
				</tr>

				<tr>
					<td>NAME</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td>NICKNAME</td>
					<td><input type="text" /></td>
				</tr>

				<tr>
					<td>GENDER</td>
					<td><input type="radio" name="gender" checked />Male <input
						type="radio" name="gender" />Female</td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="text" name="email"> <select
						class="btn">
							<option>Direct Input</option>
							<option>naver.com</option>
							<option>daum.net</option>
							<option>nate.com</option>
					</select></td>
				</tr>

				<tr>
					<td>LOCATION</td>
					<td><input type="text" /> <input type="button" class="btn"
						value="Search" /></td>
				</tr>
				<tr>
					<td>DETAIL LOCATION</td>
					<td><input type="text" /></td>
				</tr>

				<tr>
					<td>PHONE</td>
					<td><input type="radio" name="phone" /> SKT <input
						type="radio" name="phone" /> KT <input type="radio" name="phone" />
						LGU+ <br /> <!--<select class="btn">
        <option> 010 </option>
        <option> 011 </option>
        <option> 016 </option>
        <option> 018 </option>
       </select>
       <input type = "text" size = "6"/> - <input type = "text" size = "6"/>-->
						<input type="text" name="phone"></td>
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
					<td>
					      	<input type="submit" class="btn" value="check" onclick="selectChkBox()"/>
					</td>
				</tr>
			</table>
		</form>
		<br />
		<div class="btn2">
			<input type="submit" class="btn" value="Sign Up" />
			<input type="reset" class="btn" value="Reset" />
		</div>
	</div>
</body>
</html>
