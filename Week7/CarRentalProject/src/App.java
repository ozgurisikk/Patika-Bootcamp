import core.Db;
import core.Helper;
import view.AdminView;
import view.LoginView;

import javax.swing.*;
import java.sql.Connection;


public class App {
    public static void main(String[] args) {
        //DAO data access object sinifi
        //entity veri tabanindan cektigimiz verileri entitiesde modele aktaricaz
        //business
        //view
        //core sistemle alakali cekirdek islemleri yapicaz veri tabani baglantisi, helper vs

        Helper.setTheme();

        LoginView loginView = new LoginView();

    }
}
