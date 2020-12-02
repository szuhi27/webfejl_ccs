package webfejl.dao;


import webfejl.exceptions.UnknownCustomerException;
import webfejl.exceptions.UnknownTransactionException;
import webfejl.model.*;

import java.util.Collection;

public interface TransactionDao {

    void createTransaction(Transaction transaction) throws  Exception;
    Collection<Transaction> readAll();
    void deleteTransaction(Transaction transaction) throws UnknownTransactionException;

}
