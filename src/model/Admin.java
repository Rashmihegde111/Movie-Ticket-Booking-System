package model;

public class Admin extends Person {

    private String employeeId;

    // Default constructor
    public Admin() {
        super();
        this.employeeId = "ADMIN001";
    }

    // Parameterized constructor
    public Admin(String name, String phone, String employeeId) {
        super(name, phone);
        this.employeeId = employeeId;
    }

    // Getter
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role   : Administrator");
    }

    @Override
    public String toString() {
        return "Admin{name='" + getName()
                + "', phone='" + getPhone()
                + "', employeeId='" + employeeId + "'}";
    }
}