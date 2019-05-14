package mvc_demo.repositories;

import mvc_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

//    Product findByNameContainingOrDescriptionContaining(String text);

//    @Query("SELECT DISTINCT category FROM springdemo.products")
//    List<String> getCategories();

}
