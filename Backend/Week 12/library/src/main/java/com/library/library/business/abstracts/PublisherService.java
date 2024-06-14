package com.library.library.business.abstracts;

import com.library.library.entities.Book;
import com.library.library.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PublisherService {
    Publisher save (Publisher publisher);
    Publisher get(int id);
    Page<Publisher> cursor(int page, int pageSize);
    Publisher update(Publisher publisher);
    boolean delete(int id);
}
