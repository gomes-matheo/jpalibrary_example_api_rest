package co.simplon.jpalibrary.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Id @Column(
        name = "author_id",
        nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;
    
    @Column(
        name = "lastname",
        nullable = false) 
    private String lastname;
    
    @Column(
        name = "firstname",
        nullable = true)
    private String firstname;

    @ManyToMany(mappedBy = "authorId")
    private List<Book> pkBooks = new ArrayList<>();


    public long getAuthorId() {
        return authorId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
