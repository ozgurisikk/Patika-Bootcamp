public class Main {
    public static void main(String[] args) {

        //Creating objects from classes
        Employee kemal = new Employee("Kemal", 2000, 45, 1985);

        Employee ogulcan = new Employee("Ogulcan", 3000, 50, 2010);

        Employee basic = new Employee("Deneme", 900, 38, 2020);

        //Printing all the details
        System.out.println(kemal.toString());
    }
}
