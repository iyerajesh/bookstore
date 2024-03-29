package com.xylia.domain.bookstore.controller;

import com.xylia.domain.bookstore.model.Book;
import com.xylia.domain.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {

        Optional<Book> book = bookService.getBookByIsbn(isbn);

        if (book.isPresent())
            return ResponseEntity.ok(book.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    }

    @GetMapping("/danger")
    public ResponseEntity<List<Book>> unstableEndpoint() {
        return ResponseEntity.ok(bookService.longExecutionMethod());
    }
}
