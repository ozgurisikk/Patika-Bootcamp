public class Book implements Comparable<Book>{
    private String bookName;
    private Integer bookPage;
    private String bookAuthor;
    private Integer bookYear;

    public Book(String bookName, Integer bookPage, String bookAuthor, Integer bookYear) {
        this.bookName = bookName;
        this.bookPage = bookPage;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    @Override
    public int compareTo(Book o) {
        return this.bookName.compareTo(o.getBookName());
    }

    public String getBookName() {
        return bookName;
    }

    public Integer getBookPage() {
        return bookPage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getBookYear() {
        return bookYear;
    }
}