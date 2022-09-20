<%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/18/2022
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(session.getAttribute("username")==null)
{
  response.sendRedirect("cutomerLogin.jsp");
}%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Sign Up Form by Colorlib</title>

  <!-- Font Icon -->
  <link rel="stylesheet"
        href="assets/fonts/material-icon/css/material-design-iconic-font.min.css">

  <!-- Main css -->
  <link rel="stylesheet" href="assets/css/style1.css">
</head>
<body>

<div class="main">

  <!-- Sign up form -->
  <section class="signup">
    <div class="container">
      <div class="signup-content">
        <div class="signup-form">
          <h2 class="form-title">New Booking</h2>

          <form method="post" action="bookingRegister" class="register-form"
                id="register-form">
            <div class="form-group">
              <label for="cnmber"></label> <input
                    type="text" name="cnmber" id="cnmber" placeholder="Customer Number" value="<%out.print(session.getAttribute("cnum"));%>"/>
            </div>
            <div class="form-group">
              <label for="cname"></label> <input
                    type="text" name="cname" id="cname" placeholder="Customer Name:"value="<%out.print(session.getAttribute("cname"));%>" />
            </div>
            <div class="form-group">
              <label for="to"></label> <input
                    type="text" name="to" id="to" placeholder="To :" />
            </div>
            <div class="form-group">
              <label for="from"></label> <input
                    type="text" name="from" id="from" placeholder="From :" />
            </div>



            <div class="form-group form-button">
              <button type="submit" class="form-submit" >Register</button>
            </div>

          </form>
        </div>
        <div class="signup-image">
          <figure>

          </figure>

        </div>
      </div>
    </div>
  </section>


</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="assets/js/main1.js"></script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>