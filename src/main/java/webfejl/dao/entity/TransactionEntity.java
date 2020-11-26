package webfejl.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="transaction", schema = "ccs")
public class TransactionEntity {

    @Id
    @Column
    private int TransactionID;

    @Column
    private java.sql.Date Date;

    @Column
    private java.sql.Time Time;

    @ManyToOne
    @JoinColumn(name="CustomerID")
    private  CustomerEntity CustomerID;

    @Column
    private int CardID;

    @ManyToOne
    @JoinColumn(name="GasStationID")
    private GasStationEntity GasStationID;

    @ManyToOne
    @JoinColumn(name="ProductID")
    private ProductEntity ProductID;

    @Column
    private int Amount;

    @Column(precision=12, scale=2)
    private Double Price;

}
