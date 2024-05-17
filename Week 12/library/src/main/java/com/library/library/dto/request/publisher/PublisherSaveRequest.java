package com.library.library.dto.request.publisher;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {

    @NotNull
    @NotEmpty
    private String name;
    @Positive
    private int establishment;

    @NotNull
    @NotEmpty
    private String address;
}
