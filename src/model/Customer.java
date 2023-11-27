package model;
import java.util.regex.Pattern;
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        String emailRegex = "^(.+)@(.+).com$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public String toString() {
        return "first Name: " + firstName + ", last Name: " + lastName + ", email: " + email;
    }
}
