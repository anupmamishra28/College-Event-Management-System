public abstract class User {

    protected String userId;
    protected String name;
    protected String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void displayUser() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    public abstract void showRole();
}
