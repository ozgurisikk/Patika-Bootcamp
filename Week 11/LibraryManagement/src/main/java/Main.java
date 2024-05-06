import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Author emily = new Author();
        emily.setName("Emily Bronte");
        emily.setBirthdate(1818);
        emily.setNationality("English");
        entityManager.persist(emily);

        Publisher oxford = new Publisher();
        oxford.setName("Oxford House");
        oxford.setAddress("England");
        oxford.setEstablishment(1919);
        entityManager.persist(oxford);

        Category gothicNovel = new Category();
        Category romance = new Category();
        romance.setName("Romance");
        gothicNovel.setName("Gothic Novel");
        entityManager.merge(gothicNovel);
        entityManager.merge(romance);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(romance);
        categoryList.add(gothicNovel);
        entityManager.persist(gothicNovel);
        entityManager.persist(romance);

        Book wutheringHeights = new Book();
        wutheringHeights.setName("Wuthering Heights");
        wutheringHeights.setPublishYear(1847);
        wutheringHeights.setAuthor(emily);
        wutheringHeights.setPublisher(oxford);
        wutheringHeights.setStock(10);
        wutheringHeights.setCategoryList(categoryList);
        entityManager.persist(wutheringHeights);


        transaction.commit();



    }
}
