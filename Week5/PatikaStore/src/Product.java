public class Product {

    private static int idCounter = 1;
    private String modelName;
    private int ID;
    private int price;
    private int discount;
    private int stock;
    private Brand brand;
    private int storage;
    private int screenSize;
    private int memory;

    public Product(String modelName, int price, int discount, int stock, Brand brand, int storage, int screenSize, int memory) {

        this.modelName = modelName;
        this.ID = idCounter++;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.memory = memory;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getModelName() {
        return modelName;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getMemory() {
        return memory;
    }
}
