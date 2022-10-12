package com.example.smartlibrary.Service;

import com.example.smartlibrary.Model.Book;
import com.example.smartlibrary.Model.ShelfBoy;
import com.example.smartlibrary.Repository.BookRepository;
import com.example.smartlibrary.Repository.ShelfBoyRepository;
import com.example.smartlibrary.dto.Request.BookRequest;
import com.example.smartlibrary.dto.mapper.ObjectMapperUtils;
import com.example.smartlibrary.dto.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ShelfBoyRepository shelfBoyRepository;

    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return ObjectMapperUtils.mapAll(books , BookDTO.class);
    }

    public void addBook(BookRequest bookRequest) {
        Book book = ObjectMapperUtils.map(bookRequest, Book.class);
        Optional<ShelfBoy> shelfBoy = shelfBoyRepository.findById(bookRequest.getShelfBoyId());
        if (shelfBoy.isPresent()) {
            book.setShelfBoy(shelfBoy.get());
        } else {
            throw new EntityNotFoundException("ShelfBoyId " + bookRequest.getShelfBoyId() + " not exsist");
        }
        bookRepository.save(book);
    }

    public void updateStock(long id, BookRequest bookRequest) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = bookOptional.get();
        book.setStock(book.getStock() + bookRequest.getStock());
        bookRepository.save(book);




    }

    public void updateBook(BookRequest bookRequest) {
        Book book = ObjectMapperUtils.map(bookRequest , Book.class);
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }


    public List<BookDTO> findAA() {
        List<Book> books = bookRepository.findAA();
        return ObjectMapperUtils.mapAll(books , BookDTO.class);
    }
}
