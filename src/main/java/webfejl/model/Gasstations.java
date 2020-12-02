package webfejl.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Gasstations {

    private int GasStationID;
    private int ChainID;
    private String Country;
    private String Segment;

}
