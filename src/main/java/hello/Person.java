package hello;

public class Person {
    private String firstName;
    private String lastName;

    Person() {
        firstName = "John";
        lastName = "Default";
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWholeName(){
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName){ this.firstName = firstName; }
}
