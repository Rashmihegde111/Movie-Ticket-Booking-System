package model;

public abstract class Person {

    private String name;
    private String phone;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.phone = "Not Provided";
    }

    // Parameterized constructor
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Abstract method
    public abstract void displayRole();

    // Normal parent method
    public void displayPersonDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
    }
}