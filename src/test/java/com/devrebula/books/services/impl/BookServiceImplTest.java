package com.devrebula.books.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.devrebula.books.TestData.testBook;
import static com.devrebula.books.TestData.testBookEntity;
import com.devrebula.books.domain.Book;
import com.devrebula.books.domain.BookEntity;
import com.devrebula.books.repositories.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved() {
        final Book book = testBook();

        final BookEntity bookEntity = testBookEntity();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

        final Book result = underTest.create(book);
        assertEquals(book, result);
    }

    @Test
    public void testThatFindByIdReturnsEmptyWhenNoBook() {
        final String isbn = "123123123";
        when(bookRepository.findById(isbn)).thenReturn(Optional.empty());

        final Optional<Book> result = underTest.findById(isbn);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testThatFindByIdReturnsBookWhenExists() {
        final Book book = testBook();
        final BookEntity bookEntity = testBookEntity();
        when(bookRepository.findById(eq(book.getIsbn()))).thenReturn(Optional.of(bookEntity));

        final Optional<Book> result = underTest.findById(book.getIsbn());
        assertEquals(Optional.of(book), result);
    }

    @Test
    public void testListBooksReturnsEmptyListWhenNoBooksExist() {
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        final List<Book> result = underTest.listBooks();
        assertEquals(0, result.size());
    }

    @Test
    public void testListBooksReturnsBookWhenExist() {
        final BookEntity bookEntity = testBookEntity();
        when(bookRepository.findAll()).thenReturn(List.of(bookEntity));
        final List<Book> result = underTest.listBooks();
        assertEquals(1, result.size());
    }

}
