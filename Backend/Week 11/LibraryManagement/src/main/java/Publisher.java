import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

    @Column(name = "publisher_establishment", nullable = false)
    private int establishment;

    @Column(name = "publisher_address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Publisher() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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

    public int getEstablishment() {
        return establishment;
    }

    public void setEstablishment(int establishment) {
        this.establishment = establishment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
