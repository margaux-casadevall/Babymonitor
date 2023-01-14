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
        <form action="index.html">
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
            <span class="text09">
            <span>Glucose level</span>
            </span>
            <span class="text11"><span>mmol</span></span>
        </div>
        <div class="time">
            <span class="text13">
            <span>Default time</span>
            </span>
        </div>
        <button class="save">
            <span class="text17"><span>Save</span></span>
        </button>
        <span class="text21"><span>NEW MEASUREMENT</span></span>
    </main>
    <main id="main-holder-2">
        <div class="comment-time">
            <span class="text29">
            <span>Default time</span>
            </span>
        </div>
        <div class="comment">
            <span class="text23">
            <span>Comment</span>
            </span>
        </div>
        <button class="savecomment">
            <span class="text27"><span>Save</span></span>
        </button>
        <span class="text31"><span>NEW COMMENT</span></span>
    </main>
</body>