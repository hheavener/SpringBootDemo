package mvc_demo.util;

import mvc_demo.services.service.UserService;

public class IdGenerator {

    public static String getUniqueId(UserService userService){
        //Generate random UserID and check it against other users in DB
        int random = (int) (Math.random() * 1000000000);
        while (userService.getUserById(Integer.toString(random)) != null)
            random = (int) (Math.random() * 1000000000);

        String id = String.format("%09d", random);
        return id;
    }
}
