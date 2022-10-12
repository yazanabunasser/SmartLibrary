package com.example.smartlibrary.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "shelf_boy")
public class ShelfBoy extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workDepartment")
    private String workDepartment;

    @OneToMany(mappedBy = "shelfBoy" , fetch = FetchType.LAZY)
    private List<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;

}
