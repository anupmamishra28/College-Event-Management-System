public class Student extends User {

    private String department;

    public Student(String userId, String name, String email, String department) {
        super(userId, name, email);
        this.department = department;
    }

    public void displayStudent() {
        displayUser();
        System.out.println("Department: " + department);
    }

    @Override
    public void showRole() {
        System.out.println("Role: Student");
    }
}
