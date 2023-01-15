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
        <span><%=patient.getHospital()%></span>
    </span>
    <form action="/">
        <button type="submit" class="home-btn">
            <img src="../images/house.jpg" alt="Home"/>
        </button>
    </form>
    </div>
    <main id="main-holder-1">
        <span class="text21"><span>NEW MEASUREMENT AND COMMENT</span></span>


        <form id="form" action="/patient/add?id=<%=patient.getId()%>" method="post">
            <input name="measurement" id="username-field" class="measurement-form-field" placeholder="Measurement (mmol)">
            <input name="comment" id="comment-field" class="comment-form-field" placeholder="Comment">
            <input type="time" name="time" class="measurement-form-field" style="top: 80%" required>       
            <button class="save" type="submit">
                <span class="text17"><span>Save</span></span>
            </button> 
        </form>
        <span class="text11"><span>mmol</span></span>
    </main>
</body>