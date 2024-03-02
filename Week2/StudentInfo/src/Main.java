import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Teacher mahmut = new Teacher("Mahmut", "TRH", "489574");
        Teacher ali = new Teacher("Ali", "FZK", "000");
        Teacher veli = new Teacher("Veli", "BIO", "111");

        Course tarih = new Course("Tarih", "101", "TRH");
        tarih.addTeacher(mahmut);

        Course fizik = new Course("Fizik", "102", "FZK");
        fizik.addTeacher(ali);

        Course biyo = new Course("Biyoloji", "103", "BIO");
        biyo.addTeacher(veli);



        Student s1 = new Student("Saban", "123", "4. sinif", tarih, fizik, biyo);

        s1.addBulkExamNote(50,50,50);
        s1.isPass();


    }
}
