<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <title>Write</title>
    <style>
    	.btn {
    		cursor: pointer;
    		display: inline-block;
  			background: #DFA4A4;
  			color: #fff;
  			padding: 5px;
  			font-family: inherit;
  			font-size: 13px;
  			border: 0;
  			border-radius: 3px;
		}

		.btn:focus {
  			outline: 0;
		}

		.btn:active {
  			transform: scale(0.98);
		}
    </style>
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
            <li><a href="../category/category_list.jsp">Category</a></li>
            <li><a href="#">Best</a></li>
            <li><a href="showAllPost.jsp">Hobbyists</a></li>
            <li><a href="../myPage/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>

    <div class= "container">
    	<div class= "row">
    		<form method="post" action="writeAction.jsp">
    			<table class= "table table-stripped" style= "text-align: center; boarder: 1px solid #dddddd">
	    	    	<thead>
		    	    	<tr>
		    	    		<th colspan= "2" style= "background-color: #F9E7E3; text-align: center;">게시판 글쓰기 양식</th>
		    	    	</tr>
	    	    	</thead>
			    	<tbody>
			    		<tr>
			    			<td><input type="text" class="form-control" placeholder="글 제목"  name="bbsTitle" maxlength="50" ></td>
			    		</tr>
			    		<tr>
			    			<td><textarea class="form-control" placeholder="글 내용"  name="bbsContent" maxlength="2048" style= "height:350px" ></textarea></td>
			    		</tr>
			    	</tbody>
    	    	</table>
    	    	<input type="submit" class="btn" style="background-color: #E9C5C5;" value="글쓰기">
    		</form>
    	    </div>
    </div>
</body>
</html>

