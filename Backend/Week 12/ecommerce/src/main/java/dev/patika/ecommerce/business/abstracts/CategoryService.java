package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Category save(Category category);
    Category get(long id);
    Page<Category> cursor(int page, int pageSize);
    Category update(Category category);
    boolean delete(long id);




}
