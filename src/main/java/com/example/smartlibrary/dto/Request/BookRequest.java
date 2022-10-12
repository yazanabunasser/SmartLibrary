package com.example.smartlibrary.dto.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BookRequest {
    private Long Id;

    private String name;

    private String ISPN;

    private String author;

    private int size;

    private int price;

    private int stock;

    private Long shelfBoyId;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getShelfBoyId() {
        return shelfBoyId;
    }

    public void setShelfBoyId(Long shelfBoyId) {
        this.shelfBoyId = shelfBoyId;
    }
}
