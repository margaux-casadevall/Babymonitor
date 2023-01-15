<%@ page import="models.Patient" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="css/patients.css">
  <script defer src="js/patients.js"></script>
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
    <div class="footer">
        <img
            alt="Logo"
            src="images/logo.png"
        />
        <h1>Premature</h1>
        <br />
        <h2>Baby Monitor</h2>
    </div>
    <div class="header">
        <form action="/logout">
            <button type="submit">
                <img src="/images/exit.png" alt="LogOut"/>
            </button>
        </form>
        <span class="text05">
            <span>Patient Directory</span>
        </span>
    </div>
    <main id="main-holder">
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for ID">
        <table id ="myTable">
            <tr class ="header-table">
              <th>Patient ID</th>
              <th>Hospital</th>
              <th>Date Admitted</th>
              <th> Doctor in charge</th>
            </tr>
            <%
              for(Patient patient : (List<Patient>)request.getAttribute("patients")) {
            %>
            <tr>
              <td><a href="/patient?id=<%=patient.getId()%>"><%=patient.getId()%></a></td>
              <td><%=patient.getHospital()%></td>
              <td><%=patient.getDateAdmitted()%></td>
              <td><%=patient.getDoctor()%></td>
            </tr>
          <%
            }
          %>
          </table>
    </main>
</body>