package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel wrapper_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcomee;
    private JPanel wrappet_bottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserManager userManager;

    public LoginView() {
        this.userManager = new UserManager();
        this.add(container);
        guiInitialize(300, 500);


        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_username) || Helper.isFieldEmpty(this.fld_password)) {
                Helper.showMsg("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_password.getText());
                if (loginUser == null) {
                    Helper.showMsg("notFound");
                } else {
                    AdminView adminView = new AdminView(loginUser);
                    dispose();
                }
            }
        });
    }
}
