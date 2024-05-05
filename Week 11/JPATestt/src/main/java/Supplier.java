import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;
    @Column(name = "supplier_address")
    private String addres;
    @Column(name = "supplier_company")
    private String company;
    @Column(name = "supplier_person")
    private String person;
    @Column(name = "supplier_mail", unique = true)
    private String mail;
    @Column(name = "supplier_contact")
    private String contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Supplier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", addres='" + addres + '\'' +
                ", company='" + company + '\'' +
                ", person='" + person + '\'' +
                ", mail='" + mail + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
