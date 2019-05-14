package mvc_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@Table(name="Users")
public class User implements Serializable {

    @Id
    private @NotNull String id;
    private @NotNull String firstName;
    private @NotNull String lastName;
    private @NotNull @Column(unique=true) String email;
    private @NotNull String password;

    @Transient // Keeps this field from being persisted
    private ArrayList<UserProductInfo> userProductInfos;

    // Special Constructors
    public User() { this.userProductInfos = new ArrayList<>(); }
    public User(String firstName, String lastName) {
        this.id = "";
        this.firstName = firstName;
        this.lastName = lastName;
        this.userProductInfos = new ArrayList<>();
    }

    // User methods
    /**
     * Adds a UserProductInfo to the user's list
     * @param productCode the productCode of the product
     * Will create a new user product with a rating of 0 and purchased set to false
     */
    public void addSaved(String productCode) {
        this.userProductInfos.add(new UserProductInfo(this.getId(), productCode, 0, true));
    }

    /**
     * Adds a UserProductInfo to the user's list
     * @param productInfo the UserProductInfo to add
     */
    public void addUserProductInfo(UserProductInfo productInfo) {
        this.userProductInfos.add(productInfo);
    }

    /**
     * Adds a UserProductInfo to the user's list 
     * @param product Product to go in the UserProductInfo
     * @param rating of the Product by the user
     * @param saved whether or not this is a user's saved product
     */
    public void addUserProductInfo(Product product, int rating, boolean saved) {
        this.userProductInfos.add(new UserProductInfo(this.getId(), product.getProductCode(), rating, saved));
    }

    /**
     * Adds a UserProductInfo to the user's list
     * @param productCode of the Product to go in the UserProductInfo
     * @param rating of the Product by the user
     * @param saved whether or not this is a user's saved product
     */
    public void addUserProductInfo(String productCode, int rating, boolean saved) {
        this.userProductInfos.add(new UserProductInfo(this.getId(), productCode, rating, saved));
    }

    /**
     * Retrieves a specific Product rating based on the productCode.
     * @param productCode productCode of the Product
     * @return rating of the UserProductInfo matched to the productCode
     */
    public int getRatingById(String productCode) {
        int rating = 0;
        for (UserProductInfo i : this.getUserProductInfos())
            if (i.getKey().getProductID().equals(productCode))
                rating = i.getRating();
        return rating;
    }

    /**
     * Retrieves a list of items that the user has rated
     * @return ArrayList of UserProductInfos that contain ratings above 0
     */
    public ArrayList<UserProductInfo> getRatedItems() {
        ArrayList<UserProductInfo> ratedItems = new ArrayList<>();
        for (UserProductInfo ui : this.userProductInfos)
            if (ui.getRating() > 0)
                ratedItems.add(ui);
        return ratedItems;
    }

    /**
     * Retrieves a specific UserProductInfo based on the productCode.
     * @param productCode productCode of the Product
     * @return UserProductInfo object that matches the productCode or null if otherwise
     */
    public UserProductInfo getUserProductInfoById(String productCode) {
        UserProductInfo ui = null;
        for (UserProductInfo i : this.getUserProductInfos())
            if (i.getKey().getProductID().equals(productCode))
                ui = i;
        return ui;
    }

    /**
     * Determines whether or not the user has the specified product in their UserProductInfo list
     * @param product the Product to check
     * @return true if in the user's UserProductInfo list, false otherwise
     */
    public boolean hasItemSaved(Product product) {
        boolean saved = false;
        for (UserProductInfo i: this.userProductInfos)
            if (i.getKey().getProductID().equals(product.getProductCode()))
                saved = i.isSaved();
        return saved;
    }

    /**
     * Determines whether or not the user has the specified product in their UserProductInfo list
     * @param productCode the productCode of the product to check
     * @return true if in the user's UserProductInfo list, false otherwise
     */
    public boolean hasItemSaved(String productCode) {
        boolean saved = false;
        for (UserProductInfo i: this.userProductInfos)
            if (i.getKey().getProductID().equals(productCode))
                saved = i.isSaved();
        return saved;
    }

    /**
     * Returns whether or not a user has rated the product
     * @param product the Product object to check
     * @return true if rating is above 0, false otherwise
     */
    public boolean hasRatingForItem(Product product) {
        boolean hasRating = false;
        for (UserProductInfo i: this.userProductInfos)
            if (i.getKey().getProductID().equals(product.getProductCode()))
                hasRating = i.getRating() > 0;
        return hasRating;
    }

    /**
     * Returns whether or not a user has rated the product based on the productCode
     * @param productCode the productCode of the Product to check
     * @return true if rating is above 0, false otherwise
     */
    public boolean hasRatingForItem(String productCode) {
        boolean hasRating = false;
        for (UserProductInfo i: this.userProductInfos)
            if (i.getKey().getProductID().equals(productCode))
                hasRating = i.getRating() > 0;
        return hasRating;
    }

    /**
     * Removes a UserProductInfo from the user's list of UserProductInfos
     * @param productCode of the Product object associated with the UserProductInfo to remove
     */
    public void removeUserProductInfo(String productCode) {
        if (productCode == null || productCode.isEmpty()) return;
        UserProductInfo toRemove = null;
        for (UserProductInfo i: this.userProductInfos)
            if (i.getKey().getProductID().equals(productCode))
                toRemove = i;
        if (toRemove != null) this.userProductInfos.remove(toRemove);
    }

}
