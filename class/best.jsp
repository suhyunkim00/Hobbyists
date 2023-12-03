<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <title>Best</title>
</head>
<body>
    <header>
        <div>
            <a href="../main.jsp"><img id="logo" src="../img/logo.png"></a>
        </div>
        <div id="sign">
            <a href="../user/loginForm.jsp">Sign In</a>
            <div></div>
            <a href="../user/registerForm.jsp">Sign Up</a>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="../category.jsp">Category</a></li>
            <li><a href="#">Best</a></li>
            <li><a href="./hobbyists.html">Hobbyists</a></li>
            <li><a href="../myPage/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>

    <div id="best">
        <h1>Monthly Best Hobbyists</h1>
        
    </div>
    <!--클릭 시 리스트 갱신-->
    <div id="refresh">
        <button id="ref">Refresh</button>
    </div>
</body>
</html>

