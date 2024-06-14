package dev.patika.ecommerce.dto.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private long id;
    private String companyName;
}
