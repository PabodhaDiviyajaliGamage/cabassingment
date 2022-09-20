<%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/16/2022
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(session.getAttribute("username")==null)
{
  response.sendRedirect("loginadmin.jsp");
}%>
<html>
<head>
    <title>Admin Driver List</title>
</head>
<body>
<%out.print(session.getAttribute("username"));%>
</body>
</html>
