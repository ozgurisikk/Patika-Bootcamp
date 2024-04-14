package business;

import dao.UserDao;
import entity.User;

import java.awt.*;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }
    public User findByLogin(String username, String password){
        // farkli islemler burda da yapilabilir
        return this.userDao.findByLogin(username,password);
    }
}
