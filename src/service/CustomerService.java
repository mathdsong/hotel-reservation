package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {

    static Collection<Customer> customersList = new ArrayList<Customer>();
    public static void addCustomer(String email, String firstName, String lastName) {
        Customer newCustomer = new Customer(firstName, lastName, email);
        customersList.add(newCustomer);
    }

    public static Customer getCustomer(String customerEmail) {
        for (Customer customer : customersList) {
            if (customer.email.equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }


    public static Collection<Customer> getAllCustomers() {
        return customersList;
    }
}
