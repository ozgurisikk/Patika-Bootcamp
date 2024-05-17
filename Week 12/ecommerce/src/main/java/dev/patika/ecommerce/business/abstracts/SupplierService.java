package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface SupplierService {
    Supplier save(Supplier supplier);
    Supplier get(long id);
    Page<Supplier> cursor(int page, int pageSize);
    Supplier update(Supplier supplier);
    boolean delete(long id);
}
