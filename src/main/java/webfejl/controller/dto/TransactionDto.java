package webfejl.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private int TransactionID;
    private java.sql.Date Date;
    private java.sql.Time Time;
    private int CustomerID;
    private int CardID;
    private int ProductID;
    private int Amount;
    private double Price;

}
