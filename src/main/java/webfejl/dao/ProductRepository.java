package webfejl.dao;

import org.springframework.data.repository.CrudRepository;
import webfejl.dao.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
