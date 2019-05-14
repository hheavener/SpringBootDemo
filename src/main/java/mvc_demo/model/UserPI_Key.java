package mvc_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="UserProductInfo")
public class UserPI_Key implements Serializable {

    private String userID;

    private String productID;

}
