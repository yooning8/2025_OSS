package com.example.re_wear.controller;

import com.example.re_wear.entity.Center;
import com.example.re_wear.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class CenterController {
    @Autowired
    private CenterService centerService;

    @GetMapping
    public List<Center> getAll() {
        return centerService.getAllCenters();
    }

    @PostMapping
    public Center add(@RequestBody Center center) {
        return centerService.saveCenter(center);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        centerService.deleteCenter(id);
    }
} 