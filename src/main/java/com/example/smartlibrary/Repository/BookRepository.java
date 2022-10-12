package com.example.smartlibrary.Repository;

import com.example.smartlibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b join fetch b.shelfBoy s  join fetch s.manager m")
    List<Book> findAA();
}
