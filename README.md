<h2>RESTfull web services with Spring Boot, Jersey and hibernate using postgress database (Java configuration). The Application is hosted in Heroku https://hack-rest.herokuapp.com </h2>

<b>Technologies:</b>
<ul>
<li>Java 8</li>
<li>Maven 3</li>
<li>Spring Boot 1.1.9.RELEASE</li>
<li>Jersey 2.7</li>
<li>Hibernate 4</li>
<li>postgress DB</li>
<li>Heroku for hosting</li>
<ul>

<br/>

<p>First run the server with hibernate table create mode. </p>
<p>Update hibernate auto create table SqlInitialization class</p>
<pre>
 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
</pre>
<br/>
<pre>

<p>Now stop  the server & make the  hibernate table update  mode. </p>
<p>Disable  hibernate auto cretae  table SqlInitialization class</p>

 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "false");

Run with following maven goals to build & run the server  :
clean package && spring-boot:run

</pre>
<p>Go to: https://hack-rest.herokuapp.com/users to get list of users </p>


