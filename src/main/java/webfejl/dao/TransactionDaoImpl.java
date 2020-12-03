package webfejl.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webfejl.exceptions.WrongCustomerException;
import webfejl.exceptions.UnknownProductException;
import webfejl.exceptions.UnknownTransactionException;
import webfejl.model.*;
import webfejl.dao.entity.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionDaoImpl implements TransactionDao {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Collection<Transaction> readAll() {
        return StreamSupport.stream(transactionRepository.findAll().spliterator(),false)
                .map(entity -> new Transaction(
                        entity.getTransactionID(),
                        entity.getDate(),
                        entity.getTime(),
                        entity.getCustomerID(),
                        entity.getCardID(),
                        entity.getProductID(),
                        entity.getAmount(),
                        entity.getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void createTransaction(Transaction transaction) throws Exception{

        TransactionEntity transactionEntity;

        transactionEntity = TransactionEntity.builder()
                .TransactionID(transaction.getTransactionID())
                .Date(transaction.getDate())
                .Time(transaction.getTime())
                .CustomerID(findCustomer(transaction.getCustomerID()))
                .CardID(transaction.getCardID())
                .ProductID(findProduct(transaction.getProductID()))
                .Amount(transaction.getAmount())
                .Price(transaction.getPrice())
                .build();
        log.info("TransactionEntity: {}", transactionEntity);
        try {
            transactionRepository.save(transactionEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }


    protected int findCustomer(int customer) throws WrongCustomerException {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(customer);
        if(customerEntity.isPresent()){
            return customer;
        } else {
            throw new WrongCustomerException("No such customer");
        }

    }

    protected int findProduct(int product) throws UnknownProductException{

        Optional<ProductEntity> productEntity = productRepository.findById(product);
        if(productEntity.isPresent()){
            return product;
        } else {
            throw new UnknownProductException("No such product");
        }

    }

    @Override
    public void deleteTransaction(Transaction transaction) throws UnknownTransactionException {
        Optional<TransactionEntity> transactionEntity = StreamSupport.stream(transactionRepository.findAll().spliterator(),false).filter(
                entity ->{
                    return transaction.getTransactionID() == entity.getTransactionID();
                }
        ).findAny();
        if(!transactionEntity.isPresent()){
            throw new UnknownTransactionException("No such transaction");
        }
        transactionRepository.delete(transactionEntity.get());
    }

}
