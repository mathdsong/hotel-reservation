package model;
public class Customer_test {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "last", "fl@domain.com");
        System.out.println(customer);

        // test email validation:
        Customer invalidCustomer = new Customer("first", "last", "fl@domain.org");
    }
}
