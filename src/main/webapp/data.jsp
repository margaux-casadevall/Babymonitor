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
      <span><%=patient.getHospital()%></span>
  </span>
        <form action="/">
            <button type="submit" class="home-btn">
                <img src="../images/house.jpg" alt="Home"/>
            </button>
        </form>
    </div>
    <canvas id="myGraph" style="width: 35%; height: auto;">
        <script>
           /* new Chart("MyGraph", {
                type: 'line',
                data: {
                    labels: ['00:00', '00:10', '00:20', '00:30', '00:40', '00:50', '01:00', '01:10', '01:20', '01:30'],
                    datasets: [{
                        label: 'Concentration',
                        data: [12, 19, 3, 5, 2, 3, 20, 15, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100],
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        xAxes: [{
                            type: 'time',
                            time: {
                                unit: 'minute',
                                unitStepSize: 15,
                                min: '00:00',
                                max: '24:00',
                                displayFormats: {
                                    'minute': 'HH:mm'
                                }
                            },
                            gridLines: {
                                display: false
                            }
                        }],
                        yAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Concentration'
                            },
                            ticks: {
                                min: 0,
                                max: 100,
                                stepSize: 10
                            }
                        }]
                    }
                }
            });*/
            new Chart("myGraph", {
                type: "line",
                data: {
                    datasets: [
                        {
                        data: [14.5, 14.5, 14.5, 14.5, 14.5,14.5,14.5,14.5,14.5,14.5],
                        label: 'Upper threshold',
                        yAxisID: 'B',
                        borderColor: "red",
                        fill: false
                    }, /*{
                        data: [3,7,20,50,60,40,20,10,2,1],
                        label: 'Lower threshold',
                        yAxisID: 'A',
                        borderColor: "red",
                        fill: false
                        }*/
                        {
                        data: [860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
                        label: 'A',
                        yAxisID: 'A',
                        borderColor: "green",
                        fill: false
                    }, {
                        data: [3,7,20,50,60,40,20,10,2,1],
                        label: 'B',
                        yAxisID: 'B',
                        borderColor: "orange",
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
                        }],
                        xAxes: [{
                            type: 'time',
                            time: {
                                unit: 'minute',
                                unitStepSize: 15,
                                min: '00:00',
                                max: '24:00',
                                displayFormats: {
                                    'minute': 'HH:mm'
                                }
                            },
                            gridLines: {
                                display: false
                            }
                        }],

                    }
                }
            });
        </script>
    </canvas>
    <div id="comments-frame">
        <h2>Comments</h2>
        <div id="comments-list">
            <%=patient.getComments()%>
        </div>
    </div>
    <form action="/patient/thresholds">
        <input name="id" value="<%=patient.getId()%>" type="hidden"/>
        <button class="edit-thresh">
            <span class="text19"><span>Edit threshold</span></span>
        </button>
    </form>
</body>