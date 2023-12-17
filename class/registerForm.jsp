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
<title>Class Register</title>
<script>
	function check() {
		if(form.title.value == ""){
			alert("Title을 입력하세요.");
			form.title.focus();
			return false;
		}
		if(form.content.value == ""){
			alert("Content를 입력하세요.");
			form.content.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h1>Register Class</h1>
		<form id="frm" method="post" name="form">
			<table boder="" cellspacing="1">
				<tr>
					<td text-align="center">Title</td>
					<td><input type="text" name="title" required/></td>
				</tr>

				<tr>
					<td>Upload Photo</td>
					<td><input type="file" accept="image/*" name="image"/></td>
				</tr>

				<tr>
					<td>Contents</td>
					<td><textarea name="content"></textarea></td>
				</tr>
			</table>

			<br />
			<div class="btn2">
				<input type="button" class="btn" value="Register" onclick="check()" />
				<input type="reset" class="btn" value="Reset" />
			</div>
		</form>
	</div>
</body>
</html>
