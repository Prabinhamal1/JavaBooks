package com.example.bookss.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.bookss.Entity.BookEntity;
import com.example.bookss.Model.Book;
import com.example.bookss.Repository.bookRepository;

@Service
public class bookServiceImpl implements bookService2 {

    private bookRepository bookRepository;
    bookServiceImpl(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        List<BookEntity> booksDB =  bookRepository.findAll();
        for (BookEntity bookEntity : booksDB){
            Book book = new Book();
            BeanUtils.copyProperties(bookEntity, book);
            books.add(book);
        }
        return books;
        
    }

    @Override
    public Book getBookById(int id) {
       BookEntity bookEntity =  bookRepository.findById(id).get();
       Book book = new Book();
       BeanUtils.copyProperties(bookEntity, book);
       return book;
    }

    @Override
    public Book saveBook(Book book) {
     BookEntity bookEntity = new BookEntity();
     BeanUtils.copyProperties(book, bookEntity);
     
     bookRepository.save(bookEntity);
     return book;

    }
    @Override
    public String deleteBook(int id) {
       BookEntity bookEntity= bookRepository.findById(id).get();
       bookRepository.delete(bookEntity);
       return "book deleted";


    }

    @Override
    public Book updateBook(int id, Book book) {
        BookEntity bookEntity = bookRepository.findById(id).get();

        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());

        bookRepository.save(bookEntity);
        return book;    }
    
}
