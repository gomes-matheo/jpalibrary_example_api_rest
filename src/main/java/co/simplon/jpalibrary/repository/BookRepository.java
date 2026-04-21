package co.simplon.jpalibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.jpalibrary.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
