package mvc_demo.services.implementation;

import mvc_demo.repositories.UserProductInfoRepository;
import mvc_demo.model.UserProductInfo;
import mvc_demo.services.service.UserProductInfoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductInfoServiceImpl implements UserProductInfoService, InitializingBean {

    //========== Repository reference / constructor ==========//
    private final UserProductInfoRepository userProductInfoRepository;

    public UserProductInfoServiceImpl(UserProductInfoRepository userProductInfoRepository) {this.userProductInfoRepository = userProductInfoRepository;}



    //========== For accessing UserProductInfoService statically ==========//
    private static UserProductInfoService instance;

    @Override
    public void afterPropertiesSet() throws Exception { instance = this; }

    public static UserProductInfoService getInstance(){
        return instance;
    }



    //========== Service methods ==========//
    @Override
    public List<UserProductInfo> getUserProductInfosByUserId(String id) {
        return userProductInfoRepository.findAllByKey_UserID(id);
    }

    @Override
    public UserProductInfo getUserProductInfoByKey(String user_id, String prod_id) {
        return userProductInfoRepository.findByKey_UserIDAndKey_ProductID(user_id, prod_id);
    }

    @Override
    public void deleteUserProductInfo(String user_id, String prod_id) {
        userProductInfoRepository.deleteByKey_UserIDAndAndKey_ProductID(user_id, prod_id);
    }

    @Override
    public UserProductInfo updateRating(UserProductInfo upi) {
        return userProductInfoRepository.save(upi);
    }


}