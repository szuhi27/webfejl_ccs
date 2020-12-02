package webfejl.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRecordDto {

    private int CustomerID;
    private int CardID;
    private int ProductID;
    private int Amount;
    private double Price;

}
