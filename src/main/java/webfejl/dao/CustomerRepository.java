package webfejl.dao;

import org.springframework.data.repository.CrudRepository;
import webfejl.dao.entity.CustomerEntity;

import java.util.Collection;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {



}
