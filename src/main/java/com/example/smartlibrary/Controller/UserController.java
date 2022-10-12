package com.example.smartlibrary.Controller;

import com.example.smartlibrary.Service.UserService;
import com.example.smartlibrary.dto.Request.BookRequest;
import com.example.smartlibrary.dto.Request.UserRequest;
import com.example.smartlibrary.dto.model.BookDTO;
import com.example.smartlibrary.dto.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getUser();
    }

    @PostMapping
    public void addUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
    }

    @PutMapping
    public void updateUser(@RequestBody UserRequest userRequest){
        userService.updateUser(userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
