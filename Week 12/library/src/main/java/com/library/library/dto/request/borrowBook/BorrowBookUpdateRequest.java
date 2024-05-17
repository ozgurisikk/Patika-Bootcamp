package com.library.library.dto.request.borrowBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookUpdateRequest {
    private String name;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
