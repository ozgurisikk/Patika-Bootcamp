package dev.patika.ecommerce.dto.response.product;

import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private long id;
    private String name;
    private double price;
    private int stock;
    private long supplierId;
    private long categoryId;
}
