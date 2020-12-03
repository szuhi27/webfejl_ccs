package webfejl.service;

import org.hibernate.persister.walking.spi.WalkingException;
import webfejl.exceptions.WrongCustomerException;
import webfejl.model.Customer;

import java.util.Collection;

public interface CustomerService {

    Collection<Customer> getAllCustomers();

    void recordCustomer(Customer customer) throws Exception;

    void deleteCustomer(Customer customer) throws WrongCustomerException;
}
