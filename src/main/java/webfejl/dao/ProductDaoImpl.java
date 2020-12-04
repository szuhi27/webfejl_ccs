package webfejl.dao;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webfejl.dao.entity.ProductEntity;
import webfejl.dao.entity.TransactionEntity;
import webfejl.exceptions.UnknownProductException;
import webfejl.model.Product;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao{

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    @Override
    public Collection<Product> readAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false)
                .map(entity -> new Product(
                        entity.getProductID(),
                        entity.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void createProduct(Product product) throws Exception{

        ProductEntity productEntity;

        productEntity = ProductEntity.builder()
                .ProductID(findProduct(product.getProductID()))
                .Description(product.getDescription())

                .build();
        log.info("ProductEntity: {}", productEntity);
        try {
            productRepository.save(productEntity);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    protected int findProduct(int product) throws UnknownProductException {

        Optional<ProductEntity> productEntity = productRepository.findById(product);
        if(productEntity.isPresent()){
            throw new UnknownProductException("Product already exists");
        } else if (product < 1){
            throw new UnknownProductException("Given ID is not valid (must be bigger that 0)!");
        } else {
            return product;
        }

    }

    @Override
    public void deleteProduct(Product product) throws UnknownProductException {
        Optional<ProductEntity> productEntity = StreamSupport.stream(productRepository.findAll().spliterator(),false).filter(
                entity ->{
                    return product.getProductID() == entity.getProductID();
                }
        ).findAny();

        Optional<TransactionEntity> transactionEntity = StreamSupport.stream(transactionRepository.findAll().spliterator(),false).filter(
                entity ->{
                    return product.getProductID() == entity.getProductID();
                }
        ).findAny();

        if(!productEntity.isPresent()){
            throw new UnknownProductException("No such product");
        } else if (transactionEntity.isPresent()){
            throw new UnknownProductException("Product in use, delete transaction first!");
        } else {
            productRepository.delete(productEntity.get());
        }
    }

}
