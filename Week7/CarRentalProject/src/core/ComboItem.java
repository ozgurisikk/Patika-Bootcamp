package core;

import entity.Brand;
import entity.Model;

import java.util.Date;

public class ComboItem {
    private int key;
    private String value;

    public ComboItem(int key, String value){
        this.key = key;
        this.value = value;
    }
    public ComboItem(int id, String plate, Brand brand, Model model, String name, String mpno , String mail, String tcno, Date strt, Date fnsh , int prc){

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
