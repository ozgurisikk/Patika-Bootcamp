package entity;

import core.ComboItem;
import org.omg.CORBA.PRIVATE_MEMBER;

public class Model {
    private int id;
    private int brand_id;
    private Type type;
    private Gear gear;
    private Fuel fuel;
    private String name;
    private String year;
    private Brand brand;
    public enum Fuel{
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }

    public enum Gear{
        MANUEL,
        AUTO
    }
    public enum Type{
        SEDAN,
        HATCHBACK
    }
    public Model(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", brand_id=" + brand_id +
                ", type=" + type +
                ", gear=" + gear +
                ", fuel=" + fuel +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", brand=" + brand +
                '}';
    }
    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getBrand().getName() + " - " + this.getName() + " - " + this.getYear() + " - " + this.getGear());
    }
}
