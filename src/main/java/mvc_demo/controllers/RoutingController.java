package mvc_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RoutingController {

    @GetMapping("/about")
    public String goToAboutPage() {
        return "about";
    }

    @GetMapping("/mysaved")
    public String saved() {
        return "mysaved";
    }

    @GetMapping("/myratings")
    public String ratings() {
        return "myratings";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

}
