package com.example.re_wear.service;

import com.example.re_wear.entity.Center;
import com.example.re_wear.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {
    @Autowired
    private CenterRepository centerRepository;

    public List<Center> getAllCenters() {
        return centerRepository.findAll();
    }

    public Center saveCenter(Center center) {
        return centerRepository.save(center);
    }

    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);
    }
} 