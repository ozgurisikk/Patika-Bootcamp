import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.*;

public class PatikaStore {

    private List<Brand> brands;
    private List<Phone> phones;
    private List<NoteBook> noteBooks;

    public PatikaStore() {
        this.brands = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.noteBooks = new ArrayList<>();

        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
        brands.sort(Comparator.comparing(Brand::getName));
    }


    public void notebookOptions() {
        Scanner input = new Scanner(System.in);
        int select;

        do {

            System.out.println("1- Add a new Notebook");
            System.out.println("2- Remove a Notebook from list");
            System.out.println("3- List all the Notebooks");
            System.out.println("0- Previous Menu");
            System.out.println("--------------------");
            System.out.print("Choose an option to operate: ");
            select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    addNotebookText();
                    break;
                case 2:
                    deleteNotebook();
                    break;
                case 3:
                    urunListeleNotebook();
                    break;
                case 0:
                    System.out.println("Leaving notebook options...");
                    break;
                default:
                    System.out.println("Enter a valid value");
                    break;
            }
        } while (select != 0);
    }

    public void phoneOptions() {
        Scanner input = new Scanner(System.in);
        int select;

        do {
            System.out.println("1- Add a new Phone");
            System.out.println("2- Remove a Phone from list");
            System.out.println("3- List all the Phone");
            System.out.println("0- Previous Menu");
            System.out.println("--------------------");
            System.out.print("Choose an option to operate: ");

            select = input.nextInt();
            input.nextLine();

            switch (select) {
                case 1:
                    addPhoneText();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    urunListelePhone();
                    break;
                case 0:
                    System.out.println("Leaving phone options...");
                    break;
                default:
                    System.out.println("Enter a valid value");
                    break;
            }
        } while (select != 0);
    }


    public void addNotebookText() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter model name: ");
        String modelName = input.nextLine();
        System.out.print("Enter a price: ");
        int price = input.nextInt();
        System.out.print("Enter a discount: ");
        int discount = input.nextInt();
        System.out.print("Enter stock: ");
        int stock = input.nextInt();
        System.out.print("Enter Brand ID: ");
        int brandID = input.nextInt();
        System.out.print("Enter storage value:");
        int storage = input.nextInt();
        System.out.print("Enter screen inch size: ");
        int screenSize = input.nextInt();
        System.out.print("Enter memory: ");
        int memory = input.nextInt();
        input.nextLine();

        Brand objBrand = getBrandByID(brandID);

        if (objBrand != null) {
            NoteBook notebook = new NoteBook(modelName, price, discount, stock, objBrand, storage, screenSize, memory);
            notebookAdd(notebook);

        } else {
            System.out.println("Brand not found");
        }


    }

    public Brand getBrandByID(int id) {
        for (Brand gez : brands) {
            if (gez.getID() == id) {
                return gez;
            }
        }
        return null;
    }

    public void notebookAdd(NoteBook notebook) {
        if (notebook instanceof NoteBook) {
            for (Brand gez : brands) {
                if (notebook.getBrand().getName().equals(gez.getName())) {
                    noteBooks.add(notebook);
                    System.out.println("Product added!");
                    System.out.println("--------------");
                    return;
                }
            }
            System.out.println("Brand not found!");
        }
    }

    public void addPhoneText() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter model name: ");
        String modelName = input.nextLine();
        System.out.print("Enter a price: ");
        int price = input.nextInt();
        System.out.print("Enter a discount: ");
        int discount = input.nextInt();
        System.out.print("Enter stock: ");
        int stock = input.nextInt();
        System.out.print("Enter Brand ID: ");
        int brandID = input.nextInt();
        System.out.print("Enter storage value:");
        int storage = input.nextInt();
        System.out.print("Enter screen inch size: ");
        int screenSize = input.nextInt();
        System.out.print("Enter memory: ");
        int memory = input.nextInt();
        System.out.print("Enter battery: ");
        int battery = input.nextInt();
        input.nextLine();
        System.out.print("Enter color: ");
        String color = input.nextLine();
        System.out.print("Enter camera pixel: ");
        int camera = input.nextInt();
        input.nextLine();

        Brand objBrand = getBrandByID(brandID);

        if (objBrand != null) {
            Phone phone = new Phone(modelName, price, discount, stock, objBrand, storage, screenSize, memory, battery, color, camera);
            phoneAdd(phone);

        } else {
            System.out.println("Brand not found");
        }

    }

    public void phoneAdd(Phone phone) {
        if (phone instanceof Phone) {
            for (Brand gez : brands) {
                if (phone.getBrand().getName().equals(gez.getName())) {
                    phones.add(phone);
                    System.out.println("Product added!");
                    System.out.println("--------------");
                    return;
                }
            }
            System.out.println("Brand not found!");
        }
    }

    public void listOfBrands() {

        for (Brand brand : brands) {
            System.out.println("ID: " + brand.getID() + " | | " + "Name: " + brand.getName());
        }
    }

    public void urunListeleNotebook() {
        System.out.println("Notebook List");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Name                          | Price       | Brand        | Storage    | Screen Size | Memory       |");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (NoteBook urun : noteBooks) {
            System.out.format("| %-2d | %-30s | %-9d TL | %-12s | %-10d GB | %-10d inch | %-12d GB |\n",
                    urun.getID(),
                    urun.getModelName(),
                    urun.getPrice(),
                    urun.getBrand().getName(),
                    urun.getStorage(),
                    urun.getScreenSize(),
                    urun.getMemory());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }


    public void urunListelePhone() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Name                          | Price       | Brand        | Storage    | Screen Size | Camera    | Battery      | RAM        | Color      |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone urun : phones) {
            System.out.format("| %-2d | %-30s | %-9d TL | %-12s | %-10d GB | %-10d inch | %-9d MP | %-11d mAh | %-10d GB | %-10s |\n",
                    urun.getID(),
                    urun.getModelName(),
                    urun.getPrice(),
                    urun.getBrand().getName(),
                    urun.getStorage(),
                    urun.getScreenSize(),
                    urun.getCamera(),
                    urun.getBattery(),
                    urun.getMemory(),
                    urun.getColor());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");


    }

    public void deleteNotebook(){
        Scanner input = new Scanner(System.in);
        urunListeleNotebook();
        System.out.println("------------------------------------------------------");
        System.out.print("Choose the notebook ID that you would like to delete: ");
        int choiceID = input.nextInt();
        Iterator<NoteBook> iterator = noteBooks.iterator();
        while(iterator.hasNext()){
            NoteBook notebook = iterator.next();
            if (notebook.getID() == choiceID){
                iterator.remove();
                System.out.println("Notebook succesfully removed from list !");

            }
        }
    }
    public void deletePhone(){
        Scanner input = new Scanner(System.in);
        urunListelePhone();
        System.out.println("------------------------------------------------------");
        System.out.print("Choose the phone ID that you would like to delete: ");
        int choiceID = input.nextInt();
        Iterator<Phone> iterator = phones.iterator();
        while(iterator.hasNext()){
            Phone phone = iterator.next();
            if (phone.getID() == choiceID){
                iterator.remove();
                System.out.println("Phone succesfully removed from list !");
            }
        }
    }

}

