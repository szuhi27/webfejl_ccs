package webfejl.dao;

import webfejl.model.*;
import webfejl.exceptions.UnknownCustomerException;

import java.util.Collection;


public interface CustomerDao {

    Collection<Customers> readAll();

}
