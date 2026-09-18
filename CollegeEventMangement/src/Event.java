public class Event {

    private String eventId;
    private String eventName;
    private String category;
    private String date;
    private String time;
    private String venue;
    private String organizer;
    private int totalSeats;
    private int availableSeats;

    public Event(String eventId, String eventName, String category,
                 String date, String time, String venue,
                 String organizer, int totalSeats) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.category = category;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.organizer = organizer;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
public void setAvailableSeats(int availableSeats) {
    this.availableSeats = availableSeats;
}
    // Getters

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getOrganizer() {
        return organizer;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void displayEvent() {

        System.out.println("\n-----------------------------");
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Venue: " + venue);
        System.out.println("Organizer: " + organizer);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("-----------------------------");
    }
}