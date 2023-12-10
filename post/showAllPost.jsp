<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <title>Hobbyists</title>
</head>
<body>
    <header>
        <div>
            <img id="logo" src="../img/logo.png">
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
            <li><a href="./showBestPost.jsp">Best</a></li>
            <li><a href="#">Hobbyists</a></li>
            <li><a href="../user/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>
    <main>
        <div id="posts">
            <div id="post">
                <div id="pName">
                    작성자: <span><!-- 작성자 이름 받아오기 --></span>
                </div>
                <div id="pDate">
                    작성일: <span><!-- 작성일 받아오기 --></span>
                </div>
            </div>
            <p>
                ...작성내용... <!-- 작성 내용 받아오기 -->
            </p>
            <div id="heart">
                <i class="fa-regular fa-heart"></i>
                <!-- <i class="fa-solid fa-heart"></i> -->
            </div>
            
        </div>
    </main>
</body>
<script>
    document.getElementsByTagName("i").addEventListener("click", heart)
    const heart = (e) => {
        if (e.target.className == "fa-regular fa-heart") {
            e.target.classList.toggle("fa-solid fa-heart");
        } else {
            e.target.classList.toggle("fa-regular fa-heart");
        }
        
    }
</script>
</html>
