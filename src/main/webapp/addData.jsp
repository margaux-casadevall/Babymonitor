<%@ page import="models.Patient" %>
<%
    Patient patient = (Patient)request.getAttribute("patient");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="../css/addData.css">
  <style>
    button{
      border: none;
      cursor: pointer;
      appearance: none;
      background-color: inherit;
      margin-left:10px;
      margin-top:20px;
    }
    button:hover {
        box-shadow: 0px 0px 5px 2px black;
    }

    img{
      width: 70px;
      height: 70px;
    }
  </style>
</head>

<body>
  <div>
    <div class="footer">
        <img
            alt="Logo"
            src="../images/logo.png"
        />
        <h1>Premature</h1>
        <br />
        <h2>Baby Monitor</h2>
    </div>
    <div class="header">
        <form action="/logout">
            <button type="submit">
                <img src="../images/exit.png" alt="LogOut"/>
              </button>
          </form>
    <span class="text05">
        <span>Patient ID: <%=patient.getId()%></span>
    </span>
    <span class="text07">
        <span>St Mary&apos;s</span>
    </span>
    <form action="/">
        <button type="submit" class="home-btn">
            <img src="../images/house.jpg" alt="Home"/>
        </button>
    </form>
    </div>
    <main id="main-holder-1">
        <div class="glucose">
            <form id="glucose-form" action="/" method="post">
                <input type="text" name="Glucose level" id="glucose-field" class="glucose-form-field" placeholder="Glucose level">
            </form>
            <span class="text11"><span>mmol</span></span>
        </div>

        <div class="time">
            <form id="time-form" action="/" method="post">
                <input type="text" name="Time" id="time-field" class="time-form-field" placeholder="Time">
            </form>
        </div>

        <button class="save">
            <span class="text17"><span>Save</span></span>
        </button>
        <span class="text21"><span>NEW MEASUREMENT</span></span>
    </main>

    <main id="main-holder-2">
        <div class="comment-time">
            <form id="time2-form" action="/" method="post">
                <input type="text" name="Default time" id="time2-field" class="time-form-field" placeholder="Default time">
            </form>
        </div>

        <div class="comment">
            <form id="comment-form" action="/" method="post">
                <input type="text" name="Comment" id="comment-field" class="comment-form-field" placeholder="Comment">
            </form>
        </div>

        <button class="savecomment">
            <span class="text27"><span>Save</span></span>
        </button>
        <span class="text31"><span>NEW COMMENT</span></span>
    </main>
</body>