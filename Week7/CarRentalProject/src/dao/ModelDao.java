package dao;

import core.Db;
import entity.Brand;
import entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection con;
    private final BrandDao brandDao = new BrandDao();

    public ModelDao(){
        this.con = Db.getInstance();
    }
    public Model match(ResultSet rs){
        Model obj = new Model();
        try {
            obj.setId(rs.getInt("model_id"));
            obj.setBrand_id(rs.getInt("model_brand_id"));
            obj.setName(rs.getString("model_name"));
            obj.setType(Model.Type.valueOf(rs.getString("model_type")));
            obj.setGear(Model.Gear.valueOf(rs.getString("model_gear")));
            obj.setFuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
            obj.setYear(rs.getString("model_year"));
            obj.setBrand(this.brandDao.getById(rs.getInt("model_brand_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Model getById(int id) {
        Model obj = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
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

    public ArrayList<Model> getByListBrandId(int brandId){
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    }

    public ArrayList<Model> selectByQuery(String query){
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()){
                modelList.add(this.match(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return modelList;
    }
    public ArrayList<Model> findAll(){
        return  selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }
    public boolean save (Model model){
        String query = "INSERT INTO public.model (model_brand_id, model_type, model_gear, model_fuel, model_name, model_year) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, model.getBrand_id());
            pr.setString(2, model.getType().toString());
            pr.setString(3,model.getGear().toString());
            pr.setString(4, model.getFuel().toString());
            pr.setString(5, model.getName());
            pr.setString(6, model.getYear());
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Model model){
        String query = "UPDATE public.model SET model_brand_id = ? , model_name = ? , model_type = ? , model_gear = ? , model_fuel = ? , model_year = ? WHERE model_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, model.getBrand_id());
            pr.setString(2, model.getName());
            pr.setString(3,model.getType().toString());
            pr.setString(4, model.getGear().toString());
            pr.setString(5, model.getFuel().toString());
            pr.setString(6, model.getYear());
            pr.setInt(7, model.getId());
            return pr.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int model_id){
        String query = "DELETE FROM model WHERE model_id = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, model_id);
            return pr.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }


}
