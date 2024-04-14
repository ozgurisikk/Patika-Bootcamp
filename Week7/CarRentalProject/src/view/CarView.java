package view;

import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Car;
import entity.Model;

import javax.swing.*;
import java.sql.PreparedStatement;

public class CarView extends Layout {

    private JPanel container;
    private JLabel lbl_car_welcome;
    private JComboBox cmb_car_model;
    private JComboBox cmb_car_color;
    private JTextField fld_car_km;
    private JTextField fld_car_plate;
    private JLabel lbl_car_model;
    private JLabel lbl_car_color;
    private JLabel lbl_car_km;
    private JLabel lbl_car_plate;
    private JButton btn_car_save;
    private Car car;
    private CarManager carManager;
    private ModelManager modelManager;

    public CarView(Car car){
        this.add(container);
        this.car = car;
        this.carManager = new CarManager();
        this.modelManager = new ModelManager();
        this.guiInitialize(300,400);

        this.cmb_car_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));
        for (Model model : this.modelManager.findAll()){
            this.cmb_car_model.addItem(model.getComboItem());
        }

        if (this.car.getId() != 0){
            ComboItem selectedItem  = car.getModel().getComboItem();
            this.cmb_car_model.getModel().setSelectedItem(selectedItem);
            this.cmb_car_color.getModel().setSelectedItem(car.getColor());
            this.fld_car_plate.setText(car.getPlate());
            this.fld_car_km.setText(Integer.toString(car.getKm()));
        }

        this.btn_car_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_car_km, this.fld_car_plate})){
                Helper.showMsg("fill");
            }else {
                boolean result;
                ComboItem selectedModel = (ComboItem) this.cmb_car_model.getSelectedItem();
                this.car.setModel_id(selectedModel.getKey());
                this.car.setColor((Car.Color) this.cmb_car_color.getSelectedItem());
                this.car.setPlate(this.fld_car_plate.getText());
                this.car.setKm(Integer.parseInt(this.fld_car_km.getText()));
                    if (this.car.getId() != 0 ){
                        result = this.carManager.update(this.car);
                    }else{
                        result = this.carManager.save(this.car);
                    }
                if (result){
                    Helper.showMsg("done");
                    dispose();
                }else{
                    Helper.showMsg("error");
                }
            }
        });

    }
}
