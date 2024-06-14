package dev.patika.ecommerce.dao;

import dev.patika.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
