package com.library.library.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    private String name;
    private int publishYear;
    private int stock;
    private int publisherId;
    private int authorId;
}
