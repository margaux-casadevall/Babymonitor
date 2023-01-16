<%@ page import="models.Patient" %>
<%@ page import="models.GlucoseLevel" %>
<%@ page import="models.Comment" %>
<%@ page import="models.User" %>
<%@ page import="org.json.JSONObject" %>
<%
    Patient patient = (Patient)request.getAttribute("patient");
    User user = (User)request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/data.css">
    <script defer src="../js/data.js"></script>
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

    <canvas id="myGraph" style="width: 25%; height: auto;">
        <script>
            let glucoseLevels = <%=JSONObject.valueToString(patient.getGlucoseLevels())%>
                let glucoseLevelsHP = <%=JSONObject.valueToString(patient.getGlucoseLevelsHP())%>
                let comments = <%=JSONObject.valueToString(patient.getComments())%>
                let upperThreshold = <%=patient.getUpperThreshold()%>
                let lowerThreshold = <%=patient.getLowerThreshold()%>
            var thresholdHighArray = new Array(glucoseLevels.length).fill(upperThreshold);
            var thresholdLowArray = new Array(glucoseLevels.length).fill(lowerThreshold);
            var thresholdHighArrayHP = new Array(glucoseLevelsHP.length).fill(upperThreshold);
            var thresholdLowArrayHP = new Array(glucoseLevelsHP.length).fill(lowerThreshold);

            const dataCopy = glucoseLevels.map(item => {
                const date = new Date(item.timestamp);
                const totalMinutes = date.getHours() * 60 + date.getMinutes();
                return {...item, totalMinutes};
            });
            console.log(dataCopy);
            const sortedData = dataCopy.sort((a, b) => new Date(a.timestamp) - new Date(b.timestamp));

            const dataCopyHP = glucoseLevelsHP.map(item => {
                const date = new Date(item.timestamp);
                const totalMinutesHP = date.getHours() * 60 + date.getMinutes();
                return {...item, totalMinutesHP};
            });
            console.log(dataCopyHP);
            const sortedDataHP = dataCopyHP.sort((a, b) => new Date(a.timestamp) - new Date(b.timestamp));


            new Chart("myGraph", {
                type: "line",
                data: {
                    datasets: [
                        {
                            data: sortedData.map(item => ({x: item.timestamp, y: item.value})),
                            label: 'Heel prick data',
                            yAxisID: 'A',
                            borderColor: "green",
                            borderWidth: 1,
                            fill: false
                        },
                        {
                            data: thresholdHighArray,
                            pointRadius: 0,
                            label: 'HP threshold',
                            yAxisID: 'A',
                            borderColor: "red",
                            borderWidth: 1,
                            fill: false
                        },
                        {
                            data: thresholdLowArray,
                            yAxisID: 'A',
                            pointRadius: 0,
                            label: 'HP threshold',
                            borderColor: "red",
                            borderWidth: 1,
                            fill: false
                        }, {
                            data: sortedDataHP.map(item => ({x: item.timestamp, y: item.value})),
                            label: 'Patch data',
                            yAxisID: 'B',
                            borderColor: "orange",
                            borderWidth: 1,
                            fill: false
                        },{
                            data: thresholdLowArrayHP,
                            yAxisID: 'B',
                            label: 'Patch threshold',
                            pointRadius: 0,
                            borderColor: "blue",
                            borderWidth: 1,
                            fill: false
                        },
                        {
                            data: thresholdHighArrayHP,
                            label: 'Patch threshold',
                            yAxisID: 'B',
                            pointRadius: 0,
                            borderColor: "blue",
                            borderWidth: 1,
                            fill: false
                        },]
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
                        }],
                        xAxes: [{
                            display: false,
                        }],
                    }
                }
            });
        </script>
    </canvas>
    <div id="comments-frame">
        <h2>Comments</h2>
        <div id="comments-list">
            <%
                for(Comment comment : patient.getComments()) {
            %>
            <span>Time: <%=comment.getTimestamp()%></span>
            <br/>
            <span><%=comment.getValue()%></span>
            <br/>
            <br/>
            <%
                }
            %>
        </div>
    </div>
        <%
    if(user.getRole().equals("Doctor")) {
    %>
    <form action="/patient/thresholds">
        <input name="id" value="<%=patient.getId()%>" type="hidden"/>
        <button class="edit-thresh">
            <span class="text19"><span>Edit threshold</span></span>
        </button>
    </form>
    %>
        <%
    }
    %>
</body>