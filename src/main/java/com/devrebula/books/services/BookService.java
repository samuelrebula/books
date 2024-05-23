package com.devrebula.books.services;

import java.util.List;
import java.util.Optional;

import com.devrebula.books.domain.Book;

public interface BookService {

    boolean isBookExists(Book book);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    List<Book> listBooks();

    void deleteBookById(String isbn);
}
