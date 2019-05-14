package mvc_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Products")
public class Product implements Serializable {

    @Id
    @Column(name="ProductID")
    private String productCode;

    private String name;
    private String description;
    private String category;
    private String imageUrl;

}
