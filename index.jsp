<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <title>Hobbyists</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <header>
        <div>
            <a href="#"><img id="logo" src="./img/logo.png"></a>
        </div>
        <div id="sign">
            <a href="./user/loginForm.jsp">Sign In</a>
            <div></div>
            <a href="./user/registerForm.jsp">Sign Up</a>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="./category/category_list.jsp">Category</a></li>
            <li><a href="./post/showBestPost.jsp">Best</a></li>
            <li><a href="./post/showAllPost.jsp">Hobbyists</a></li>
            <li><a href="./myPage/myPage.jsp">Mypage</a></li>
        </ul>
    </nav>
    <main>
        <div id="welcome">
            <div>Welcome to <span>Hobbyists</span></div>
            <div>Join Our Hobby Share Site</div>
        </div>
        <div id="carouselExampleIndicators" class="carousel slide">
		    <div class="carousel-indicators">
		      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
		      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
		    </div>
		    <div class="carousel-inner">
		      <div class="carousel-item active">
		        <img src="./img/pic1.jpg" class="d-block w-100" alt="...">
		      </div>
		      <div class="carousel-item">
		        <img src="./img/pic2.jpg" class="d-block w-100" alt="...">
		      </div>
		      <div class="carousel-item">
		        <img src="./img/pic3.jpg" class="d-block w-100" alt="...">
		      </div>
		    </div>
		    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
		      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		      <span class="visually-hidden">Previous</span>
		    </button>
		    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
		      <span class="carousel-control-next-icon" aria-hidden="true"></span>
		      <span class="visually-hidden">Next</span>
		    </button>
		</div>
    </main>
</body>
</html>
