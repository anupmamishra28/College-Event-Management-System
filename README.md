College Event Management System

A console-based Java application designed to manage college events and student registrations. The system provides separate functionalities for students and administrators, including event management, registration, cancellation, seat management, search, exception handling, and file-based data storage.

📌 Project Overview

The College Event Management System is developed using Java and Object-Oriented Programming concepts. It provides a simple menu-driven interface through which students can view and register for events, while administrators can add, update, and delete events.

The project demonstrates important Java programming concepts such as:

* Classes and Objects
* Encapsulation
* Inheritance
* Abstraction
* Polymorphism
* ArrayList Collections
* Exception Handling
* Custom Exceptions
* File Handling
* Input Validation

Note: This project does not use JDBC, MySQL, JPA, ORM, or JPQL. Data is handled using Java collections and text files.

⸻

🎯 Objectives

* To develop a simple college event management system using Java.
* To allow students to view and search available events.
* To provide student event registration and cancellation functionality.
* To allow administrators to add, update, and delete events.
* To manage event seat availability automatically.
* To prevent duplicate registrations.
* To demonstrate Object-Oriented Programming concepts.
* To implement custom exception handling.
* To demonstrate file handling using Java File I/O.

⸻

✨ Features

👨‍🎓 Student Module

Students can:

1. View all available events
2. Search for an event using Event ID
3. Register for an event
4. Cancel an existing registration
5. View their registered events
6. Return to the main menu

👨‍💼 Admin Module

Administrators can:

1. View all events
2. Add a new event
3. Update an existing event
4. Delete an event
5. Return to the main menu

⚙️ System Features

* Automatic seat availability management
* Duplicate registration prevention
* Event search
* Input validation
* Custom exceptions
* File-based storage
* ArrayList-based data management
* Menu-driven console interface

⸻

🛠️ Technologies Used

* Programming Language: Java
* IDE: Visual Studio Code
* Collections: ArrayList
* File Handling: FileWriter
* Version Control: Git
* Repository: GitHub

⸻

📂 Project Structure

College-Event-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Event.java
│   ├── User.java
│   ├── Student.java
│   ├── Admin.java
│   ├── Registration.java
│   ├── EventNotFoundException.java
│   ├── EventFullException.java
│   └── FileManager.java
│
├── events.txt
├── registrations.txt
├── README.md
└── .gitignore

⸻

🧩 Java Concepts Used

1. Classes and Objects

Different classes are created to represent different entities of the system.

Examples:

* Event
* User
* Student
* Admin
* Registration
* FileManager

⸻

2. Encapsulation

The Event class uses private data members and public getter/setter methods to control access to its data.

Example:

private String eventName;
public String getEventName() {
    return eventName;
}
public void setEventName(String eventName) {
    this.eventName = eventName;
}

⸻

3. Inheritance

Student and Admin inherit from the abstract User class.

             User
            /    \
       Student   Admin

⸻

4. Abstraction

The User class is declared as an abstract class and contains the abstract method:

public abstract void showRole();

The child classes provide their own implementation.

⸻

5. Polymorphism

The showRole() method is overridden in both Student and Admin.

@Override
public void showRole() {
    System.out.println("Role: Student");
}

and:

@Override
public void showRole() {
    System.out.println("Role: Admin");
}

⸻

6. Collections

ArrayList is used to store events and registrations dynamically.

ArrayList<Event> events = new ArrayList<>();
ArrayList<Registration> registrations = new ArrayList<>();

⸻

7. Exception Handling

Custom exceptions are used for specific error conditions.

EventNotFoundException

Used when a requested event does not exist.

EventFullException

Used when an event has no available seats.

Example:

throw new EventNotFoundException(
    "Event with ID " + eventId + " does not exist!"
);

⸻

8. File Handling

The project uses Java File I/O to save event and registration information.

The following files are used:

events.txt
registrations.txt

The FileManager class uses FileWriter to store the current data.

⸻

🔄 System Workflow

                 Start
                   │
                   ▼
          Main Menu
          /    |     \
         /     |      \
   Student    Admin    Exit
      │         │
      ▼         ▼
Student Menu  Admin Menu
      │         │
      ▼         ▼
View/Search   Add/Update/
Register      Delete Event
Cancel
View Registered
      │
      ▼
Update Seat Availability
      │
      ▼
Save Data to Text Files
      │
      ▼
     End

⸻

👨‍🎓 Student Workflow

Student
   │
   ▼
Student Menu
   │
   ├── View Events
   │
   ├── Search Event
   │
   ├── Register for Event
   │       │
   │       ├── Check Event
   │       ├── Check Seats
   │       ├── Check Duplicate Registration
   │       └── Register Student
   │
   ├── Cancel Registration
   │       └── Increase Available Seat
   │
   └── View Registered Events

⸻

👨‍💼 Admin Workflow

Admin
  │
  ▼
Admin Menu
  │
  ├── View Events
  │
  ├── Add Event
  │
  ├── Update Event
  │
  └── Delete Event

⸻

🎟️ Event Registration Logic

When a student registers for an event, the system:

1. Takes the Student ID.
2. Takes the Event ID.
3. Checks whether the event exists.
4. Checks whether seats are available.
5. Checks whether the student is already registered.
6. Creates a new registration.
7. Decreases the available seat count.
8. Saves the updated registration and event information.

If the event does not exist, EventNotFoundException is generated.

If the event is full, EventFullException is generated.

⸻

💺 Seat Management

Each event contains:

* Total Seats
* Available Seats

When a student successfully registers:

Available Seats = Available Seats - 1

When a student cancels:

Available Seats = Available Seats + 1

This keeps the seat availability updated automatically.

⸻

📝 Sample Events

The application initially contains sample events such as:

TechFest 2026

* Event ID: E101
* Category: Technical
* Date: 20-09-2026
* Time: 10:00 AM
* Venue: Main Auditorium
* Organizer: CSE Department
* Total Seats: 200

Cultural Night

* Event ID: E102
* Category: Cultural
* Date: 25-09-2026
* Time: 6:00 PM
* Venue: Open Air Theatre
* Organizer: Student Council
* Total Seats: 500

⸻

▶️ How to Run the Project

Step 1: Install Java

Make sure Java is installed on your system.

Check the Java version:

java -version

Check the Java compiler:

javac -version

⸻

Step 2: Open the Project

Open the project folder in Visual Studio Code.

⸻

Step 3: Compile the Java Files

From the project root directory, run:

javac src/*.java

⸻

Step 4: Run the Application

Run:

java -cp src Main

⸻

🧪 Testing Performed

The following functionalities were tested:

Test Case	Result
View Events	Passed
Search Valid Event	Passed
Search Invalid Event	Passed
Add Event	Passed
Update Event	Passed
Delete Event	Passed
Register for Event	Passed
Duplicate Registration	Passed
Cancel Registration	Passed
Seat Count Update	Passed
Full Event Handling	Passed
Invalid Numeric Input	Passed

⸻

⚠️ Limitations

* The application currently uses text files instead of a database.
* Data loading from files when the application starts is not implemented.
* The system uses a console-based interface.
* Authentication is not implemented.
* Multiple users cannot interact with the system simultaneously.
⸻
🚀 Future Scope

The project can be further improved by adding:

* Database integration
* JDBC connectivity
* GUI or web-based interface
* Student and admin authentication
* Automatic loading of saved data
* Email notifications
* Event reminders
* Event category filtering
* Advanced reporting and analytics

These are future enhancements and are not part of the current implementation.

⸻
📚 Learning Outcomes

Through this project, the following concepts were practiced:

* Java programming
* Object-Oriented Programming
* Inheritance and abstraction
* Method overriding
* Collections Framework
* Exception handling
* Custom exceptions
* File handling
* Input validation
* Modular program design
* Git and GitHub
⸻
👩‍💻 Author

Anupma Mishra

B.Tech CSE (Artificial Intelligence & Machine Learning)
VIT Bhopal University
⸻

📌 Project Status

Status: Completed

The current version successfully implements the core college event management functionalities using Java, OOP, Collections, Exception Handling, and File I/O.
