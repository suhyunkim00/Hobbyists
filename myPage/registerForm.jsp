<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="/css/registerForm.css">
  <title>Form Validator</title>
</head>
<body>
    <div class="container">
    <h1>Register With Us</h1>
    <table boder = "" cellspacing = "1" >
    <FORM>
     <tr>
      <td text-align="center">ID</td>
      <td>
      <input type = "text" />
      <input type = "button" class="btn" value = "check"/>
      </td>
     </tr>
   
     <tr>
      <td> PASSWORD </td>
      <td><input type = "password"/></td>
     </tr>
   
     <tr>
      <td> PASSWORD CHECK </td>
      <td> <input type = "password"/></td>
     </tr>
   
     <tr>
      <td> NAME </td>
      <td><input type = "text"/></td>
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
    </FORM>
   </table>
   <br/>
   <div class="btn2">
   <input type = "submit" class="btn" value = "Sign Up"/>
   <input type = "reset" class="btn" value = "Reset"/>
   </div>
   </div>
   </body>
</html>
