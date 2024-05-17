package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product save(Product product);
    Product get(long id);
    Page<Product> cursor(int page, int pageSize);
    Product update(Product product);
    boolean delete(long id);
}
