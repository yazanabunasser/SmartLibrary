package com.example.smartlibrary.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
    private Long id;
    private String name;
    private String gender;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ShelfBoyDTO> shelfBoyDTO;

    public ManagerDTO(Long id, String name, String gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }
}
