package com.library.library.dto.response.borrowBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookResponse {
    private String name;
    private String mail;
    private LocalDate borrowDate;
    private LocalDate returnDate;

}
