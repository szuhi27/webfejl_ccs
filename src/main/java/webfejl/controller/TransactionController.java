package webfejl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webfejl.controller.dto.*;
import webfejl.exceptions.UnknownTransactionException;
import webfejl.model.Transaction;
import webfejl.service.TransactionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/transactions")
    public Collection<TransactionDto> listTransactions(){
        return transactionService.getAllTransaction()
                .stream()
                .map(model -> TransactionDto.builder()
                    .TransactionID(model.getTransactionID())
                    .Date(model.getDate())
                    .Time(model.getTime())
                    .CustomerID(model.getCustomerID())
                    .CardID(model.getCardID())
                    .ProductID(model.getProductID())
                    .Amount(model.getAmount())
                    .Price(model.getPrice())
                    .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/addTransaction")
    public void record(@RequestBody TransactionRecordDto recordDto) throws ParseException {
        try {
            transactionService.recordTransaction(new Transaction(
                    0,
                    currentDate(),
                    currentTime(),
                    recordDto.getCustomerID(),
                    recordDto.getCardID(),
                    recordDto.getProductID(),
                    recordDto.getAmount(),
                    recordDto.getPrice()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    private java.sql.Date currentDate() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date now = new java.util.Date();
        String date = dateFormat.format(now);
        java.util.Date parsed = dateFormat.parse(date);
        java.sql.Date dateSql = new java.sql.Date(parsed.getTime());
        return dateSql;
    }

    private java.sql.Time currentTime() throws ParseException{
        SimpleDateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
        java.util.Date now = new java.util.Date();
        String time = dateFormatTime.format(now);
        java.util.Date parsedTime = dateFormatTime.parse(time);
        java.sql.Time timeSql = new java.sql.Time(parsedTime.getTime());
        return timeSql;
    }

    @PostMapping("/deleteTransaction")
    public void deleteTransaction(@RequestBody TransactionDeleteDto transactionDeleteDto) throws ParseException{
        try{
            transactionService.deleteTransaction(new Transaction(
                    transactionDeleteDto.getTransactionID(),
                    currentDate(), currentTime(),
                    0,0,0,0,0
            ));
        } catch (UnknownTransactionException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
