Spring Boot BackEnd Tutorial
===================

This application only implements a Back End, without any Front End interface. It has 3 functions for an imaginary flight scheduler application, based on MySql database:

1. Get passanger number for a specified flight .

key(s): 
	- flight id
response should have:
	- number of passanger

2. Get all flight for a passanger.

key(s): 
	- passanger id
response should have:
	- list of the following objects (flight id, date_of_departure, date_of_arrival, departure_airport_id, arrival_airport_id)

3. Get data of a plane for a specified flight.

key(s):
	- flight id
response should have:
	- max_speed, number_of_staff, number_of_passanger, max_cargo_weight, plane_weight


> **Note:**
> The main goal of this project was to improve my Java skills, REST and SpringBoot. 


Language: Sql, Java, 
Framework/API: SpringBoot
IDE/Tools:  Netbeans, Gradle, MySql Workbench, Postman

***Contact:***
<i class="icon-mail"></i> andras.banszki@gmail.com

> Written with [StackEdit](https://stackedit.io/).
