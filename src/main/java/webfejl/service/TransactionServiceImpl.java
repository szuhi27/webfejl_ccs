package webfejl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webfejl.dao.TransactionDao;
import webfejl.exceptions.UnknownCustomerException;
import webfejl.exceptions.UnknownTransactionException;
import webfejl.model.Customers;
import webfejl.model.Transaction;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionDao transactionDao;

    @Override
    public Collection<Transaction> getAllTransaction(){
        return transactionDao.readAll();
    }

    @Override
    public void recordTransaction(Transaction transaction) throws Exception {
        transactionDao.createTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) throws UnknownTransactionException {
        transactionDao.deleteTransaction(transaction);
    }

}
