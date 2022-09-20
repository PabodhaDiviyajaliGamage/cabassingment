

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

          <form method="post" action="VehicleRegistation" class="register-form"
                id="register-form">


            <div class="form-group">
              <label for="number"></label> <input
                    type="text" name="number" id="number" placeholder="Vehicle Number" />
            </div>
            <div class="form-group">
              <label for="model"></label> <input
                    type="text" name="model" id="model" placeholder="Vehicle Mode" />
            </div>
            <div class="form-group">
              <label for="fueltype"></label> <input
                    type="text" name="fueltype" id="fueltype" placeholder="Vehicle Fuel type" />
            </div>
            <div class="form-group">
              <label for="lisence"></label>
              <input type="text" name="lisence" id="lisence"
                     placeholder="Driving license" />
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