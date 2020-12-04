package webfejl.service;

import webfejl.exceptions.UnknownProductException;
import webfejl.model.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getAllProduct();

    void recordProduct(Product product) throws Exception;

    void deleteProduct(Product product) throws UnknownProductException;

}
