package com.example.smartlibrary.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
abstract class Person {

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

}
