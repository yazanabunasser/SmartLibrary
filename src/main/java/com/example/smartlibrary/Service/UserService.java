package com.example.smartlibrary.Service;

import com.example.smartlibrary.Model.User;
import com.example.smartlibrary.Repository.UserRepository;
import com.example.smartlibrary.dto.Request.UserRequest;
import com.example.smartlibrary.dto.mapper.ObjectMapperUtils;
import com.example.smartlibrary.dto.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUser() {
        List<User> users = userRepository.findAll();
        return ObjectMapperUtils.mapAll(users, UserDTO.class);
    }

    public void addUser(UserRequest userRequest) {
        User user = ObjectMapperUtils.map(userRequest, User.class);
        userRepository.save(user);
    }

    public void updateUser(UserRequest userRequest) {
        User user = ObjectMapperUtils.map(userRequest, User.class);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
