<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="assets/css/style1.css">
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
    <form action="ViewData" method="get">
      <div class="search">

        <input type="text" placeholder="Search Scdule.." name="uname" id="uname">
        <input type="hidden" name="action" value="single">
        <button type="submit"><i class="ri-search-2-line"></i></button>

      </div> </form>

    <div class="notification--profile">
      <div class="picon profile">
        <img src="assets/images/profile.jpg" alt="">
      </div>
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
        <a href="#">
          <span class="icon icon-2"><i class="ri-calendar-2-line"></i></span>
          <span class="sidebar--item">Driver Details</span>
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
    </div>

    <form method="post" action="DriverUpdate" class="register-form"
          id="register-form">
      <div class="form-group">
        <label for="uname"><i
                class="zmdi zmdi-account material-icons-name"></i></label> <input
              type="text" name="username" id="username" placeholder="Your Name" value="<%out.print(request.getAttribute("username"));%>" readonly />
      </div>
      <div class="form-group">
        <label for="pass"><i class="zmdi zmdi-email"></i></label> <input
              type="text" name="pass" id="pass" placeholder="Your Email" value="<%out.print(request.getAttribute("password"));%>"/>
      </div>
      <div class="form-group">
        <label for="name"><i class="zmdi zmdi-lock"></i></label> <input
              type="text" name="name" id="name" placeholder="Password" value="<%out.print(request.getAttribute("name"));%>"/>
      </div>

      <div class="form-group">
        <label for="phone"><i class="zmdi zmdi-lock-outline"></i></label>
        <input type="number" name="phone" id="phone"
               placeholder="Contact no"  value="<%out.print(request.getAttribute("pnum"));%>"/>
      </div>

      <div class="form-group">
        <label for="phone"><i class="zmdi zmdi-lock-outline"></i></label>
        <input type="text" name="lisence" id="lisence"
               placeholder="Contact no"  value="<%out.print(request.getAttribute("lsence"));%>"/>
      </div>

      <div class="form-group">
        <label for="phone"><i class="zmdi zmdi-lock-outline"></i></label>
        <input type="text" name="address" id="address"
               placeholder="Contact no"  value="<%out.print(request.getAttribute("address"));%>"/>
      </div>
        <br>
        <br>
        <div class="form-group">
          <label for="image"><i class="zmdi zmdi-lock-outline"></i></label>
          <input type="file" name="image" id="image"
                 placeholder="Contact no" />

        </div>


        <div class="form-group form-button">

          <button type="submit" class="form-submit">Update</button>
        </div>

    </form>


  </div>
</section>
<script src="assets/js/main.js"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="assets/js/main1.js"></script>
</body>

</html>
