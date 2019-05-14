package mvc_demo.services.implementation;

import mvc_demo.repositories.UserRepository;
import mvc_demo.model.User;
import mvc_demo.model.UserProductInfo;
import mvc_demo.services.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

    //========== Repository reference / constructor ==========//
    private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository) {this.userRepository = userRepository;}



    //========== For accessing UserService statically ==========//
    private static UserService instance;

    @Override
    public void afterPropertiesSet() throws Exception { instance = this; }

    public static UserService getInstance() { return instance; }



    //========== Service methods ==========//
    @Override
    public User getUserById(String id) { return userRepository.findUserById(id); }

    @Override
    public User getUserByEmail(String email) { return userRepository.findUserByEmail(email); }

    @Override
    public List<UserProductInfo> getUserItemsById(String id) { return UserProductInfoServiceImpl.getInstance().getUserProductInfosByUserId(id); }

    @Override
    public boolean emailInUse(String email) { return userRepository.existsByEmail(email); }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean validateUser(String email, String password) { return userRepository.existsByEmailAndAndPassword(email, password); }
}
