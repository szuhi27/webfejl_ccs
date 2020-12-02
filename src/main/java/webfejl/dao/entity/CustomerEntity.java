package webfejl.dao.entity;


import lombok.*;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="customers", schema="ccs")
public class CustomerEntity {

    @Id
    @Column
    private int CustomerID;

    @Column
    private String Segment;

    @Column
    private String Currency;

}
