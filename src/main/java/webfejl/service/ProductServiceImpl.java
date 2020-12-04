package webfejl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webfejl.dao.ProductDao;
import webfejl.exceptions.UnknownProductException;
import webfejl.model.Product;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    @Override
    public Collection<Product> getAllProduct(){
        return productDao.readAll();
    }

    @Override
    public void recordProduct(Product product) throws Exception {
        productDao.createProduct(product);
    }

    @Override
    public void deleteProduct(Product product) throws UnknownProductException {
        productDao.deleteProduct(product);
    }

}
