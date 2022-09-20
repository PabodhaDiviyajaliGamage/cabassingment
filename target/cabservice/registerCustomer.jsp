<%--
  Created by IntelliJ IDEA.
  User: sakil
  Date: 9/18/2022
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
                    <h2 class="form-title">Sign up</h2>

                    <form method="post" action="customer" class="register-form"
                          id="register-form">
                        <div class="form-group">
                            <label for="name"></label> <input
                                type="text" name="name" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="pnber"></label> <input
                                type="number" name="pnber" id="pnber" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <label for="pnber"></label> <input
                                type="text" name="username" id="username" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <label for="pass"></label> <input
                                type="password" name="pass" id="pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="address"></label>
                            <input type="text" name="address" id="address"
                                   placeholder="Repeat your password" />
                        </div>


                        <div class="form-group form-button">

                            <button type="submit" class="form-submit" >Register</button>
                        </div>

                    </form>
                </div>
                <div class="signup-image">
                    <figure>
                        <img src="images/signup-image.jpg" alt="sing up image">
                    </figure>
                    <a href="login.jsp" class="signup-image-link">I am already
                        member</a>
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