package mvc_demo.controllers;

import lombok.AllArgsConstructor;
import mvc_demo.model.User;
import mvc_demo.services.service.UserService;
import mvc_demo.util.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;

    //========== LOG IN ==========//
    private boolean register(HttpServletRequest request) {

        // These will be returned to the user if registration fails
        request.setAttribute("f_name", request.getParameter("f_name"));
        request.setAttribute("l_name", request.getParameter("l_name"));
        request.setAttribute("email", request.getParameter("email"));

        // Make sure the email is not already in use
        if (userService.emailInUse(request.getParameter("email"))) {
            error(request, "Sorry, that email address in already in use.");
        }

        // Make sure the passwords are not mismatched
        else if (!request.getParameter("password").equals(request.getParameter("conf_pass"))) {
            error(request, "Passwords do not match.");
        }

        else {
            // Create a new User object
            User user = new User();
            user.setId(IdGenerator.getUniqueId(userService));
            user.setFirstName(request.getParameter("f_name"));
            user.setLastName(request.getParameter("l_name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));

            // Save the user to the database
            userService.saveUser(user);

            // Set the password to null for session purposes
            user.setPassword(null);

            // Create a new session and add the user to it
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            // Registration was successful
            return true;
        }

        // When the user registration fails
        return false;
    }

    public String error(HttpServletRequest request, String message) {
        request.setAttribute("message", message);
        return "registration";
    }


    @PostMapping("/register")
    private String defaultRegister (HttpServletRequest request, HttpSession session) {
        // Make sure the user is not already logged in
        if (session.getAttribute("user") != null) return "redirect:/mysaved";

        // If the registration is successful
        else if (register(request)) {

            // See if there is a return url
            String returnUrl = (String) session.getAttribute("returnUrl");
            session.removeAttribute("returnUrl");

            // If there is, go there, if not go to 'my saved' page
            return returnUrl != null ? "redirect:/" + returnUrl : "redirect:/mysaved";
        }

        // If the login is not successful, return an error
        else return "registration";
    }


    @GetMapping("/register")
    private String registerPage(HttpSession session) {
        // If user is not signed in, send to registration page, otherwise redirect to 'my saved'
        return session.getAttribute("user") != null ? "redirect:/mysaved" : "registration";
    }
}
