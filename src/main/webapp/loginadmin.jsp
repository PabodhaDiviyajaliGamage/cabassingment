<%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/16/2022
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Go cheata Login</title>
</head>
<body>
<%out.print(request.getAttribute("message"));%>
<form action="AdminLogin" method="post"><table>
    <tr> <td><label>UserName :</label></td>
        <td><input type="text" id="uname" name="uname"></td></tr>

    <tr> <td><label>password :</label></td>
    <td><input type="text" id="pass" name="pass"></td></tr>

</table>
<button type="submit">Login</button>
</form>

</body>
</html>
