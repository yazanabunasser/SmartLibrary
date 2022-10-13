package com.example.smartlibrary.Controller;

import com.example.smartlibrary.Service.BookService;
import com.example.smartlibrary.dto.Request.BookRequest;
import com.example.smartlibrary.dto.model.BookDTO;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping
//    public List<BookDTO> getBooks(){
//        return bookService.getBooks();
//    }
    public List<BookDTO> findAA(){
        return bookService.findAA();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest bookRequest){
        bookService.addBook(bookRequest);
    }

    @PutMapping("/{id}")
    public void updateStock(@PathVariable Long id , @RequestBody BookRequest bookRequest) {
        bookService.updateStock( id , bookRequest);
    }

    @PutMapping
    public void updateBook(@RequestBody BookRequest bookRequest){
        bookService.updateBook(bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}

