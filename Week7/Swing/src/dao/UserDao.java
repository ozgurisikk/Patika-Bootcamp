package dao;

import core.Database;
import entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
    private Connection connection;


    public UserDao(){
        this.connection = Database.connection();
        //Gelen verileri, User entity deki nesnelere aktaracak
        //Gelen verileri CRUD islemleriyle ekleme silme okuma guncelleme yapacak
    }

    public ArrayList<User> findAll(){
        ArrayList<User> users = new ArrayList<>();

        try{
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM public.user");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setMail(rs.getString("mail"));
                user.setPassword(rs.getString("password"));
                user.setType(User.Type.valueOf(rs.getString("type")));
                user.setGender(User.Gender.valueOf(rs.getString("gender")));

                users.add(user);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public User getByID(int id){
        User user = new User();
        String query = "SELECT * FROM public.user WHERE id = ?"; // soru isaretli querylerde prepared statement kullanilmali

        try {

            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1 , id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setMail(rs.getString("mail"));
                user.setPassword(rs.getString("password"));
                user.setType(User.Type.valueOf(rs.getString("type")));
                user.setGender(User.Gender.valueOf(rs.getString("gender")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean update(User user){
        String query = "UPDATE public.user SET name = ? , mail = ? , password = ? , type = ? , gender = ? WHERE id = ?";
        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, user.getName());
            pr.setString(2, user.getMail());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getType().toString());
            pr.setString(5, user.getGender().toString());
            pr.setInt(6, user.getId());
            return pr.executeUpdate() != -1;


        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean save(User user){
        String query = "INSERT INTO public.user (name,mail,password,type,gender) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, user.getName());
            pr.setString(2, user.getMail());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getType().toString());
            pr.setString(5, user.getGender().toString());

            return pr.executeUpdate() != -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(User user){
        String query = "DELETE FROM public.user WHERE id = ?";

        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, user.getId());
            return pr.executeUpdate() > 0;

        }catch (Exception e ){
            e.printStackTrace();
        }

        return false;
    }
}
