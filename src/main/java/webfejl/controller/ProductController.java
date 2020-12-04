package webfejl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webfejl.controller.dto.*;
import webfejl.exceptions.UnknownProductException;
import webfejl.model.Product;
import webfejl.service.ProductService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Collection<ProductDto> listProducts(){
        return productService.getAllProduct()
                .stream()
                .map(model -> ProductDto.builder()
                        .ProductID(model.getProductID())
                        .Description(model.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductDto productDto){
        try {
            productService.recordProduct(new Product(
               productDto.getProductID(),
               productDto.getDescription()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestBody ProductDeleteDto productDeleteDto){
        try {
            productService.deleteProduct(new Product(
                    productDeleteDto.getProductID(),
                    ""
            ));
        } catch (UnknownProductException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
