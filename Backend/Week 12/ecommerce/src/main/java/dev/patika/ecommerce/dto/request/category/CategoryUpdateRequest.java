package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {
    @Positive(message = "ID degeri pozitif olmali")
    private int id;

    @NotNull(message = "Kategori bos veya null olamaz")
    private String name;
}
