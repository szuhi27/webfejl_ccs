package webfejl.dao;

import webfejl.exceptions.WrongCustomerException;
import webfejl.model.*;

import java.util.Collection;


public interface CustomerDao {

    Collection<Customer> readAll();
    void createCustomer(Customer customer) throws Exception;
    void deleteCustomer(Customer customer) throws WrongCustomerException;

}
