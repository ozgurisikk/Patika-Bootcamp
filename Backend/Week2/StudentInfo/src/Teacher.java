public class Teacher {
    String name;
    String phone;
    String branch;

    Teacher(String name, String branch, String phone){
        this.name = name;
        this.phone = phone;
        this.branch = branch;

    }
    void print(){
        System.out.println("Ogretmen Adi: " + this.name);
        System.out.println("Ogretmen Telefonu: " + this.phone);
        System.out.println("Bolumu: " + this.branch);
    }

}
