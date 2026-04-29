package com.library;

import com.library.model.Book;
import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryManagementApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        assertNotNull(bookService);
    }

    @Test
    void testCreateAndRetrieveBook() {
        Book book = new Book("Test Book", "Test Author", "1234567890", "Test");
        Book saved = bookService.saveBook(book);
        assertNotNull(saved.getId());
        assertEquals("Test Book", saved.getTitle());
    }

    @Test
    void testGetAllBooks() {
        assertNotNull(bookService.getAllBooks());
    }

    @Test
    void testBookAvailability() {
        Book book = new Book("Available Book", "Author", "111", "Cat");
        book.setAvailable(true);
        Book saved = bookService.saveBook(book);
        assertTrue(saved.isAvailable());
    }
}
