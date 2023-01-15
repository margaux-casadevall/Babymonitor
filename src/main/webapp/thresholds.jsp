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
  <link rel="stylesheet" href="../css/thresholds.css">
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
        <span class="text21"><span>THRESHOLD LIMITS</span></span>
        <form id="form" action="/patient/thresholds?id=<%=patient.getId()%>" method="post">
            <div class="upper">
                <input type="text" value="<%=patient.getUpperThreshold()%>" name="upper" id="upper-field" class="upper-form-field" placeholder="Upper threshold (14)">
                <input type="text" value="<%=patient.getLowerThreshold()%>" name="lower" id="lower-field" class="lower-form-field" placeholder="Lower threshold (4.5)">
                <span class="text11"><span>mmol</span></span>
            </div>

            <button class="savebutton" type="submit">
                <span class="text17"><span>Save changes</span></span>
            </button>
    </form>
    </main>
</body>



