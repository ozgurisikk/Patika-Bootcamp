import jakarta.persistence.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        Query getCategories = entityManager.createQuery("SELECT supplier_mail FROM Supplier supplier_mail");
        List<Supplier > categoryList = getCategories.getResultList();
        for (Supplier supp : categoryList){
            System.out.println((supp.getAddres()));
        }
/*
         //Create Supplier

        Supplier supplier = new Supplier();
        supplier.setAddres("adres");
        supplier.setCompany("migr");
        supplier.setContact("382497218");
        supplier.setMail("test2");
        supplier.setPerson("person");
        entityManager.persist(supplier);


        // Create Code
        Code code = new Code();
        code.setGroup("111");
        code.setSerial("222");
        entityManager.persist(code);

        // Create Category
        Category category = new Category();
        category.setName("Phone");
        entityManager.persist(category);


        // Create Product
        Product product = new Product();
        product.setName("pro15");
        product.setPrice(12312);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);
        entityManager.persist(product);


        System.out.println(product.toString());

*/
        /*
        Color blue= new Color("blue");
        Color red = new Color("red");
        Color green = new Color("green");
        Color yellow = new Color("yellow");
        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(green);
        entityManager.persist(yellow);

        List<Color> colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(green);
        colorList.add(yellow);

        product.setColorList(colorList);
        entityManager.persist(product);

        transaction.commit();


        Product product = entityManager.find(Product.class, 1);
        System.out.println(product.getColorList().toString());
        */

        transaction.commit();


        // CREATE
        /*transaction.begin();
        Customer customer = new Customer();

        customer.setName("Ozgur");
        customer.setMail("test");
        customer.setGender(Customer.GENDER.MALE);
        customer.setOnDate(LocalDate.now());

        entityManager.persist(customer);
        transaction.commit();
        */

        /* READ
        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println(customer.toString());
         */

        /* UPDATE
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1);
        customer.setName("JUST A TEST");

        entityManager.persist(customer);
        transaction.commit();
         */
        /* DELETE
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 4);
        entityManager.remove(customer);
        transaction.commit();
         */


    }
}
