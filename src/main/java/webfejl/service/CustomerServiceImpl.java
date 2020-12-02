package webfejl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webfejl.dao.CustomerDao;
import webfejl.exceptions.UnknownCustomerException;
import webfejl.model.Customers;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    @Override
    public Collection<Customers> getAllCustomers(){return customerDao.readAll();}



}
