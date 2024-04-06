package entity;

//Veritabanindan cektigimiz verilerin javada bir kasrsiligi olmasi icin bir sinif yaratiyoruz ve adini veri cekicegimiz
//table ismini veriyoruz burda User table indan cektigimiz verileri atiyoruz yani

public class User {
    private int id;
    private String name;
    private String mail;
    private String password;
    private Type type;
    private Gender gender;

    public enum Type{
        WORKER,
        ADMIN

    }

    public enum Gender{
        MALE,
        FEMALE
    }

    public User() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", gender=" + gender +
                '}';
    }
}
