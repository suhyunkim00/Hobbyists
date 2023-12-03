<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/loginForm.css" />
    <title>Form Input Wave</title>
    <script>
        function login() {
            if (form.userId.value == "") {
                alert("Enter a user ID.");
                form.userId.focus();
                return false;
            } 
            if (form.password.value == "") {
                alert("Enter a Password.");
                form.password.focus();
                return false;
            }		
            form.submit();
        }
        
        function userCreate(targetUri) {
            form.action = targetUri;
            form.submit();
        } //
    </script>
  </head>
  <body>
    <div class="container">
      <h1>Please Login</h1>
      <form name="form" method="POST" action="<c:url value='/main' />">
        <div class="form-control">
          <input type="text" placeholder="Email" required />
          <!-- <label>
            <span style="transition-delay: 0ms">E</span>
              <span style="transition-delay: 50ms">m</span>
              <span style="transition-delay: 100ms">a</span>
              <span style="transition-delay: 150ms">i</span>
              <span style="transition-delay: 200ms">l</span>
        </label> -->
        </div>

        <div class="form-control">
          <input type="password" placeholder="Password" required />
        </div>

        <button class="btn">Login</button>

        <p class="text">Don't have an account? <a href="registerForm.jsp">Register</a></p>
      </form>
    </div>
  </body>
</html>

