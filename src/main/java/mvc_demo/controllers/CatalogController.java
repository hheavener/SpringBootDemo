package mvc_demo.controllers;

import lombok.AllArgsConstructor;
import mvc_demo.services.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(CatalogController.BASE_URL)
@AllArgsConstructor
public class CatalogController {

    private ProductService productService;

    public static final String BASE_URL = "/catalog";


    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", productService.getCategories());
        return "catalog";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        if (productService.getProductById(id) != null) {
            model.addAttribute("product", productService.getProductById(id));
            return "product";
        } else {
            return getAllProducts(model);
        }
    }

    @GetMapping("/{id}/feedback")
    public String getProductById(@PathVariable String id, Model model, HttpServletRequest request) {
        if (productService.getProductById(id) != null) {
            model.addAttribute("product", productService.getProductById(id));
            return "feedback";
        } else {
            return getAllProducts(model);
        }
    }



}

//============= Example of viewProduct method with referrer =============//
//    @GetMapping("/{id}")
//    public String viewProduct(@RequestHeader(value="referer") String referer, @PathVariable String id, Model model) {
//        Logger logger = LoggerFactory.getLogger(ProductController.class);
//        logger.info("//=== Request referer: " + referer);
//        if (productService.getProductById(id) != null) {
//            model.addAttribute("product", productService.getProductById(id));
//            return "product";
//        } else {
//            return getAllProducts(model);
//        }
//    }
