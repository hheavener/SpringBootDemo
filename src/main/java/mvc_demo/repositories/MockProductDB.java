package mvc_demo.repositories;

import mvc_demo.model.Product;
import mvc_demo.services.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;


public class MockProductDB {

//    public static final String STRUCTURE = "Structure";
//    public static final String TRAIN = "Train";
//    public static final String NATURE = "Nature";
//
//    public static ArrayList<Product> getAllProducts() {
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product("night", "Cabin at Night", "", STRUCTURE, "Images/night.jpg"));
//        products.add(new Product("number", "Train Number", "", TRAIN, "Images/number.jpg"));
//        products.add(new Product("bridge", "Bridge in Winter", "", STRUCTURE, "Images/bridge.jpg"));
//        products.add(new Product("forest", "Forest Path", "", NATURE, "Images/forest.jpg"));
//        products.add(new Product("rusty_train", "Rusty Train", "", TRAIN, "Images/rusty_train.jpg"));
//        products.add(new Product("train", "Train on a Mountain", "", TRAIN, "Images/train.jpg"));
//        products.add(new Product("tracks", "Autumn Train Tracks", "", TRAIN, "Images/tracks.jpg"));
//        products.add(new Product("winter", "Winter Cabin", "", STRUCTURE, "Images/winter.jpg"));
//        return products;
//    }

    // This method returns a specific Product in the above list
//    public static Product getProductById(String ProductCode) {
//        // Null Product
//        Product Product = null;
//        // Loop through the Products in the list comparing the Product codes to the one passed in the parameter
//        for (Product i: getAllProducts())
//            // If it matches...
//            if (ProductCode.equals(i.getProductCode()))
//                // Set the null Product to the current Product in the list
//                Product = i;
//        // Return the Product (NOTE: if an Product was matched, this will return that Product, otherwise it will return null)
//        return Product;
//    }
//
//    private final ProductService productService;
//
//    public MockProductDB(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public static Product getProductById(String productCode) {
//        return this.productService.getProductById(productCode);
//    }
}
