package view;

import business.BrandManager;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout{

    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;
    private BrandManager brandManager;
    public BrandView(Brand brand){
        this.brand = brand;
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitialize(300,300);

        if (this.fld_brand_name != null){
            this.fld_brand_name.setText(fld_brand_name.getText());
        }

        btn_brand_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_brand_name)) {
                Helper.showMsg("fill");
            }else {
                boolean result;
                if (this.brand == null){
                    result = this.brandManager.save(new Brand(fld_brand_name.getText()));
                }else{
                    this.brand.setName(fld_brand_name.getText());
                    result = this.brandManager.update(this.brand);
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
