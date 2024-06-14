package com.library.library.business.abstracts;

import com.library.library.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author save (Author author);
    Author get(int id);
    Page<Author> cursor(int page, int pageSize);
    Author update(Author author);
    boolean delete(int id);
}
