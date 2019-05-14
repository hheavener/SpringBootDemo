package mvc_demo.services.service;

import mvc_demo.model.UserProductInfo;

import java.util.List;

public interface UserProductInfoService {

    List<UserProductInfo> getUserProductInfosByUserId(String id);

    UserProductInfo getUserProductInfoByKey(String user_id, String prod_id);

    UserProductInfo updateRating(UserProductInfo upi);

    void deleteUserProductInfo(String user_id, String product_id);

}
