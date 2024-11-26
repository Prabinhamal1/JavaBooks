package com.example.bookss.Service;
import com.example.bookss.Model.Book;
import java.util.List;

public interface bookService2 {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book saveBook(Book book);
    String deleteBook(int id);
    Book updateBook(int id , Book book);

    
}
