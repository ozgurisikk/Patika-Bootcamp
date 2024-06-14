import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_book")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int id;

    @Column(name = "borrow_name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "retrun_date")
    private LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrow_book_id",referencedColumnName = "book_id")
    private Book book;
    public BorrowBook() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
