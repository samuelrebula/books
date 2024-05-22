package com.devrebula.books.services;

import java.util.List;
import java.util.Optional;

import com.devrebula.books.domain.Book;

public interface BookService {

    Book create(Book book);

    Optional<Book> findById(String isbn);

    List<Book> listBooks();
}
