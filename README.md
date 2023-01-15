# Babymonitor

Premature cannot control their blood glucose levels effectively. This leads to substantial risk of blindness or issues in brain development. It is therefore important to 
monitor their glucose levels to prevent this. Current glucose testing methods require collecting blood from the baby’s heel 13-14 times a day which is a very invasive
and stressful technique and leads to the requirment of blood transfusions.

A modern technology is being developed; it consists of a sampling pad placed on the baby’s skin that measures voltage, these values can then be converted to glucose
levels using a calibration curve. 

Our proyect aims to develop a webApp that records, stores and displays the data collected from the sampling pad so doctors or nurses can monitor the patient's glucose 
levels closely. It also allows users to add data from heel prick measurments and comments if for example the patient has been fed as these would sometimes explain 
fluctuations in glucose levels.

# Proyect structure and set up
 
Our proyect uses Tomcat which provides a web server environment in which Java code can run, it therefore should be installed before running.
To launch the webApp, select the Main class and click run, after this, type "localhost:8080" into your web server, this will lead to the login page.

Our database, created using mongodb, contains sample data on the user's information, for example the usernames, passwords and roles. The passwords have been hashed for 
security.To enter the Babymonitoring App, enter "admin" as a username and again "admin" as the password. This sample user has the role "doctor" and hence will be able to access
all components of the app, nurses will not be able to change the threshold 
