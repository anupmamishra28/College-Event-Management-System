College Event Management System

A console-based Java application for managing college events and student registrations. The system provides separate Student and Admin modules with event management, registration, seat tracking, exception handling, and file-based storage.

🎯 Features

Student Module

* View all events
* Search events by Event ID
* Register for events
* Cancel registrations
* View registered events
* Automatic seat availability updates
* Duplicate registration prevention

Admin Module

* View events
* Add new events
* Update existing events
* Delete events

System Features

* Input validation
* Custom exception handling
* ArrayList-based data management
* File handling using FileWriter
* Menu-driven console interface

🛠️ Technologies Used

* Language: Java
* IDE: Visual Studio Code
* Collections: ArrayList
* File Handling: Java File I/O
* Version Control: Git & GitHub

Note: This project does not use JDBC, MySQL, JPA, ORM, or JPQL.

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

🧩 Java Concepts Used

* Classes and Objects
* Encapsulation
* Inheritance
* Abstraction
* Polymorphism
* Collections Framework
* Exception Handling
* Custom Exceptions
* File Handling

OOP Structure

             User
            /    \
       Student   Admin

Student and Admin inherit from the abstract User class and override the showRole() method.

🎟️ Registration Workflow

1. Student enters Student ID and Event ID.
2. System checks whether the event exists.
3. Available seats are checked.
4. Duplicate registration is prevented.
5. Registration is created.
6. Available seats decrease by one.
7. Registration and event data are saved to text files.

When a registration is cancelled, the available seat count increases by one.

⚠️ Custom Exceptions

EventNotFoundException

Used when the requested event does not exist.

EventFullException

Used when an event has no available seats.

📄 File Handling

The application stores data in:

events.txt
registrations.txt

The FileManager class uses Java FileWriter to save event and registration information.

▶️ How to Run

Check Java installation:

java -version
javac -version

Compile:

javac src/*.java

Run:

java -cp src Main

🧪 Testing

The following functionalities were tested successfully:

* View events
* Search valid/invalid events
* Add, update and delete events
* Event registration
* Duplicate registration prevention
* Registration cancellation
* Seat count updates
* Full event handling
* Invalid numeric input
* Custom exception handling

⚠️ Limitations

* Console-based interface
* No database integration
* Data is saved to text files
* Automatic loading of saved data on application restart is not implemented
* Authentication is not implemented

🚀 Future Scope

* Database integration
* GUI or web interface
* User authentication
* Automatic data loading
* Email notifications
* Event reminders
* Advanced reports and analytics

👩‍💻 Author

Anupma Mishra
B.Tech CSE (Artificial Intelligence & Machine Learning)
VIT Bhopal University

📌 Project Status

Completed — Core college event management functionalities have been implemented and tested using Java OOP, Collections, Exception Handling, and File I/O.
