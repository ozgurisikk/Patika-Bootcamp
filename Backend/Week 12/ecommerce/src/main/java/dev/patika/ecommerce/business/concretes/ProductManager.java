package dev.patika.ecommerce.business.concretes;

import dev.patika.ecommerce.business.abstracts.ProductService;
import dev.patika.ecommerce.core.exception.NotFoundException;
import dev.patika.ecommerce.core.utilities.Msg;
import dev.patika.ecommerce.dao.ProductRepo;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {
    private final ProductRepo productRepo;

    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product save(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public Product get(long id) {
        return this.productRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Product> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.productRepo.findAll(pageable);
    }

    @Override
    public Product update(Product product) {
        this.get(product.getId());
        return this.productRepo.save(product);
    }

    @Override
    public boolean delete(long id) {
        Product product = this.get(id);
        this.productRepo.delete(product);
        return true;
    }
}
