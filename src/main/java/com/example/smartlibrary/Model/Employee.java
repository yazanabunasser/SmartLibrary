package com.example.smartlibrary.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;

@MappedSuperclass
@Data
abstract class Employee extends Person{

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

}
