# Project-4
CS180 Group Project 

Instructions on how to compile and run your project. 
A list of who submitted which parts of the assignment on Brightspace and Vocareum. 
For example: Student 1 - Submitted Report on Brightspace. Student 2 - Submitted Vocareum workspace.
A detailed description of each class. This should include the functionality included in the class, the testing done to verify it works properly, and its relationship to other classes in the project. 


For our project 04 in order to compile and run our project you have to navigate to the DoctorsOfficeManager and then run the class. 
The main method for our project is DoctorsOfficeManager.java class. After compiling you will be greeted and asked to choose whether to login in or create an exisiting account. Once logged in you can finally use our calendar to either create, edit or delete an appointment. 
We have 6 other classes in this project. We have the Seller.java, User.java, Store.java, Appointment.java, Calendar.java classes and Customer.java. 
The Seller.java class extends User, a seller is a type of user that our program deals with the appointments and the stores. We store the type of store each seller has in an arraylist and each seller can add or modify their own calendar however they see fit. The seller can also view, approve and deny appointment requests that each customer has reuqested. An appointment is not set or added to the calendar until the seller has approved said appointment. 
The User.java class is a method that stores all information for each type of user. This information is mainly important for logging in and keeping identifying information. Information like the users username, password, first name, last name and email are stored into a file so that all the information is kept and not forgotten. 
The Store.java class allows users to create, edit and delete calenders. Each store has their own calendar and each store can edit their own calendar. This class stores the name of each store and the calendar list in an array list.  
The Appointment.java class allows appointments to be requested for the customer and it allows the seller to either approve or decline the appointments that each customer sets. Each appointment is an hour long and it hold the title, start and end time for each appointment to keep overbooking to a minimum. Each appointment and appointment request is time stamped so that each seller can see each request in order. 
The Calendar.java class holds the calendar name, the description of the calendar and then two array lists of the appointments for that day, and the appointment requests that have yet to be approved or denied. 
The Customer.java class is another type of User. The customer is allowed to view calendars and they can request or remove requests for appointments. The customer's appointment will only be added to the calendar after the seller has approve the appointment request. 

