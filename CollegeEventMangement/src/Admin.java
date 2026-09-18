public class Admin extends User {

    private String role;

    public Admin(String userId, String name, String email, String role) {
        super(userId, name, email);
        this.role = role;
    }

    public void displayAdmin() {
        displayUser();
        System.out.println("Role: " + role);
    }

    @Override
    public void showRole() {
        System.out.println("Role: Admin");
    }
}
