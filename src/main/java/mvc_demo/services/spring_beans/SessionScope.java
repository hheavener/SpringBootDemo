package mvc_demo.services.spring_beans;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Data
//@AllArgsConstructor
//@Configuration
//public class SessionScope {

//    private final ProductRepository productRepository;
//    private final UserProductInfoRepository userProductInfoRepository;
//    private final UserRepository userRepository;

//    private List<Product> productsInSession;

//    @Bean
////    @Scope(value="Singleton")
//    public ProductService productService() {
//        return new ProductServiceImpl(productRepository);
//    }
//
//    @Bean
////    @Scope(value="Singleton")
//    public UserProductInfoService userProductInfoService() {
//        return new UserProductInfoServiceImpl(userProductInfoRepository);
//    }
//
//    @Bean
////    @Scope(value="Singleton")
//    public UserService userService() {
//        return new UserServiceImpl(userRepository);
//    }

//}
