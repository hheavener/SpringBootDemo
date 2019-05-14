package mvc_demo.repositories;

import mvc_demo.model.UserProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductInfoRepository extends JpaRepository<UserProductInfo, String> {
    List<UserProductInfo> findAllByKey_UserID(String u_id);
    UserProductInfo findByKey_UserIDAndKey_ProductID(String user_id, String product_id);
    void deleteByKey_UserIDAndAndKey_ProductID(String user_id, String product_id);
}
