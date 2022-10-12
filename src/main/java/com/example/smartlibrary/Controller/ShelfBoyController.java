package com.example.smartlibrary.Controller;

import com.example.smartlibrary.Service.ShelfBoyService;
import com.example.smartlibrary.dto.Request.ShelfBoyRequest;
import com.example.smartlibrary.dto.model.ShelfBoyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelfBoy")
public class ShelfBoyController {

    private final ShelfBoyService shelfBoyService;

    @Autowired
    public ShelfBoyController(ShelfBoyService shelfBoyService) {
        this.shelfBoyService = shelfBoyService;
    }

    @GetMapping
    public List<ShelfBoyDTO> fingShelfBoys(){
        return shelfBoyService.findShelfBoys();
    }
//    public List<ShelfBoyDTO> getShelfBoy() {
//        return shelfBoyService.getShelfBoys();
//    }

    @PostMapping
    public void addShelfBoy(@RequestBody ShelfBoyRequest shelfBoyRequest) {
        shelfBoyService.addShelfBoy(shelfBoyRequest);
    }

    @PutMapping
    public void updateShelfBoy(@RequestBody ShelfBoyRequest shelfBoyRequest) {
        shelfBoyService.updateShelfBoy(shelfBoyRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteShelfBoy(@PathVariable Long id) {
        shelfBoyService.deleteShelfBoy(id);
    }


}
