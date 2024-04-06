package view;

import business.UserController;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteView extends JFrame {


    private User user;
    private  UserController userController;
    private JPanel container;
    private JTextField dlt_textfield;
    private JLabel dlt_label;
    private JRadioButton dlt_rdbutton;
    private JButton dlt_button;

    public DeleteView(User user){
        this.add(container);
        this.setTitle("Kullanici Sil");
        this.setSize(300, 155);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;

        this.setLocation(x, y);
        this.setVisible(true);

        this.user = user;
        this.userController = new UserController();

        dlt_rdbutton.addActionListener(e -> {
            if (this.dlt_rdbutton.isSelected()) {
                this.dlt_button.setEnabled(true);
            } else {
                this.dlt_button.setEnabled(false);
            }
        });



        dlt_button.addActionListener(e -> {
            if (this.userController.delete(user)){
                JOptionPane.showMessageDialog(null, "Silindi", "Basarili", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        });

    }
}
