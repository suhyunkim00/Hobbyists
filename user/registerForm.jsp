
<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="/css/registerForm.css">
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
        if(emailExp.test(form.email.value)==false) {
            alert("이메일 형식이 올바르지 않습니다.");
            form.email.focus();
            return false;
        }
        var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
        if(phoneExp.test(form.phone.value)==false) {
            alert("전화번호 형식이 올바르지 않습니다.");
            form.phone.focus();
            return false;
        }
        form.submit();
    }
    
    function userList(targetUri) {
        form.action = targetUri;
        form.submit();
    }
</script>
</head>
<body>
    <div class="container">
    <h1>Register With Us</h1>
    <table boder = "" cellspacing = "1" >
    <form>
     <tr>
      <td text-align="center">ID</td>
      <td>
      <input type = "text" name="userId"/>
      <input type = "button" class="btn" value = "check"/>
      </td>
     </tr>
   
     <tr>
      <td> PASSWORD </td>
      <td><input type = "password" name="password"/></td>
     </tr>
   
     <tr>
      <td> PASSWORD CHECK </td>
      <td> <input type = "password" name="password2"/></td>
     </tr>
   
     <tr>
      <td> NAME </td>
      <td><input type = "text" name="name"/></td>
     </tr>

     <tr>
        <td> NICKNAME </td>
        <td><input type = "text"/></td>
       </tr>
   
     <tr>
      <td> GENDER </td>
      <td>
       <input type = "radio" name = "gender" checked/>Male
       <input type = "radio" name = "gender"/>Female
      </td>
     </tr>   
   
     <tr>
      <td> Email </td>
      <td>
       <input type = "text"/> @ <input type = "text"/> &nbsp;&nbsp;
       <select class="btn">
        <option> Direct Input </option>
        <option> naver.com </option>
        <option> daum.net </option>
        <option> nate.com </option>
       </select>
      </td>
     </tr>
   
     <tr>
      <td> LOCATION </td>
      <td>
       <input type = "text"/>
       <input type = "button" class="btn" value = "Search"/>
      </td>
     </tr>
     <tr>
      <td> DETAIL LOCATION </td>
      <td>
       <input type = "text"/>
      </td>
     </tr>
   
     <tr>
      <td> PHONE </td>
      <td>
       <input type = "radio" name = "phone"/> SKT
       <input type = "radio" name = "phone"/> KT
       <input type = "radio" name = "phone"/> LGU+
      <br/>
       <select class="btn">
        <option> 010 </option>
        <option> 011 </option>
        <option> 016 </option>
        <option> 018 </option>
       </select>
       <input type = "text" size = "6"/> - <input type = "text" size = "6"/>
      </td>
     </tr>

     <tr>
      <td> BIRTH </td>
      <td>
        <div>
            <input type="number" placeholder="Year(- - - -)">                
            <select>
                <option value="">Month</option>
                <option value="">Jan</option>
                <option value="">Feb</option>
                <option value="">Mar</option>
                <option value="">Apr</option>
                <option value="">May</option>
                <option value="">June</option>
                <option value="">July</option>
                <option value="">Aug</option>
                <option value="">Sept</option>
                <option value="">Oct</option>
                <option value="">Nov</option>
                <option value="">Dec</option>
            </select>
            <input type="number" placeholder="Day">
        </div>
      </td>
     </tr>
   
     <tr>
      <td> INTEREST </td>
      <td>
       <input type = "text"/>
       <input type = "text"/>
       <input type = "text"/>
      </td>
     </tr>
    </form>
   </table>
   <br/>
   <div class="btn2">
   <input type = "submit" class="btn" value = "Sign Up"/>
   <input type = "reset" class="btn" value = "Reset"/>
   </div>
   </div>
   </body>
</html>
