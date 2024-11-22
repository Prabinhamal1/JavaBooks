package com.example.bookss.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bookss.Model.Book;
@Service
public class bookServiceImp implements bookService {
    private Map<Integer,Book> booksMap = new HashMap<>();
    private int bookid = 0;
    @Override
    public Map<Integer, Book> getBooks() {
       return booksMap;
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }

    @Override
    public Book SaveBook(Book book) {
        book.setId(GenerateId());
        booksMap.put(book.getId(), book);
        return book;
    }

    @Override
    public Book UpdateBook(int id, Book Updatebook) {
        Book existingBook = booksMap.get(id);
        if(existingBook==null) {
            return null;
        }
            else{
                existingBook.setTitle(Updatebook.getTitle());
                existingBook.setAuthor(Updatebook.getAuthor());
                return existingBook;
            }
                
    }

    @Override
    public String DeleteBook(int id) {
        if(booksMap.get(id)==null) return "Book not found";
        else{
            booksMap.remove(id);
            return "Book deleted";
        }
        
    }
    public int GenerateId() {
        return bookid++;
    }

  
    
}
