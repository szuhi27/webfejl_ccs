package webfejl.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "yearmonth",schema = "ccs")
public class YearMonthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yearmonth_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private CustomerEntity CustomerId;

    @Column
    private java.sql.Date Date;

    @Column(precision=12, scale=2)
    private Double Consumption;

}
