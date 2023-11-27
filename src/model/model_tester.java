package model;
public class model_tester {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "last", "fl@domain.com");
        System.out.println(customer);

        // test email validation:
        Customer invalidCustomer = new Customer("first", "last", "fl@domain.org");
    }
}
