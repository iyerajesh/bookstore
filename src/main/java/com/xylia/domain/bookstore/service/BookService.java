package com.xylia.domain.bookstore.service;

import com.xylia.domain.bookstore.model.Author;
import com.xylia.domain.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService() {

        this.bookList = new ArrayList<>();

        bookList.add(new Book("Becoming", "9781524763138", Arrays.asList(new Author("Michelle Obama"))));
        bookList.add(new Book("Liar Liar", "9780316418249", Arrays.asList(new Author("James Patterson"), new Author("Candice Fox"))));
        bookList.add(new Book("The Chef", "9780316453301", Arrays.asList(new Author("Max DiLallo "), new Author("James Patterson"))));
        bookList.add(new Book("Stranger Things - Suspicious Minds", "9781984800886", Arrays.asList(new Author("Gwenda Bond"))));
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public Optional<Book> getBookByIsbn(String isbn) {

        return bookList.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> longExecutionMethod() {

        try {
            // Simulate random poor performing method!
            if (ThreadLocalRandom.current().nextBoolean())
                Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.bookList;
    }
}
