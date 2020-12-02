package webfejl.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Transaction {

    private int TransactionID;
    private java.sql.Date Date;
    private java.sql.Time Time;
    private int CustomerID;
    private int CardID;
    //private int GasStationID;
    private int ProductID;
    private int Amount;
    private double Price;

}
