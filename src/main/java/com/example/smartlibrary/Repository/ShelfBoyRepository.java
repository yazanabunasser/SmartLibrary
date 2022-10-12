package com.example.smartlibrary.Repository;

import com.example.smartlibrary.Model.ShelfBoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfBoyRepository extends JpaRepository<ShelfBoy , Long> {

    @Query("select s from ShelfBoy s join fetch s.manager m join fetch s.books books")
    List<ShelfBoy> findShelfBoys();
}
