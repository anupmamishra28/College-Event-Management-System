import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Event> events = new ArrayList<>();
    static ArrayList<Registration> registrations = new ArrayList<>();

    static class Registration {
        private final String studentId;
        private final String eventId;

        Registration(String studentId, String eventId) {
            this.studentId = studentId;
            this.eventId = eventId;
        }

        String getStudentId() {
            return studentId;
        }

        String getEventId() {
            return eventId;
        }
    }

    public static void main(String[] args) {

        addSampleEvents();

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("  COLLEGE EVENT MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Student");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    adminMenu();
                    break;

                case 3:
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    // ---------------- SAMPLE EVENTS ----------------

    static void addSampleEvents() {

        events.add(new Event(
                "E101",
                "TechFest 2026",
                "Technical",
                "20-09-2026",
                "10:00 AM",
                "Main Auditorium",
                "CSE Department",
                200
        ));

        events.add(new Event(
                "E102",
                "Cultural Night",
                "Cultural",
                "25-09-2026",
                "6:00 PM",
                "Open Air Theatre",
                "Student Council",
                500
        ));
    }

    // ---------------- STUDENT MENU ----------------

    static void studentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. View Events");
            System.out.println("2. Search Event");
            System.out.println("3. Register for Event");
            System.out.println("4. Cancel Registration");
            System.out.println("5. View Registered Events");
            System.out.println("6. Back");

            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {

                case 1:
                    viewEvents();
                    break;

                case 2:
                    searchEvent();
                    break;

                case 3:
                    registerForEvent();
                    break;

                case 4:
                    cancelRegistration();
                    break;

                case 5:
                    viewRegisteredEvents();
                    break;

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- UPDATE EVENT ----------------

    static void updateEvent() {

        if (events.isEmpty()) {
            System.out.println("No events available to update.");
            return;
        }

        sc.nextLine();

        System.out.println("\n===== UPDATE EVENT =====");
        System.out.print("Enter Event ID to update: ");
        String eventId = sc.nextLine();

        int index = -1;

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventId().equalsIgnoreCase(eventId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Event not found!");
            return;
        }

        System.out.print("Enter New Event Name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter New Category: ");
        String category = sc.nextLine();

        System.out.print("Enter New Date: ");
        String date = sc.nextLine();

        System.out.print("Enter New Time: ");
        String time = sc.nextLine();

        System.out.print("Enter New Venue: ");
        String venue = sc.nextLine();

        System.out.print("Enter New Organizer: ");
        String organizer = sc.nextLine();

        System.out.print("Enter New Total Seats: ");
        int totalSeats = getIntInput();

        if (totalSeats <= 0) {
            System.out.println("Total seats must be greater than 0.");
            return;
        }

        Event updatedEvent = new Event(
                eventId,
                eventName,
                category,
                date,
                time,
                venue,
                organizer,
                totalSeats
        );

        events.set(index, updatedEvent);
        FileManager.saveEvents();

        System.out.println("\nEvent updated successfully!");
    }

    // ---------------- DELETE EVENT ----------------

    static void deleteEvent() {

        if (events.isEmpty()) {
            System.out.println("No events available to delete.");
            return;
        }

        sc.nextLine();

        System.out.println("\n===== DELETE EVENT =====");
        System.out.print("Enter Event ID to delete: ");
        String eventId = sc.nextLine();

        boolean removed = false;

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventId().equalsIgnoreCase(eventId)) {
                events.remove(i);
                FileManager.saveEvents();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("\nEvent deleted successfully!");
        } else {
            System.out.println("Event not found!");
        }
    }

    // ---------------- ADMIN MENU ----------------

   static void adminMenu() {

    boolean back = false;

    while (!back) {

        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1. View Events");
        System.out.println("2. Add Event");
        System.out.println("3. Update Event");
        System.out.println("4. Delete Event");
        System.out.println("5. Back");

        System.out.print("Enter your choice: ");
        int choice = getIntInput();

        switch (choice) {

            case 1:
                viewEvents();
                break;

            case 2:
                addEvent();
                break;

            case 3:
                updateEvent();
                break;

            case 4:
                deleteEvent();
                break;

            case 5:
                back = true;
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
    // ---------------- VIEW EVENTS ----------------

    static void viewEvents() {

        System.out.println("\n===== UPCOMING EVENTS =====");

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event event : events) {
            event.displayEvent();
        }
    }

    // ---------------- ADD EVENT ----------------

    static void addEvent() {

        sc.nextLine();

        System.out.println("\n===== ADD NEW EVENT =====");

        System.out.print("Enter Event ID: ");
        String eventId = sc.nextLine();

        System.out.print("Enter Event Name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Time: ");
        String time = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        System.out.print("Enter Organizer: ");
        String organizer = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        int totalSeats = getIntInput();

        if (totalSeats <= 0) {
            System.out.println("Total seats must be greater than 0.");
            return;
        }

        Event newEvent = new Event(
                eventId,
                eventName,
                category,
                date,
                time,
                venue,
                organizer,
                totalSeats
        );

        events.add(newEvent);
        FileManager.saveEvents();

        System.out.println("\nEvent added successfully!");
    }

    // ---------------- SEARCH EVENT ----------------

    static void searchEvent() {

        sc.nextLine();

        System.out.print("Enter Event ID: ");
        String id = sc.nextLine();

        boolean found = false;

        for (Event event : events) {

            if (event.getEventId().equalsIgnoreCase(id)) {

                event.displayEvent();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Event not found!");
        }
    }
    static void registerForEvent() {

        sc.nextLine();

        System.out.println("\n===== EVENT REGISTRATION =====");

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter Event ID: ");
        String eventId = sc.nextLine();

        try {
            Event selectedEvent = null;

            for (Event event : events) {
                if (event.getEventId().equalsIgnoreCase(eventId)) {
                    selectedEvent = event;
                    break;
                }
            }

            if (selectedEvent == null) {
                throw new EventNotFoundException(
                        "Event with ID " + eventId + " does not exist!"
                );
            }

            if (selectedEvent.getAvailableSeats() <= 0) {
                throw new EventFullException(
                        "Sorry! " + selectedEvent.getEventName()
                                + " is completely full."
                );
            }

            for (Registration registration : registrations) {
                if (registration.getStudentId().equalsIgnoreCase(studentId)
                        && registration.getEventId().equalsIgnoreCase(eventId)) {
                    System.out.println("You are already registered for this event.");
                    return;
                }
            }

            registrations.add(new Registration(studentId, eventId));

            selectedEvent.setAvailableSeats(
                    selectedEvent.getAvailableSeats() - 1
            );

            FileManager.saveRegistrations();
            FileManager.saveEvents();

            System.out.println("Registration successful!");
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EventFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void cancelRegistration() {

    sc.nextLine();

    System.out.println("\n===== CANCEL REGISTRATION =====");

    System.out.print("Enter Student ID: ");
    String studentId = sc.nextLine();

    System.out.print("Enter Event ID: ");
    String eventId = sc.nextLine();

    int registrationIndex = -1;

    // Find the registration
    for (int i = 0; i < registrations.size(); i++) {

        Registration registration = registrations.get(i);

        if (registration.getStudentId().equalsIgnoreCase(studentId)
                && registration.getEventId().equalsIgnoreCase(eventId)) {

            registrationIndex = i;
            break;
        }
    }

    // Registration not found
    if (registrationIndex == -1) {
        System.out.println("Registration not found!");
        return;
    }

    // Remove registration
    registrations.remove(registrationIndex);

    // Find the event
    for (Event event : events) {

        if (event.getEventId().equalsIgnoreCase(eventId)) {

            event.setAvailableSeats(
                    event.getAvailableSeats() + 1
            );

            break;
        }
    }

    FileManager.saveRegistrations();
    FileManager.saveEvents();

    System.out.println("Registration cancelled successfully!");
    }

    static void viewRegisteredEvents() {

        sc.nextLine();

        System.out.println("\n===== REGISTERED EVENTS =====");

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        boolean found = false;

        for (Registration registration : registrations) {

            if (registration.getStudentId().equalsIgnoreCase(studentId)) {

                for (Event event : events) {

                    if (event.getEventId()
                            .equalsIgnoreCase(registration.getEventId())) {

                        event.displayEvent();
                        found = true;
                        break;
                    }
                } 
            }
        }

        if (!found) {
            System.out.println("No registered events found.");
        }
    }

    static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
        }

        return sc.nextInt();
    }

}
