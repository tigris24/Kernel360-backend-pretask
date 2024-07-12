package com.example.memorydb.book.service;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

/*    @Autowired
    private final BookRepository bookRepository;
*/

/*    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
*/

    // create , update
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    // all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    // delete
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    // find one
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }


}
