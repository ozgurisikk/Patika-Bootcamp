public class Phone extends Product {
    private int battery;
    private String color;
    private int camera;

    public Phone(String modelName, int price, int discount, int stock, Brand brand, int storage, int screenSize, int memory, int battery, String color,  int camera) {
        super(modelName, price, discount, stock, brand, storage, screenSize, memory);
        this.battery = battery;
        this.color = color;
        this.camera = camera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}
