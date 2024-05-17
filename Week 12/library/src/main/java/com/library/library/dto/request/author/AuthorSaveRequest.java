package com.library.library.dto.request.author;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {

    @NotNull
    @NotEmpty
    private String name;

    private int birthdate;

    @NotEmpty(message = "cannot")
    @NotNull(message = "cannot")
    private String nationality;

}
