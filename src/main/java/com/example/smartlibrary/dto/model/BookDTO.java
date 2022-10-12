package com.example.smartlibrary.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long id;
    private String name;
    private String ISPN;
    private String author;
    private int size;
    private int price;

    private int stock;
    private int sales;
    private int available;
    private ShelfBoyDTO shelfBoyDTO;


    public BookDTO() {
    }

    public BookDTO(Long id, String name, String ISPN, String author, int size, int price, int available , int stock , int sales) {
        this.id = id;
        this.name = name;
        this.ISPN = ISPN;
        this.author = author;
        this.size = size;
        this.price = price;
        this.available = available;
        this.stock = stock;
        this.sales = sales;
    }


    public BookDTO(Long id, String name, String ispn, String author, int size, int price, int stock, int sales) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.size = size;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    
}

