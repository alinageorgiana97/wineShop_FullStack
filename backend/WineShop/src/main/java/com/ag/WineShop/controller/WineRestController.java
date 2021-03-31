package com.ag.WineShop.controller;

import com.ag.WineShop.dto.WineDTO;
import com.ag.WineShop.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wine")
@CrossOrigin(origins = "http://localhost:4200")
public class WineRestController {


    private final WineService wineService;


    @Autowired
    public WineRestController(WineService wineService) {
        this.wineService = wineService;

    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody WineDTO wineDTO) {
        Integer entityId = wineService.save(wineDTO);

        // Validation error
        if (entityId.equals(0)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error");
        }
        return ResponseEntity.ok(entityId);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody WineDTO wineDTO) {
        return wineService.update(wineDTO);
    }

    @GetMapping("/list")
    public List<WineDTO> list() {
        return wineService.findAll();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {

        wineService.delete(id);
    }

    @GetMapping(path = "/get/{id}")
    public WineDTO find(@PathVariable("id") Integer id) {

        return wineService.findById(id);
    }


}
