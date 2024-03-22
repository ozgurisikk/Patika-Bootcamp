import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Wuthering Heights", 400, "Emily Bronte", 1970);
        Book b2 = new Book("Hard Times", 300, "Charles Dickens", 1960);
        Book b3 = new Book("Frenc Lieutenat's Women", 600, "Max", 1958);
        Book b4 = new Book("Erzincanin Yollari", 700, "Ogulcan Ozturk", 1972);
        Book b5 = new Book("Gypsy", 200, "Elliot", 1999);

        TreeSet<Book> bookSet= new TreeSet<>();
        bookSet.add(b1);
        bookSet.add(b2);
        bookSet.add(b3);
        bookSet.add(b4);
        bookSet.add(b5);

        System.out.println("Alphabetic sorted list: ");
        System.out.println(" ");

        for (Book gez : bookSet){System.out.println(gez.getBookName() + " - " + gez.getBookPage() + " - " + gez.getBookAuthor() + " -  " + gez.getBookYear());
        }

        System.out.println("-------------------------------------------------------------");

        TreeSet<Book> bookPageSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBookPage() - o2.getBookPage();
            }
        });
        bookPageSet.addAll(bookSet);
        System.out.println("Sorted to page number list: ");
        System.out.println(" ");
        for (Book gezTwo : bookPageSet){
            System.out.println(gezTwo.getBookName() + " - " + gezTwo.getBookPage() + " - " + gezTwo.getBookAuthor() + " - " + gezTwo.getBookYear());
        }


    }
}
