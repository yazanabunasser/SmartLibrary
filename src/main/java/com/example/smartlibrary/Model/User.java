package com.example.smartlibrary.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CreditCard;

//    @ManyToMany(mappedBy = "user" , fetch = FetchType.LAZY)
//    private Set<Book> books = new HashSet<>();

    public User(Long id) {
        this.id = id;

    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(String creditCard) {
        CreditCard = creditCard;
    }

//    public Set<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }
}
