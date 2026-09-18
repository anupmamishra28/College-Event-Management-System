import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveEvents() {

        try {
            FileWriter writer = new FileWriter("events.txt");

            for (Event event : Main.events) {

                writer.write(
                        event.getEventId() + "," +
                        event.getEventName() + "," +
                        event.getCategory() + "," +
                        event.getDate() + "," +
                        event.getTime() + "," +
                        event.getVenue() + "," +
                        event.getOrganizer() + "," +
                        event.getTotalSeats() + "," +
                        event.getAvailableSeats() + "\n"
                );
            }

            writer.close();

            System.out.println("Events saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    public static void saveRegistrations() {

        try {
            FileWriter writer = new FileWriter("registrations.txt");

            for (var registration : Main.registrations) {

                writer.write(
                        registration.getStudentId() + "," +
                        registration.getEventId() + "\n"
                );
            }

            writer.close();

            System.out.println("Registrations saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving registrations: " + e.getMessage()
            );
        }
    }
}