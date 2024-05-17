package com.library.library.dao;

import com.library.library.entities.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepo extends JpaRepository<BorrowBook, Integer> {
}
