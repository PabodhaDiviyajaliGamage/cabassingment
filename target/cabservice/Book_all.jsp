<%@ page import="java.util.List" %>
<%@ page import="com.cabservice.model.Admin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cabservice.model.Booking" %><%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/16/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>



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

      <h2>Hi! <%out.print(session.getAttribute("username"));%></></h2>

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
        <a href="register_Booking.jsp">
          <span class="icon icon-2"><i class="ri-calendar-2-line"></i></span>
          <span class="sidebar--item">Add Booking</span>
        </a>
      </li>
      <li>
        <a href="#">
          <span class="icon icon-3"><i class="ri-user-2-line"></i></span>
          <span class="sidebar--item" style="white-space: nowrap;">Vehicle Details</span>
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

        <input type="hidden" id="uname" name="uname" value="<%out.print(session.getAttribute("cname"));%>">

      </div>
      <div class="table">
        <table>
          <thead>
          <tr>

            <th>Customername</th>
            <th>Customer number</th>
            <th>To :</th>
            <th>From :</th>
            <th>Driver Name:</th>
            <th>Driver Number:</th>
            <th>Status:</th>
          </tr>
          </thead>
          <tbody>
          <%
            List<Booking>bookings=(ArrayList<Booking>)request.getAttribute("booking");
            for (Booking booking:bookings)
            {
              out.print("<tr>");
              out.print("<td>"+booking.getCusname()+"</td>");
              out.print("<td>"+booking.getCusmobile()+"</td>");
              out.print("<td>"+booking.getTo()+"</td>");
              out.print("<td>"+booking.getFrom()+"</td>");
              out.print("<td>"+booking.getDname()+"</td>");
              out.print("<td>"+booking.getDnumber()+"</td>");
              out.print("<td>"+booking.getStatus()+"</td>");
              out.print("<td>");
              out.print("<form action=\"bookingUpdate\" method=\"post\">");
              out.print("<input type=\"hidden\" name=\"id\" id=\"id\" value="+booking.getId()+">");
              out.print("<input type=\"hidden\" name=\"Dname\" id=\"Dname\" value="+session.getValue("Dname")+">");
              out.print("<input type=\"hidden\" name=\"Dnumber\" id=\"Dnumber\" value="+session.getValue("dnumber")+">");


              out.print("<button type=\"submit\">");
              out.print("Comform");
              out.print("</button>");
              out.print("</form>");
              out.print("</td>");
              out.print("</tr>");

            }
          %>
          </tbody>
          <input type="hidden" name="uname" id="uname1" value="<%session.getAttribute("Dname");%>">
        </table>
      </div>
    </div>
  </div>
</section>
<script src="assets/js/main.js"></script>
</body>

</html>