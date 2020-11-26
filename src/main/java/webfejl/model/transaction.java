package webfejl.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class transaction {

    private String Transaction;
    private String Date;
    private String Time;
    private String CustomerID;
    private String CardID;
    private String GasStationID;
    private String ProductID;
    private String Amount;
    private String Price;

}
