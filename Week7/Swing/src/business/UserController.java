package business;
import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserController {
    private UserDao userDao;

    public UserController(){
        this.userDao = new UserDao();
    }

    public ArrayList<User> findAll(){ // View Dao ile iletisime gecemiyor ve bu aradaki katman olusturularak aktariliyor
        return this.userDao.findAll();
    }

    public User getByID(int id){
        if (id == 0){
            System.out.println("Id 0 olamaz");
            return new User();
        }
        return this.userDao.getByID(id);
    }

    public boolean update(User user){ // bu bir is parcacigi oldugu icin boyle bi user var mi yok mu diye veritabanini sorguluyoruz once
        User checkUser = this.getByID(user.getId());
        if (checkUser == null || checkUser.getId() == 0){
            return false;
        }
        return this.userDao.update(user);
    }

    public boolean save(User user){
        return this.userDao.save(user);
    }

    public boolean delete(User user){
        return this.userDao.delete(user);
    }
}
