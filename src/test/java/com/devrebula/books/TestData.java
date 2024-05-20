package com.devrebula.books;

import com.devrebula.books.domain.Book;
import com.devrebula.books.domain.BookEntity;

public final class TestData {

    private TestData() {

    }

    public static Book testBook() {
        return Book.builder()
                .isbn("02345678")
                .author("Virginia Wolf")
                .title("The Waves")
                .build();
    }

    public static BookEntity testBookEntity() {
        return BookEntity.builder()
                .isbn("02345678")
                .author("Virginia Wolf")
                .title("The Waves")
                .build();
    }

}
