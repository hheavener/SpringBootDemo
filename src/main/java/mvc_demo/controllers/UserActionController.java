package mvc_demo.controllers;

import lombok.AllArgsConstructor;
import mvc_demo.model.User;
import mvc_demo.model.UserProductInfo;
import mvc_demo.services.service.ProductService;
import mvc_demo.services.service.UserProductInfoService;
import mvc_demo.services.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class UserActionController extends HttpServlet {

    private ProductService productService;
    private UserProductInfoService userProductInfoService;
    private UserService userService;


    //========== SAVE/UPDATE RATING ==========//
    @GetMapping("/mysaved/{id}/feedback")
    public String toFeedbackPageFromMySaved(@PathVariable String id, Model model) {
        if (productService.getProductById(id) != null) {
            model.addAttribute("product", productService.getProductById(id));
            model.addAttribute("referer", "mysaved");
            return "feedback";
        } else {
            return "redirect:/mysaved";
        }
    }

    @GetMapping("/myratings/{id}/feedback")
    public String toFeedbackPageFromMyRatings(@PathVariable String id, Model model) {
        if (productService.getProductById(id) != null) {
            model.addAttribute("product", productService.getProductById(id));
            model.addAttribute("referer", "myratings");
            return "feedback";
        } else {
            return "redirect:/myratings";
        }
    }

    @PostMapping("/catalog/{id}/feedback")
    public String updateRating(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Get the rating from the request parameters
        int rating = Integer.parseInt(request.getParameter("rating"));

        // Get the UserProductInfo and change the rating
        UserProductInfo upi = user.getUserProductInfoById(id);

        // If the user already has the item rated/saved, update the rating
        if (upi != null) {
            upi.setRating(rating);
        // Otherwise, create a new UserProductInfo object and add it to their profile
        } else {
            upi = new UserProductInfo(user.getId(), id, rating, false);
            user.addUserProductInfo(upi);
        }

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // If the user came from a view other than the product view
        String referer = request.getParameter("referer");
        if (referer != null) {
            if (referer.contains("mysaved")) referer = "mysaved";
            else if (referer.contains("myratings")) referer = "myratings";
            // In case a value other than the above two was passed in, force referer to null
            else referer = null;
        }

        // Redirect back to the referer page or product page
        if (referer != null) return "redirect:/" + referer;
        else return "redirect:/catalog/" + id;
    }


    //========== SAVE PRODUCT ==========//
    @GetMapping("/myratings/{id}/save")
    public String saveProduct(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Create a new UserProductInfo and add it to the user's list
        UserProductInfo upi = new UserProductInfo(user.getId(), id, 0, true);
        user.addUserProductInfo(upi);

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // Redirect to the saved products page
        return "redirect:/mysaved";
    }

    @GetMapping("/catalog/{id}/save")
    public String saveProductAndViewProduct(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Create a new UserProductInfo and add it to the user's list
        UserProductInfo upi = new UserProductInfo(user.getId(), id, 0, true);
        user.addUserProductInfo(upi);

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // Redirect to the saved products page
        return "redirect:/catalog/" + id;
    }


    //========== DELETE SAVED ==========//
    @GetMapping("/catalog/{id}/delete")
    public String setSaveToFalseAndViewProduct(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Create a new UserProductInfo and add it to the user's list
        UserProductInfo upi = user.getUserProductInfoById(id);
        upi.setSaved(false);

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // Redirect to the saved products page
        return "redirect:/catalog/" + id;
    }

    @GetMapping("/mysaved/{id}/delete")
    public String setSaveToFalse(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Create a new UserProductInfo and add it to the user's list
        UserProductInfo upi = user.getUserProductInfoById(id);
        upi.setSaved(false);

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // Redirect to the saved products page
        return "redirect:/mysaved";
    }


    //========== DELETE RATING ==========//
    @GetMapping("/myratings/{id}/delete")
    public String deleteRating(@PathVariable String id, HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Create a new UserProductInfo and add it to the user's list
        UserProductInfo upi = user.getUserProductInfoById(id);
        upi.setRating(0);

        // Persist the data
        userProductInfoService.updateRating(upi);

        // Update the session info
        request.getSession().setAttribute("user", user);

        // Redirect to the saved products page
        return "redirect:/myratings";
    }


    //========== CHANGE INFO ==========//
    @PostMapping("/user_info")
    public String updateInfo(HttpServletRequest request) {
        // Get the User from the session
        User user = (User) request.getSession().getAttribute("user");

        // Set the new names
        user.setFirstName(request.getParameter("f_name"));
        user.setLastName(request.getParameter("l_name"));

        // Persist new names in session and DB
        request.getSession().setAttribute("user", user);
        userService.saveUser(user);

        // Get the email
        String email = request.getParameter("email");

        // If the user has changed the email and it is not available, display error
        if (!user.getEmail().equals(email) && userService.emailInUse(request.getParameter("email"))) {
            request.setAttribute("message", "Sorry, that email is already taken.");
            request.setAttribute("email", request.getParameter("email"));
            return "profile";
        }

        // Update the email and persist it in the session and DB
        else {
            user.setEmail(request.getParameter("email"));
            request.getSession().setAttribute("user", user);
            userService.saveUser(user);
            return "redirect:/profile";
        }
    }


}
