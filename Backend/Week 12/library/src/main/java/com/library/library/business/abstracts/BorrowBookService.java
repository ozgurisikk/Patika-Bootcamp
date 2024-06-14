package com.library.library.business.abstracts;

import com.library.library.entities.Book;
import com.library.library.entities.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BorrowBookService {
    BorrowBook save (BorrowBook borrowBook);
    BorrowBook get(int id);
    Page<BorrowBook> cursor(int page, int pageSize);

    BorrowBook update(BorrowBook borrowBook);

    boolean delete(int id);
}
