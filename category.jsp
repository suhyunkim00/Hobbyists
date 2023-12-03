<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, java.util.ArrayList, java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <title>category</title>
</head>
<body>
    <header>
        <div>
            <img id="logo" src="./img/logo.png">
        </div>
        <div id="sign">
            <a href="./signIn.jsp">Sign In</a>
            <div></div>
            <a href="./signUp.jsp">Sign Up</a>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="./category.jsp">Category</a></li>
            <li><a href="./best.jsp">Best</a></li>
            <li><a href="./hobbyists.jsp">Hobbyists</a></li>
            <li><a href="./myPage.jsp">Mypage</a></li>
        </ul>
    </nav>
<main>
        <p id="categoryList"></p>

        <%-- DAO에서 가져옴(지금은 예시로 코드 안에서 카테고리를 추가해서 return) --%>
        <%
            List<Map<String, String>> categories = new ArrayList<Map<String, String>>();
            categories.add(Map.of("name", "category1"));
            categories.add(Map.of("name", "category2"));
            categories.add(Map.of("name", "category3"));
            categories.add(Map.of("name", "category4"));
        %>
        
        <%-- 카테고리 출력 --%>
        <%
            for (Map<String, String> category : categories) {
                String categoryName = category.get("name");
        %>
                <a href="<%= "category_detail.jsp?" + categoryName %>"><%= categoryName %></a><br>
        <%
            }
        %>

        <%-- 페이지 로드출력 함수 호출 --%>
        <script>
            window.onload = function()
        </script>
    </main>
</body>
</html>
