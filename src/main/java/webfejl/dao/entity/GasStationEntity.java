package webfejl.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="gasstations", schema="ccs")
public class GasStationEntity {

    @Id
    @Column
    private int GasStationID;

    @Column
    private int ChainID;

    @Column
    private String Country;

    @Column
    private String Segment;

}
