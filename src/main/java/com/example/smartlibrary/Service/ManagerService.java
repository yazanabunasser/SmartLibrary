package com.example.smartlibrary.Service;

import com.example.smartlibrary.Model.Book;
import com.example.smartlibrary.Model.Manager;
import com.example.smartlibrary.Model.ShelfBoy;
import com.example.smartlibrary.Repository.ManagerRepository;
import com.example.smartlibrary.dto.Request.ManagerRequest;
import com.example.smartlibrary.dto.Request.ShelfBoyRequest;
import com.example.smartlibrary.dto.mapper.ObjectMapperUtils;
import com.example.smartlibrary.dto.model.BookDTO;
import com.example.smartlibrary.dto.model.ManagerDTO;
import com.example.smartlibrary.dto.model.ShelfBoyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;


    public List<ManagerDTO> getManagers() {
        List<Manager> managers = managerRepository.findAll();
        return ObjectMapperUtils.mapAll(managers , ManagerDTO.class);
    }

    public void addManager(ManagerRequest managerRequest) {
        Manager manager = ObjectMapperUtils.map(managerRequest , Manager.class);
        managerRepository.save(manager);
    }

    public void updateManager(ManagerRequest managerRequest) {
        Manager manager = ObjectMapperUtils.map(managerRequest , Manager.class);
        managerRepository.save(manager);
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }

    public List<ManagerDTO> findManagers() {
        List<Manager> manager = managerRepository.findManagers();
        return ObjectMapperUtils.mapAll(manager , ManagerDTO.class);
    }

}
