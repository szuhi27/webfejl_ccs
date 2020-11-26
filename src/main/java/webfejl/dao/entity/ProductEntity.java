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
@Table(name = "products", schema = "ccs")
public class ProductEntity {

    @Id
    @Column
    private int ProductID;

    @Column
    private String Description;

}
