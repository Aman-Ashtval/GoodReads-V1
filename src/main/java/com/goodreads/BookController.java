package com.goodreads;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.goodreads.Book;
import com.goodreads.BookService;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class BookController {
    BookService bookService = new BookService();

    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return  bookService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book){
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
    }
}
