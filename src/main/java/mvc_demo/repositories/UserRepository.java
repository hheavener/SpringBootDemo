package mvc_demo.repositories;

import mvc_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean findByEmailAndAndPassword(String email, String password);

    boolean existsByEmail(String email);

    boolean existsByEmailAndAndPassword(String email, String password);

    User findUserByEmail(String email);

    User findUserById(String id);

}
