<%@ page import="com.cabservice.model.Admin" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cabservice.model.Driver" %><%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/16/2022
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(session.getAttribute("username")==null)
{
    response.sendRedirect("loginDriverjsp");
}%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <title>Dashboard</title>
</head>

<body>
<section class="header">
    <div class="logo">
        <i class="ri-menu-line icon icon-0 menu"></i>
        <h2>Go<span>Cheata</span></h2>
    </div>
    <div class="search--notification--profile">
        <div class="search">
            <input type="text" placeholder="Search Scdule..">
            <button><i class="ri-search-2-line"></i></button>
        </div>
        <div class="notification--profile">

                <h2><%out.print(session.getAttribute("username"));%></h2>

        </div>
    </div>
</section>
<section class="main">
    <div class="sidebar">
        <ul class="sidebar--items">
            <li>
                <a href="#" id="active--link">
                    <span class="icon icon-1"><i class="ri-layout-grid-line"></i></span>
                    <span class="sidebar--item">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="/cabservice_war_exploded/vehicleDash?action=all" id="">
                    <span class="icon icon-2"><i class="ri-calendar-2-line"></i> </span>
                    <span class="sidebar--item">Vehicle Details</span>
                </a>
            </li>
            <li>
                <a href="/cabservice_war_exploded/Servlet_BookingAll?action=all">
                    <span class="icon icon-3"><i class="ri-user-2-line"></i></span>
                    <span class="sidebar--item" style="white-space: nowrap;">All Customer Bookings</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span class="icon icon-4"><i class="ri-user-line"></i></span>
                    <span class="sidebar--item">Order Details</span>
                </a>
            </li>

        </ul>
        <ul class="sidebar--bottom-items">

            <li>
                <a href="#">
                    <span class="icon icon-8"><i class="ri-logout-box-r-line"></i></span>
                    <span class="sidebar--item">Logout</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="main--content">
        <div class="overview">
            <div class="title">
                <h2 class="section--title">Overview</h2>

            </div>
            <div class="cards">
                <div class="card card-1">
                    <div class="card--data">
                        <div class="card--content">
                            <h5 class="card--title">Total Doctors</h5>
                            <h1>152</h1>
                        </div>
                        <i class="ri-user-2-line card--icon--lg"></i>
                    </div>
                    <div class="card--stats">
                        <span><i class="ri-bar-chart-fill card--icon stat--icon"></i>65%</span>
                        <span><i class="ri-arrow-up-s-fill card--icon up--arrow"></i>10</span>
                        <span><i class="ri-arrow-down-s-fill card--icon down--arrow"></i>2</span>
                    </div>
                </div>



            </div>
        </div>

        <div class="recent--patients">
            <div class="title">
                <h2 class="section--title">Recent Patients</h2>
                <button class="add"><i class="ri-add-line"></i><a href="registeradmin.jsp">Add</a></button>
            </div>
            <div class="table">
                <table>
                    <thead>
                    <tr>

                        <th>username</th>
                        <th>password</th>
                        <th>name</th>
                        <th>phone number</th>
                        <th>License</th>
                        <th>Address</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Driver> driverList=(ArrayList<Driver>)request.getAttribute("driverList");
                        for (Driver driver:driverList)
                        {
                            out.print("<tr>");
                            out.print("<td>"+driver.getUsername()+"</td>");
                            out.print("<td>"+driver.getPassword()+"</td>");
                            out.print("<td>"+driver.getName()+"</td>");
                            out.print("<td>"+driver.getPhonenumber()+"</td>");
                            out.print("<td>"+driver.getLisence()+"</td>");
                            out.print("<td>"+driver.getAddress()+"</td>");

                            out.print("<td>");
                            out.print("<form action=\"DriverView\" method=\"get\">");
                            out.print("<input type=\"hidden\" name=\"deteusername\" id=\"dtusername\" value="+driver.getUsername()+">");
                            out.print(" <input type=\"hidden\" name=\"action\" value=\"single\">");
                            out.print("<button type=\"submit\">");
                            out.print("<i class=\"ri-edit-line edit\"></i>");
                            out.print("</button>");
                            out.print("</form>");
                            out.print("</td>");


                            out.print("<td>");
                            out.print("<form action=\"DriverDelete\" method=\"post\">");
                            out.print("<input type=\"hidden\" name=\"deteusername\" id=\"dtusername\" value="+driver.getUsername()+">");
                            out.print("<button type=\"submit\">");
                            out.print("<i class=\"ri-delete-bin-line delete\"></i>");
                            out.print("</button>");
                            out.print("</form>");
                            out.print("</td>");


                            out.print("</tr>");

                        }
                    %>




                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<script src="assets/js/main.js"></script>
</body>

</html>
