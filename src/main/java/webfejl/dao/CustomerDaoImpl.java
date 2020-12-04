package webfejl.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webfejl.dao.entity.CustomerEntity;
import webfejl.dao.entity.TransactionEntity;
import webfejl.exceptions.WrongCustomerException;
import webfejl.exceptions.WrongIdException;
import webfejl.model.Customer;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao{

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Collection<Customer> readAll(){
        return StreamSupport.stream(customerRepository.findAll().spliterator(),false)
                .map(entity -> new Customer(
                        entity.getCustomerID(),
                        entity.getSegment(),
                        entity.getCurrency()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void createCustomer(Customer customer) throws Exception{

        CustomerEntity customerEntity;

        customerEntity = CustomerEntity.builder()
                .CustomerID(checkCustomer(customer.getCustomerID()))
                .Segment(customer.getSegment())
                .Currency(customer.getCurrency())
                .build();
        log.info("CustomerEntity: {}", customerEntity);
        try{
            customerRepository.save(customerEntity);
        } catch (Exception e){
            log.error(e.getMessage());
        }

    }

    private int checkCustomer(int customer) throws Exception{
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customer);
        if(customerEntity.isPresent()){
            throw new WrongCustomerException("Customer already exists!");
        } else if(customer < 1) {
            throw new WrongIdException("Given ID is not valid (must be bigger that 0)!");
        } else {
            return customer;
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws WrongCustomerException {

        Optional<CustomerEntity> customerEntity = StreamSupport.stream(customerRepository.findAll().spliterator(), false).filter(
                entity -> {
                    return customer.getCustomerID() == entity.getCustomerID();
                }
        ).findAny();

        Optional<TransactionEntity> transactionEntity = StreamSupport.stream(transactionRepository.findAll().spliterator(),false).filter(
                entity ->{
                    return customer.getCustomerID() == entity.getCustomerID();
                }
        ).findAny();

        if (!customerEntity.isPresent()) {
            throw new WrongCustomerException("No such customer");
        } else if (transactionEntity.isPresent()){
            throw new WrongCustomerException("Customer in use, delete transaction first!");
        } else {
            customerRepository.delete(customerEntity.get());
        }
    }

}
