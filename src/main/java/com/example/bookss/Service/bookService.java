package com.example.bookss.Service;


import java.util.Map;

import com.example.bookss.Model.Book;

public interface bookService {
    Map<Integer,Book> getBooks();
    Book getBookById(int id);
    Book SaveBook(Book book);
    Book UpdateBook(int id ,Book Updatebook);
    String DeleteBook(int id);
}
