package mvc_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HomeController.BASE_URL)
public class HomeController {

    public static final String BASE_URL = "/";

    @GetMapping
    public String sendToHomePage() {
        return "index";
    }

}
