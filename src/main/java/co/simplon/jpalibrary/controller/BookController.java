package co.simplon.jpalibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.jpalibrary.model.Book;
import co.simplon.jpalibrary.repository.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;
    BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Optional<Book> bookById = bookRepo.findById(id);
        if (bookById.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } return new ResponseEntity<>(bookById.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> postNewBook(@RequestBody Book book) {
        try {
            bookRepo.save(book);
            return new ResponseEntity<>(HttpStatus.CREATED); 
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> putBook(@PathVariable long id, @RequestBody Book book) {
        try {
            if(bookRepo.findById(id).isPresent()) {
                bookRepo.save(book);
                return new ResponseEntity<>(HttpStatus.CREATED); 
            } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        try {
            Optional<Book> toRemoveBook = bookRepo.findById(id);
            if(toRemoveBook.isPresent()) {
                bookRepo.delete(toRemoveBook.get());
                return new ResponseEntity<>(HttpStatus.OK);
            } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}