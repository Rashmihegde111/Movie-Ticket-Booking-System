package model;

public class Customer extends Person {

    private String email;

    // Default constructor
    public Customer() {
        super();
        this.email = "Not Provided";
    }

    // Parameterized constructor
    public Customer(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    // Getter
    public String getEmail() {
        return email;
    }

    // Setter
    public void setEmail(String email) {
        this.email = email;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role   : Customer");
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "Customer{name='" + getName()
                + "', phone='" + getPhone()
                + "', email='" + email + "'}";
    }
}