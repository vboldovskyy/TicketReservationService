package user;

import java.util.HashMap;
import java.util.Map;

public class UserHolder {
    static Map<String, IUser> users = new HashMap<>();
    static{
        users.put("vlad@gmail.com", new User("Vlad", "Boldovskyy", 32, "vlad@gmail.com",
                "123-456-7890", false));
        users.put("lena@gmail.com", new User("Lena", "Golovach", 26, "lena@gmail.com",
                "124-453-7123",false));
        users.put("sveta@gmail.com", new User("Sveta", "Telegina", 19, "sveta@gmail.com",
                "124-453-7123", true));
    }

    public static boolean addUser(User user){
        users.put(user.getEmail(), user);
        return true;
    }
    public static IUser getUser(String email){
        return users.get(email);
    }
}
