package com.example.testtask.controller;

import com.example.testtask.model.Book;
import com.example.testtask.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId, @RequestHeader(value = "Accept") String acceptHeader) {
        Book book = bookRepository.findOne(bookId);
        if (book == null) {
            return ResponseEntity.notFound().header(acceptHeader).build();

        }
        return ResponseEntity.ok().header(acceptHeader).body(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails,
                                           @RequestHeader(value = "Accept", defaultValue = "application/json") String acceptHeader) {
        Book book = bookRepository.findOne(bookId);

        if (book == null) {
            return ResponseEntity.notFound().header(acceptHeader).build();
        }
        book.setName(bookDetails.getName());
        book.setAuthor_fio(bookDetails.getAuthor_fio());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") Long bookId, @RequestHeader(value = "Accept", defaultValue = "application/json") String acceptHeader) {
        Book book = bookRepository.findOne(bookId);
        if (book == null) {
            return ResponseEntity.notFound().header(acceptHeader).build();
        }

        bookRepository.delete(book);
        return ResponseEntity.ok().header(acceptHeader).build();
    }
}