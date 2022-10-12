package com.example.smartlibrary.Service;

import com.example.smartlibrary.Model.Manager;
import com.example.smartlibrary.Model.ShelfBoy;
import com.example.smartlibrary.Repository.ManagerRepository;
import com.example.smartlibrary.Repository.ShelfBoyRepository;
import com.example.smartlibrary.dto.Request.ShelfBoyRequest;
import com.example.smartlibrary.dto.mapper.ObjectMapperUtils;
import com.example.smartlibrary.dto.model.BookDTO;
import com.example.smartlibrary.dto.model.ShelfBoyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ShelfBoyService {

    @Autowired
    ShelfBoyRepository shelfBoyRepository;
    @Autowired
    ManagerRepository managerRepository;

    public List<ShelfBoyDTO> getShelfBoys() {
        List<ShelfBoy> shelfBoys = shelfBoyRepository.findAll();
        return ObjectMapperUtils.mapAll(shelfBoys , ShelfBoyDTO.class);
    }

    public void addShelfBoy(ShelfBoyRequest shelfBoyRequest) {

        ShelfBoy shelfBoy = ObjectMapperUtils.map(shelfBoyRequest, ShelfBoy.class);
        Optional<Manager> manager = managerRepository.findById(shelfBoyRequest.getManagerId());
        if (manager.isPresent()) {
            shelfBoy.setManager(manager.get());
        }else {
            throw new EntityNotFoundException(" ManagerId " + shelfBoyRequest.getManagerId() + " not exists");
        }
        shelfBoyRepository.save(shelfBoy);
    }

    public void updateShelfBoy(ShelfBoyRequest shelfBoyRequest) {
        ShelfBoy shelfBoy = ObjectMapperUtils.map(shelfBoyRequest , ShelfBoy.class);
        shelfBoyRepository.save(shelfBoy);
    }

    public void deleteShelfBoy(Long id) {
        shelfBoyRepository.deleteById(id);
    }

    public List<ShelfBoyDTO> findShelfBoys() {
        List<ShelfBoy> shelfBoys = shelfBoyRepository.findShelfBoys();
        return ObjectMapperUtils.mapAll(shelfBoys , ShelfBoyDTO.class);
    }
}
