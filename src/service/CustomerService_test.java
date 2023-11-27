package service;

import model.Customer;

import java.util.Collection;

public class CustomerService_test {
    public static void main(String[] args) {

        // testing getAllCustomers:
        Collection<Customer> cList = CustomerService.getAllCustomers();
        System.out.println("before adding new customer: " + cList);

        // testing addCustomer and getAllCustomers:
        CustomerService.addCustomer("f1l1@gmail.com", "f1", "l1");
        System.out.println("after adding a new customer: " + cList);

        CustomerService.addCustomer("f2l2@gmail.com", "f2", "l2");
        CustomerService.addCustomer("f3l3@gmail.com", "f3", "l3");
        CustomerService.addCustomer("f4l4@gmail.com", "f4", "l4");
        System.out.println("after adding 3 new customers: " + cList);

        // testing getCustomer:
        Customer x =  CustomerService.getCustomer("f3l3@gmail.com");
        System.out.println(x);
        Customer y =  CustomerService.getCustomer("f5l5@gmail.com");
        System.out.println(y);
    }
}
