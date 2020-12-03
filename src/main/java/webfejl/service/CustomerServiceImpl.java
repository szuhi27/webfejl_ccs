package webfejl.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.persister.walking.spi.WalkingException;
import org.springframework.stereotype.Service;
import webfejl.dao.CustomerDao;
import webfejl.exceptions.WrongCustomerException;
import webfejl.model.Customer;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    @Override
    public Collection<Customer> getAllCustomers(){return customerDao.readAll();}

    @Override
    public void recordCustomer(Customer customer) throws Exception{
        customerDao.createCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) throws WrongCustomerException{
        customerDao.deleteCustomer(customer);
    }

}
