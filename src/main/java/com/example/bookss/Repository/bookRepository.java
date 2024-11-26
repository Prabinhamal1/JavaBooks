package com.example.bookss.Repository;
import com.example.bookss.Entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends JpaRepository<BookEntity,Integer> {
    //crud operation
    //find by id 
    //findbyTitle(List<Book> findByTitle(String title));
    //find by author-findbyAuthor<Book> findByAuthor(String author);
}
