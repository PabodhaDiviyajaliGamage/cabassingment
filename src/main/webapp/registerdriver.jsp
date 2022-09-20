<%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/16/2022
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Driver</title>
</head>
<body>
<a href="">Login Admin page</a>
<form action="DriverRegister" method="post">
  <label>Username:</label><br>
  <input type="text" id="username" name="username"><br>
  <label>password:</label><br>
  <input type="password" id="pass" name="pass"><br>
  <label>name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label>phone number:</label><br>
  <input type="number" id="pnumber" name="pnumber"><br>
  <label>address:</label><br>
  <input type="text" id="address" name="address"><br>
  <label>license:</label><br>
  <input type="text" id="license" name="license"><br>

  <label>Image:</label><br>
  <input type="file" id="image" name="image"><br>
 <br> <button type="submit">Register</button>
</form>
</body>
</html>
