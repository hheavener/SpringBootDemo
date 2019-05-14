package mvc_demo.services.implementation;

import lombok.Data;
import mvc_demo.repositories.ProductRepository;
import mvc_demo.model.Product;
import mvc_demo.services.service.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Service
public class ProductServiceImpl implements ProductService, InitializingBean {


    //========== Repository reference / constructor ==========//
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {this.productRepository = productRepository;}



    //========== For accessing ProductService statically ==========//
    private static ProductService instance;

    @Override
    public void afterPropertiesSet() throws Exception { instance = this; }

    public static ProductService getInstance(){
        return instance;
    }



    //========== Service methods ==========//
    @Override
    public Product getProductById(String id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for (Product p : this.getAllProducts())
            if (!categories.contains(p.getCategory()))
                categories.add(p.getCategory());

        // Sort categories alphabetically
        Collections.sort(categories, String.CASE_INSENSITIVE_ORDER);
        return categories;
    }


}
