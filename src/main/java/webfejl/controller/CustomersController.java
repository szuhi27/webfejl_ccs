package webfejl.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webfejl.controller.dto.CustomersDto;
import webfejl.controller.dto.TransactionDto;
import webfejl.exceptions.UnknownCustomerException;
import webfejl.model.Customers;
import webfejl.service.CustomerService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public Collection<CustomersDto> listCustomers(){
        return customerService.getAllCustomers()
                .stream()
                .map(model -> CustomersDto.builder()
                        .CustomerID(model.getCustomerID())
                        .Segment(model.getSegment())
                        .Currency(model.getCurrency())
                        .build())
                .collect(Collectors.toList());
    }


}
