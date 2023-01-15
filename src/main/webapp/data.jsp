<%@ page import="models.Patient" %>
<%@ page import="models.GlucoseLevel" %>
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
    <link rel="stylesheet" href="../css/data.css">
    <script defer src="js/data.js"></script>
    <div>
        <canvas id="myChart"></canvas>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

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
    <canvas id="myGraph"style="width:100%;max-width:700px">
        <script>
            var xValues = [100,200,300,400,500,600,700,800,900,1000];

            new Chart("myGraph", {
                type: "line",
                data: {
                    labels: xValues,
                    datasets: [{
                        data: [860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
                        label: 'A',
                        yAxisID: 'A',
                        borderColor: "red",
                        fill: false
                    }, {
                        data: [3,7,20,50,60,40,20,10,2,1],
                        label: 'B',
                        yAxisID: 'B',
                        borderColor: "blue",
                        fill: false
                    }]
                },
                options: {
                    legend: {display: false}
                },
                options: {
                    scales: {
                        yAxes: [{
                            id: 'A',
                            type: 'linear',
                            position: 'left',
                        }, {
                            id: 'B',
                            type: 'linear',
                            position: 'right',
                            ticks: {
                                max: 100,
                                min: 0
                            }
                        }]
                    }
                }
            });
        </script>
    </canvas>
    <div id="comments-frame">
        <h2>Comments</h2>
        <div id="comments-list">
            <!-- Comments retrieved from the database will be displayed here -->
        </div>
    </div>
    <form action="/patient/thresholds">
        <input name="id" value="<%=patient.getId()%>" type="hidden"/>
        <button class="edit-thresh">
            <span class="text19"><span>Edit threshold</span></span>
        </button>
    </form>
</body>