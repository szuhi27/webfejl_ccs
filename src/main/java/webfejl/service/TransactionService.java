package webfejl.service;

import webfejl.exceptions.UnknownCustomerException;
import webfejl.exceptions.UnknownTransactionException;
import webfejl.model.Customers;
import webfejl.model.Transaction;

import java.util.Collection;

public interface TransactionService {

    Collection<Transaction> getAllTransaction();

    void recordTransaction(Transaction transaction) throws Exception;

    void deleteTransaction(Transaction transaction) throws UnknownTransactionException;

}