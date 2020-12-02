package webfejl.service;

import webfejl.exceptions.UnknownCustomerException;
import webfejl.model.Customers;

import java.util.Collection;

public interface CustomerService {

    Collection<Customers> getAllCustomers();

}
