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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int TransactionID;

    @Column
    private java.sql.Date Date;

    @Column
    private java.sql.Time Time;

    @Column
    private int CustomerID;

    @Column
    private int CardID;

    //@ManyToOne
    //@JoinColumn(name="ProductID")
    @Column
    private int ProductID;
    //private ProductEntity ProductID;

    @Column
    private int Amount;

    @Column(precision=12, scale=2)
    private Double Price;

}
