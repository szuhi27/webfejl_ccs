package webfejl.dao;

import webfejl.exceptions.UnknownProductException;
import webfejl.model.Product;

import java.util.Collection;

public interface ProductDao {

    void createProduct(Product product) throws Exception;
    Collection<Product> readAll();
    void deleteProduct(Product product) throws UnknownProductException;

}
