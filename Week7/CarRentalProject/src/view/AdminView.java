package view;

import business.BookManager;
import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_rented_cars;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_brand;
    private JTable tbl_model;
    private JTable tbl_car;
    private JButton btn_s_search;
    private JLabel lbl_s_model_brand;
    private JLabel lbl_s_model_type;
    private JLabel lbl_s_model_fuel;
    private JLabel lbl_s_model_gear;
    private JComboBox cmb_s_model_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_s_clear;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private JLabel lbl_car_id;
    private JLabel lbl_car_brand;
    private JLabel lbl_car_model;
    private JLabel lbl_car_plate;
    private JLabel lbl_car_color;
    private JLabel lbl_car_km;
    private JLabel lbl_car_year;
    private JLabel lbl_car_type;
    private JLabel lbl_car_fuel;
    private JLabel lbl_car_gear;
    private JPanel pnl_booking;
    private JTable tbl_booking;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JComboBox cmb_booking_gear;
    private JComboBox cmb_booking_fuel;
    private JComboBox cmb_booking_type;
    private JButton btn_booking_search;
    private JLabel lbl_book_start;
    private JLabel lbl_book_finish;
    private JLabel lbl_book_gear;
    private JLabel lbl_book_fuel;
    private JLabel lbl_book_type;
    private JScrollPane scrl_booking;
    private JButton btn_booking_clear;
    private JTable tbl_rented_cars;
    private JScrollPane scrl_rntd_cars;
    private JLabel lbl_rent_plate;
    private JComboBox cmb_rented_plate;
    private JButton btn_rent_search;
    private JButton btn_rent_reset;
    private JPanel pbl_rental;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel(); //tablolar uzerinde islem yapabilmek icin modele ihtiyacimiz var
    private DefaultTableModel tmdl_model = new DefaultTableModel(); //tablolar uzerinde islem yapabilmek icin modele ihtiyacimiz var
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private DefaultTableModel tmdl_booking = new DefaultTableModel();
    private DefaultTableModel tmdl_rentals = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private BookManager bookManager;
    private CarManager carManager;
    private JPopupMenu brand_Menu;
    private JPopupMenu model_Menu;
    private Object[] col_model;
    private JPopupMenu car_menu;
    private JPopupMenu booking_menu;
    private Object[] col_car;
    private Object[] col_rental;
    private JPopupMenu rental_menu;


    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.carManager = new CarManager();
        this.bookManager = new BookManager();
        this.user = user;
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitialize(1000, 500);

        if (this.user == null) {
            dispose();
        }
        this.lbl_welcome.setText("Hosgeldiniz " + user.getUsername().toUpperCase());

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();

        loadRentalsTable(null);
        loadRentalComponent();



    }

    public void loadRentalsTable(ArrayList<Object[]> rentalList) {
        this.col_rental = new Object[]{"ID", "Plaka", "Marka", "Model", "Ad Soyad", "Telefon", "Mail", "T.C Kimlik No", "Başlama Tarihi", "Bitiş Tarihi", "Kiralama Bedeli"};
        if (rentalList == null) {
            try {
                rentalList = this.bookManager.getForTable(this.col_rental.length, this.bookManager.findAll());

            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("deneme");
            }
        }
        createTable(this.tmdl_rentals, this.tbl_rented_cars, this.col_rental, rentalList);
    }

    public void loadRentalComponent() {
        this.tableRowSelect(this.tbl_rented_cars);

        this.rental_menu = new JPopupMenu();
        this.rental_menu.add("Iptal Et").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectedRentId = this.getTableSelectedRow(tbl_rented_cars, 0);
                if (this.bookManager.delete(selectedRentId)) {
                    Helper.showMsg("done");
                    loadRentalsTable(null);
                    loadModelTable(null);
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_rented_cars.setComponentPopupMenu(this.rental_menu);




        this.btn_rent_search.addActionListener(e -> {
            if (this.cmb_rented_plate.getSelectedItem() != null){
                ComboItem selectedRent = (ComboItem) this.cmb_rented_plate.getSelectedItem();
                int plateCarId = 0;
                if (selectedRent != null){
                    plateCarId = selectedRent.getKey();
                }
                ArrayList<Book> rentalListSearch = this.bookManager.searcForTable(plateCarId);
                ArrayList<Object[]> modelRowListBySearch = this.bookManager.getForTable(this.col_rental.length, rentalListSearch);
                loadRentalsTable(modelRowListBySearch);
            }
        });

        this.btn_rent_reset.addActionListener(e -> {
            this.cmb_rented_plate.setSelectedItem(null);
            loadRentalsTable(null);
        });
    }

    public void loadCarComponent() {
        tableRowSelect(this.tbl_car);
        this.car_menu = new JPopupMenu();
        this.car_menu.add("Yeni").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Guncelle").addActionListener(e -> {
            int selectedCarId = this.getTableSelectedRow(tbl_car, 0);
            CarView carView = new CarView(this.carManager.getById(selectedCarId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.delete(selectCarId)) {
                    Helper.showMsg("done");
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_menu);
    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);
        this.model_Menu = new JPopupMenu();
        this.model_Menu.add("Yeni").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_Menu.add("Guncelle").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadCarTable();
                }
            });
        });
        this.model_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.delete(selectModelId)) {
                    Helper.showMsg("done");
                    loadModelTable(null);
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }

        });
        this.tbl_model.setComponentPopupMenu(model_Menu);

        this.btn_s_search.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );

            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        this.btn_s_clear.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            loadModelTable(null);
        });
    }

    public void loadBrandComponent() {
        tableRowSelect(this.tbl_brand);

        this.brand_Menu = new JPopupMenu();
        this.brand_Menu.add("Yeni").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_Menu.add("Guncelle").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                }
            });
        });
        this.brand_Menu.add("Sil").addActionListener(e -> {

            if (Helper.confirm("sure")) {
                int selectedBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if (this.brandManager.delete(selectedBrandId)) {
                    Helper.showMsg("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_brand.setComponentPopupMenu(brand_Menu);
    }
    public void loadBookingComponent() {
        tableRowSelect(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Rezervasyon Yap").addActionListener(e -> {
            int selectCarId = this.getTableSelectedRow(this.tbl_booking, 0);
            BookingView bookingView = new BookingView(this.carManager.getById(selectCarId), this.fld_strt_date.getText(), this.fld_fnsh_date.getText());
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                    loadRentalsTable(null);
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);

        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );
            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length, carList);
            loadBookingTable(carBookingRow);
        });
        btn_booking_clear.addActionListener(e -> {
            loadBookingFilter();
        });
    }
    public void loadBookingTable(ArrayList<Object[]> carList) {
        Object[] col_booking_list = {"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yil", "Tip", "Yakit Turu", "Vites"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);
    }
    public void loadCarTable() {
        col_car = new Object[]{"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yil", "Tip", "Yakit Turu", "Vites"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
        createTable(this.tmdl_car, this.tbl_car, col_car, carList);
    }
    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID", "Marka", "Model Adi", "Tip", "Yil", "Vites", "Yakit Turu"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(this.col_model.length, this.modelManager.findAll());
        }
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);
    }
    public void loadBrandTable() {
        Object[] col_brand = {"Marka ID", "Marka Adi"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);
    }
    public void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();
    }
    public void loadBookingFilter() {
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);
    }
    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }
    public void loadRentalPlateFilter(){
        for (Car obj : this.carManager.findPlateList()){

        }
    }

    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_strt_date.setText("16/10/2024");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_fnsh_date.setText("20/10/2024");

    }
}
