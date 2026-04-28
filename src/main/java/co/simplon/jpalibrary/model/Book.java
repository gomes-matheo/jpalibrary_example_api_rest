package co.simplon.jpalibrary.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")

public class Book {
    
    @Column(nullable = false, name = "book_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    
    @Column(nullable = false, name = "title")
    private String title;
    
    @Column(nullable = true, name = "description")
    private String description;
    
    @Column(nullable = false, name = "available", columnDefinition = "Boolean default true")
    private Boolean available = true;

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authorId = new ArrayList<>();

    // @Column(nullable = false, name = "category_id")
    @ManyToOne
    private Category categoryId;

    public long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Author> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Author> authorId) {
        this.authorId = authorId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}