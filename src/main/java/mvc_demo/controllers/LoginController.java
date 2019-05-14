package mvc_demo.controllers;

import lombok.AllArgsConstructor;
import mvc_demo.model.User;
import mvc_demo.model.UserProductInfo;
import mvc_demo.services.implementation.UserProductInfoServiceImpl;
import mvc_demo.services.service.UserProductInfoService;
import mvc_demo.services.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;
    private UserProductInfoService userProductInfoService;

    //========== LOG IN ==========//
    private boolean login(HttpServletRequest request) {
        if (userService.validateUser(request.getParameter("email"), request.getParameter("password"))) {
            HttpSession session = request.getSession(true);
            User user = userService.getUserByEmail(request.getParameter("email"));
            user.setUserProductInfos((ArrayList<UserProductInfo>) userProductInfoService.getUserProductInfosByUserId(user.getId()));
            session.setAttribute("user", user);
            return true;
        } else {
            return false;
        }
    }

    private String error(HttpServletRequest request) {
        request.setAttribute("message", "Sorry, that email and password was not valid.");
        return "login";
    }

    //==== POST ====//
    @PostMapping("/login")
    private String defaultLogin(HttpServletRequest request, HttpSession session) {
        // Make sure the user is not already logged in
        if (session.getAttribute("user") != null) return "redirect:/mysaved";

        // If the login is successful
        else if (login(request)) {

            // See if there is a return url
            String returnUrl = (String) session.getAttribute("returnUrl");
            session.removeAttribute("returnUrl");

            // If there is, go there, if not go to profile page
            return returnUrl != null ? "redirect:/" + returnUrl : "redirect:/profile";
        }

        // If the login is not successful, return an error
        else return error(request);
    }

    //==== GET ====//
    @GetMapping("/login")
    private String loginPage(HttpSession session) {
        if (session.getAttribute("user") != null) return "redirect:/mysaved";
        else return "login";
    }

    @GetMapping("/login/{returnUrl}")
    private String loginAndReturnToPage(@PathVariable String returnUrl, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) return "redirect:/mysaved";
        else request.getSession().setAttribute("returnUrl", returnUrl);
        return "redirect:/login";
    }

    @GetMapping("/login/catalog/{productId}")
    private String loginAndViewProduct(@PathVariable String productId, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) return "redirect:/mysaved";
        else request.getSession().setAttribute("returnUrl", "catalog/" + productId);
        return "redirect:/login";
    }

    @GetMapping("/login/catalog/{productId}/feedback")
    private String loginAndViewProductFeedback(@PathVariable String productId, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) return "redirect:/mysaved";
        else request.getSession().setAttribute("returnUrl", "catalog/" + productId + "/feedback");
        return "redirect:/login";
    }



    //========== LOGOUT ==========//
    @GetMapping("/logout")
    private String logout(HttpSession session) {
        // do logout stuff
        if (session != null) session.invalidate();
        return "redirect:/";
    }
}
