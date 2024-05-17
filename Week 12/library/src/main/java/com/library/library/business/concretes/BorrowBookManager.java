package com.library.library.business.concretes;

import com.library.library.business.abstracts.BorrowBookService;
import com.library.library.core.exception.NotFoundException;
import com.library.library.core.utilities.Msg;
import com.library.library.dao.BorrowBookRepo;
import com.library.library.entities.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookManager implements BorrowBookService {
    private final BorrowBookRepo borrowBookRepo;

    public BorrowBookManager(BorrowBookRepo borrowBookRepo) {
        this.borrowBookRepo = borrowBookRepo;
    }

    @Override
    public BorrowBook save(BorrowBook borrowBook) {
        return this.borrowBookRepo.save(borrowBook);
    }

    @Override
    public BorrowBook get(int id) {
        return this.borrowBookRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<BorrowBook> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.borrowBookRepo.findAll(pageable);
    }

    @Override
    public BorrowBook update(BorrowBook borrowBook) {
        this.get(borrowBook.getId());
        return this.borrowBookRepo.save(borrowBook);
    }

    @Override
    public boolean delete(int id) {
        BorrowBook borrowBook = this.get(id);
        this.borrowBookRepo.delete(borrowBook);
        return true;
    }
}
