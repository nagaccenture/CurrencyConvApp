# CurrencyConvApp
Currency conversion APP

Technologies used:
___________________________________________________________ 
spring MVC,Spring Boot,JPA
Maven,Junit
Database:H2

steps to execute the project :
_____________________________________________
clone the project from git hub url 
import project into eclipse using existing maven project option 
run maven:clean install 
war file will be created 
run CurrencyConvAppApplication java file from root folder as spring Boot App or Java app
 then in Built Tomcat server will be started and application deployed in Tomcat server.
 im Memory H2 data base also will be up.
 
 http://localhost:2020/ on chrome browser ,
 
  user  will able to see login page with create Account link .
  create account by clicking on that link 
  after creating account ,user can login to application ,then user will be routed to currency conversion page
  user can do currenct conversion on currency conversion page
 user can view the history of his last conversions by clicking on view History button 

i have used cache for this view History function call.

so some times when user does the currency conversion and if user clicks on view history ,it will not immediatly fetch the result from the DB ,
if cache time expires then it will fetch the data from DB.

 
  


