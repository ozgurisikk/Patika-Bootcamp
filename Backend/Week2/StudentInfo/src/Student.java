public class Student {
    Course c1;
    Course c2;
    Course c3;

    String name;
    String stuNo;
    String classes;
    double average;
    boolean isPass;

    Student(String name, String stuNo, String classes, Course c1, Course c2, Course c3){

        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.average = 0.0;
        this.isPass = false;

    }

    void addBulkExamNote(int note1, int note2, int note3){
        if (note1 >= 0 && note1 <= 100){
            this.c1.note = note1;
        }
        if (note2 >= 0 && note2 <= 100){
            this.c2.note = note2;
        }
        if (note3 >= 0 && note3 <= 100){
            this.c3.note = note3;
        }
    }

    void isPass(){
        this.average = (this.c1.note + this.c2.note + this.c3.note) / 3.0;
        if (this.average >= 55){
            System.out.println("Gectiniz!");
            this.isPass = true;
        }else{
            System.out.println("Kaldiniz!");
            this.isPass = false;
        }
        printNote();
    }

    void printNote(){
        System.out.println(this.c1.name + "Notu\t:" + this.c1.note);
        System.out.println(this.c2.name + "Notu\t:" + this.c2.note);
        System.out.println(this.c3.name + "Notu:" + this.c3.note);
        System.out.println("Ortalamaniz : " + this.average);
    }
}
