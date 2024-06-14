package dev.patika.ecommerce.dto.request.supplier;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierSaveRequest {

    @NotNull
    private String name;
    private String contactName;
    private String address;
    @Email
    private String contactMail;
}
