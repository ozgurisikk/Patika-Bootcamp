package view;

import business.BookManager;
import business.CarManager;
import core.Helper;
import entity.Book;
import entity.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BookingView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JLabel lbl_car_info;
    private JTextField fld_book_name;
    private JTextField fld_book_idno;
    private JTextField fld_book_mpno;
    private JTextField fld_book_mail;
    private JTextField fld_book_strt_date;
    private JTextField fld_book_fnsh_date;
    private JTextField fld_book_prc;
    private JButton btn_book_save;
    private JLabel lbl_book_name;
    private JLabel lbl_book_idno;
    private JLabel lbl_book_mpno;
    private JLabel lbl_book_mail;
    private JLabel lbl_book_strt_date;
    private JLabel lbl_book_fnsh_date;
    private JLabel lbl_book_prc;
    private JTextArea area_book_note;
    private JLabel lbl_book_note;
    private Car car;
    private BookManager bookManager;
    public BookingView(Car selectedCar, String strt_date, String fnsh_date){
        this.add(container);
        guiInitialize(300,700);
        this.bookManager = new BookManager();
        this.car = selectedCar;


        lbl_car_info.setText("Arac : " +
                this.car.getPlate() + " / " +
                this.car.getModel().getBrand().getName() + " / " +
                this.car.getModel().getName());

        this.fld_book_strt_date.setText(strt_date);
        this.fld_book_fnsh_date.setText(fnsh_date);

        //test
        this.fld_book_name.setText("Ozgur Isik");
        this.fld_book_idno.setText("3493240329");
        this.fld_book_mail.setText("test");
        this.fld_book_mpno.setText("9055394849");
        this.fld_book_prc.setText("3000");
        this.area_book_note.setText("Test notu");

        btn_book_save.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_book_name, this.fld_book_prc, this.fld_book_strt_date, this.fld_book_idno,
            this.fld_book_fnsh_date, this.fld_book_mail, this.fld_book_mpno};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else{
                Book book = new Book();
                book.setbCase("done");
                book.setCar_id(this.car.getId());
                book.setName(this.fld_book_name.getText());
                book.setStrt_date(LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setFnsh_date(LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setIdno(this.fld_book_idno.getText());
                book.setPrc(Integer.parseInt(this.fld_book_prc.getText()));
                book.setMail(this.fld_book_mail.getText());
                book.setMpno(this.fld_book_mpno.getText());
                book.setNote(this.area_book_note.getText());

                if (this.bookManager.save(book)){
                    Helper.showMsg("done");
                    dispose();
                }else {
                    Helper.showMsg("error");
                }
            }
        });
    }
}
