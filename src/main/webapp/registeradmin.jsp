<html>
<body>
<%out.print(request.getAttribute("message"));%>
<a href="loginadmin.jsp">Login Admin page</a>
<form action="SendData" method="post">
    <label>Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label>password:</label><br>
    <input type="password" id="pass" name="pass"><br>
    <label>name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label>email:</label><br>
    <input type="email" id="email" name="email"><br>
    <button type="submit">Register</button>
</form>
</body>
