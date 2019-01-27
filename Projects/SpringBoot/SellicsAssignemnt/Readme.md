
 Sellics Assignment



Description 

I have implemented a micro service which inquires amazon API for a particular keyword that is provided in the rest web service url.
URL:-  http://localhost:8080/ api/estimate/{keyword})
Once the results are found for that particular keyword I check in the results in which position the exact match has been found and according to the position I assign the score to the result. 

Technologies Used

I have used the below mentioned technologies in the application.
•	Spring Boot
•	REST
•	Maven
•	JAVA 8
•	Eclipse

How To Test
Please package the application by running maven command once you have imported the maven project that I have shared in eclipse. Once the maven build process is complete a file named (SellicsAssignemnt-0.0.1-SNAPSHOT.jar) will be generated. You can run the jar file using the command (java –jar filename) on the command prompt. After executing the command the service will run.
This service contains its own conatiner(Tomcat) which will start on the port 8080 and the service can be accessed on the url (http://localhost:8080/ api/estimate/{keyword}). On this url the endpoints of the REST web service are residing.


    Regards
Ahsan Abid Hassan
