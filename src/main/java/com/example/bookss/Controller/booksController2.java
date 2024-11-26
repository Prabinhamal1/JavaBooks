package com.example.bookss.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookss.Model.Book;
import com.example.bookss.Service.bookService;
import com.example.bookss.Service.bookService2;
import com.example.bookss.Service.bookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/book/b")
public class booksController2 {
    // @Autowired
    // bookService BookService;
    bookService2 BookService;
    booksController2(bookService2 BookService) {
        this.BookService = BookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return BookService.getBookById(id);
    }
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return BookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book UpdateBook(@PathVariable int id, @RequestBody Book updatebook) {
        
        return BookService.updateBook(id,updatebook);
    }
    @DeleteMapping("/{id}")
    public String DeleteBook(@PathVariable int id) {
        
        return BookService.deleteBook(id);
    }
    
    
    
}
