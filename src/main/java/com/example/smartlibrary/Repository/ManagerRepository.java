package com.example.smartlibrary.Repository;

import com.example.smartlibrary.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {


    @Query(value = "select distinct m from Manager m join fetch  m.shelfBoy s ")
    List<Manager> findManagers();
}
