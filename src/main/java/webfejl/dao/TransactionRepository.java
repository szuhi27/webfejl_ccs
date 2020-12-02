package webfejl.dao;

import org.springframework.data.repository.CrudRepository;
import webfejl.dao.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
}
