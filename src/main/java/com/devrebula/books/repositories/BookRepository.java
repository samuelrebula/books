package com.devrebula.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devrebula.books.domain.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
