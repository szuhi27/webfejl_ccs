package webfejl.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class gasstations {

    private String GasStationID;
    private String ChainID;
    private String Country;
    private String Segment;

}
