package com.example.smartlibrary.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ISPN")
    private String ISPN;

    @Column(name = " author")
    private String author;

    @Column(name = "size")
    private int size;

    @Column(name = "price")
    private int price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "sales")
    private int sales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelfBoy_id")
    private ShelfBoy shelfBoy;

//    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
//    @JoinTable(name = "book_user",
//    joinColumns = {
//            @JoinColumn(name = "book_id" , referencedColumnName = "id" ,
//            nullable = false , updatable = false)} ,
//
//            inverseJoinColumns = {
//            @JoinColumn(name = "user_id" , referencedColumnName = "id",
//            nullable = false , updatable = false)})
//    private Set<User> user = new HashSet<>();

    public Book() {
    }

    public Book(Long id, String name, String ISPN, String author, int size, int price, int stock, int sales, ShelfBoy shelfBoy) {
        this.id = id;
        this.name = name;
        this.ISPN = ISPN;
        this.author = author;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.shelfBoy = shelfBoy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISPN() {
        return ISPN;
    }

    public void setISPN(String ISPN) {
        this.ISPN = ISPN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }


    public ShelfBoy getShelfBoy() {
        return shelfBoy;
    }

    public void setShelfBoy(ShelfBoy shelfBoy) {
        this.shelfBoy = shelfBoy;
    }

    public Long getid() {
        return id;
    }

//    public Set<User> getUser() {
//        return user;
//    }
//
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }

}
