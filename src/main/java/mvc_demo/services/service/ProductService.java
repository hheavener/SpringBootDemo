package mvc_demo.services.service;

import mvc_demo.model.Product;

import java.util.List;

public interface ProductService {

    String STRUCTURE = "Structure";
    String TRAIN = "Train";
    String NATURE = "Nature";

    Product getProductById(String id);

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    void deleteProduct(Product product);

    public List<String> getCategories();

}
