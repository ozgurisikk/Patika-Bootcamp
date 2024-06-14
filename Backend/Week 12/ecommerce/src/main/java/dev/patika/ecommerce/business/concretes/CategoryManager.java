package dev.patika.ecommerce.business.concretes;

import dev.patika.ecommerce.business.abstracts.CategoryService;
import dev.patika.ecommerce.core.exception.NotFoundException;
import dev.patika.ecommerce.core.utilities.Msg;
import dev.patika.ecommerce.dao.CategoryRepo;
import dev.patika.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) { // dependency injection
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(long id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(long id) {
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }
}
