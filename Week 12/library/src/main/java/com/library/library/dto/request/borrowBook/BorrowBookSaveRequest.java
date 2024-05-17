package com.library.library.dto.request.borrowBook;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBookSaveRequest {
    @NotNull
    @NotEmpty
    private String name;
    @Email
    private String mail;
    private LocalDate borrowDate;
    private LocalDate returnDate;

}
