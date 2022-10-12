package com.example.smartlibrary.Controller;

import com.example.smartlibrary.Service.ManagerService;
import com.example.smartlibrary.dto.Request.ManagerRequest;
import com.example.smartlibrary.dto.Request.ShelfBoyRequest;
import com.example.smartlibrary.dto.model.ManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;


    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public  List<ManagerDTO> findManagers(){
        return managerService.findManagers();
    }
//    public List<ManagerDTO> getShelfBoy() {
//        return managerService.getManagers();
//    }

    @PostMapping
    public void addManager(@RequestBody ManagerRequest ManagerRequest) {
        managerService.addManager(ManagerRequest);
    }

    @PutMapping
    public void updateManager(@RequestBody ManagerRequest managerRequest) {
        managerService.updateManager(managerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}
