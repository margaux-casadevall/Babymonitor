<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="js/login.js"></script>
</head>

<body>
<main id="main-holder">
    <img
            alt="Logo"
            src="images/logo.png"
    />
    <span class="text21"><span>Premature</span></span>
    <br/>
    <span class="text22"><span>Baby Monitor</span></span>
    <form id="login-form" action="/login" method="post">
        <input type="text" name="username" id="username-field" class="login-form-field" placeholder="Username">
        <input type="password" name="password" id="password-field" class="login-form-field" placeholder="Password">
        <input type="submit" value="Login" id="login-form-submit">
    </form>
     <%
      if (request.getAttribute("errorMessage") != null) {
     %>
        <div id="login-error-msg-holder">
            <p id="login-error-msg"><%=request.getAttribute("errorMessage")%></p>
        </div>
     <%
      }
     %>
</main>
</body>