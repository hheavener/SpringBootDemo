package mvc_demo.services.service;

import mvc_demo.model.User;
import mvc_demo.model.UserProductInfo;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    User getUserByEmail(String email);

    List<UserProductInfo> getUserItemsById(String id);

    boolean emailInUse(String email);

    List<User> getAllUsers();

    User saveUser(User user);

    boolean validateUser(String email, String password);

}
