package webfejl.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webfejl.dao.entity.CustomerEntity;
import webfejl.exceptions.UnknownCustomerException;
import webfejl.model.Customers;
import webfejl.model.Transaction;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao{

    private final CustomerRepository customerRepository;

    @Override
    public Collection<Customers> readAll(){
        return StreamSupport.stream(customerRepository.findAll().spliterator(),false)
                .map(entity -> new Customers(
                        entity.getCustomerID(),
                        entity.getSegment(),
                        entity.getCurrency()
                ))
                .collect(Collectors.toList());
    }


}
