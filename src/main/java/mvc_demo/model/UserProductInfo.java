package mvc_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc_demo.services.implementation.ProductServiceImpl;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserProductInfo implements Serializable {

    @EmbeddedId
    private UserPI_Key key;

    private int rating;
    private boolean saved;

    public UserProductInfo(String userID, String productID, int rating, boolean saved) {
        this.key = new UserPI_Key(userID, productID);
        this.rating = rating;
        this.saved = saved;
    }

    /**
     * Will retrieve the product object from the productDB associated with this UserProductInfo.
     * @return Product
     */
    public Product getProduct() {
        return ProductServiceImpl.getInstance().getProductById(this.key.getProductID());
    }

    /**
     * Returns the rating as a String value
     * @return "None" if rating equals 0 or the String value of the rating otherwise
     */
    public String getRatingAsString() {
        if (rating == 0) return "None";
        else return Integer.toString(rating);
    }

}
