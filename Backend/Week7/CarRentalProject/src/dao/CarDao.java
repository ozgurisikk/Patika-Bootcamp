package dao;

import core.Db;
import entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class CarDao {
    private Connection con ;
    private final BrandDao brandDao;
    private final ModelDao modelDao;

    public CarDao(){
        this.con = Db.getInstance();
        this.brandDao = new BrandDao();
        this.modelDao = new ModelDao();
    }

    public Car getById(int id) {
        Car obj = null;
        String query = "SELECT * FROM public.car WHERE car_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public ArrayList<Car> selectByQuery(String query){
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()){
                cars.add(this.match(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cars;
    }
    public ArrayList<Car> findAll(){
        return  this.selectByQuery("SELECT * FROM public.car ORDER BY car_id ASC");
    }

    public Car match(ResultSet rs){
        Car obj = new Car();
        try {
            obj.setId(rs.getInt("car_id"));
            obj.setModel_id(rs.getInt("car_model_id"));
            obj.setPlate(rs.getString("car_plate"));
            obj.setColor(Car.Color.valueOf(rs.getString("car_color")));
            obj.setKm(rs.getInt("car_km"));
            obj.setModel(this.modelDao.getById(obj.getModel_id()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public boolean update(Car car){
        String query = "UPDATE public.car SET car_model_id = ? , car_color = ?, car_km = ? , car_plate = ? WHERE car_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, car.getModel_id());
            pr.setString(2, car.getColor().toString());
            pr.setInt(3, car.getKm());
            pr.setString(4, car.getPlate());
            pr.setInt(5, car.getId());

            return pr.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean save (Car car){
        String query = "INSERT INTO public.car (car_model_id, car_color, car_km, car_plate) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, car.getModel_id());
            pr.setString(2, car.getColor().toString());
            pr.setInt(3, car.getKm());
            pr.setString(4, car.getPlate());
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int car_id){
        String query = "DELETE FROM car WHERE car_id = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, car_id);
            return pr.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

        public List<Car> findPlateList(){
        List<Car> plateList = new ArrayList<>();
        Car obj = new Car();
        String query = "SELECT car_plate FROM public.car INNER JOIN public.book ON public.car.car_id = public.book.book_car_id";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                plateList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return plateList;
    }

}
