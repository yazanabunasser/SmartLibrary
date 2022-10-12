package com.example.smartlibrary.dto.model;

import com.example.smartlibrary.Model.Book;
import com.example.smartlibrary.Model.Manager;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShelfBoyDTO {

    private Long id;
    private String name;
    private String gender;
    private String email;
    private String workDepartment;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BookDTO> bookDTO;
    private ManagerDTO managerDTO;

    public ShelfBoyDTO() {
    }

    public ShelfBoyDTO(Long id, String name, String gender, String email, String workDepartment) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.workDepartment = workDepartment;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkDepartment() {
        return workDepartment;
    }

    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    public ManagerDTO getManagerDTO() {
        return managerDTO;
    }

    public void setManagerDTO(ManagerDTO managerDTO) {
        this.managerDTO = managerDTO;
    }

    public List<BookDTO> getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(List<BookDTO> bookDTO) {
        this.bookDTO = bookDTO;
    }
}
