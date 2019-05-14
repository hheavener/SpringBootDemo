package mvc_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import mvc_demo.repositories.ProductRepository;
import mvc_demo.repositories.UserProductInfoRepository;
import mvc_demo.repositories.UserRepository;
import mvc_demo.services.implementation.ProductServiceImpl;
import mvc_demo.services.implementation.UserProductInfoServiceImpl;
import mvc_demo.services.implementation.UserServiceImpl;
import mvc_demo.services.service.ProductService;
import mvc_demo.services.service.UserProductInfoService;
import mvc_demo.services.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("mvc_demo")
//@ComponentScan("mvc_demo.services")
@EnableJpaRepositories("mvc_demo.repositories")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    private final ProductRepository productRepository;
//    private final UserProductInfoRepository userProductInfoRepository;
//    private final UserRepository userRepository;
//
//    public DemoApplication(ProductRepository productRepository, UserProductInfoRepository userProductInfoRepository, UserRepository userRepository) {
//        this.productRepository = productRepository;
//        this.userProductInfoRepository = userProductInfoRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Bean
//    public ProductService productService() {
//        return new ProductServiceImpl(productRepository);
//    }
//
//    @Bean
//    public UserProductInfoService userProductInfoService() {
//        return new UserProductInfoServiceImpl(userProductInfoRepository);
//    }
//
//    @Bean
//    public UserService userService() {
//        return new UserServiceImpl(userRepository);
//    }

}
