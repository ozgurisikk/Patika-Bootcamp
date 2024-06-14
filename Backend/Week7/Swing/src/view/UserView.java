package view;

import business.UserController;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserView extends JFrame{
    private JPanel container;
    private JTabbedPane tab_menu;
    private JPanel pnl_user;
    private JTable tbl_user;
    private JScrollPane scrl_user;
    private JButton btn_user_new;
    private JPanel pnl_test;
    private UserController userController;
    private DefaultTableModel mdl_user;
    private JPopupMenu user_popup;



    public UserView(){
        this.add(container);
        this.setTitle("Admin Dashboard");
        this.setSize(500,500);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2 ;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2 ;

        this.setLocation(x, y);
        this.setVisible(true);

        this.userController = new UserController();
        this.mdl_user = new DefaultTableModel();
        this.user_popup = new JPopupMenu();
        //TableModel
        //Kolon basliklarini olustur
        //Modele satirlari aktar

        Object[] columnUser = {"ID", "Ad", "Tip", "Cinsiyet", "Mail", "Sifre"};
        this.mdl_user.setColumnIdentifiers(columnUser);
        ArrayList<User> users = this.userController.findAll();
        for (User user : users){
            Object[] row = {
                    user.getId(), //burda yukaridaki columnUser a gore siralamasini yapmak gerek
                    user.getName(),
                    user.getType(),
                    user.getGender(),
                    user.getMail(),
                    user.getPassword()
            };
            this.mdl_user.addRow(row);
        }

        //modeli sinif icindeki JTable sinifinin tablosuna ata

        this.tbl_user.setModel(this.mdl_user);
        this.tbl_user.setEnabled(false); //tablonun duzenlenebilir olmasini engeller, tabloya cift tiklayarak duzenlenmesini engeller
        this.tbl_user.getTableHeader().setReorderingAllowed(false); // tablonun columnlarini genisletip kucultmeyi engeller

        this.tbl_user.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            int selectedRow = tbl_user.rowAtPoint(e.getPoint());
            tbl_user.setRowSelectionInterval(selectedRow, selectedRow);

            }
        });

        this.user_popup.add("Guncelle").addActionListener(e -> {
            int selectedID = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow(), 0).toString());
            User selectedUser = this.userController.getByID(selectedID);
            EditView editView = new EditView(selectedUser);
        });
        this.user_popup.add("Sil").addActionListener(e -> {
            int selectedID = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow(), 0).toString());
             User selectedUser = this.userController.getByID(selectedID);
            DeleteView deleteView = new DeleteView(selectedUser);
        });
        this.tbl_user.setComponentPopupMenu(user_popup);

        btn_user_new.addActionListener(e -> {
            EditView editView = new EditView(new User());

        });
    }
}
