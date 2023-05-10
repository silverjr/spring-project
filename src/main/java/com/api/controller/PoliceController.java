package com.api.controller;

import com.api.entity.Police;
import com.api.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")

public class PoliceController {
    @Autowired
    PoliceService policeService;

    /*create police officer*/
    @PostMapping("/create-police")
    public Police savePolice(@RequestBody Police police){
        return policeService.createPolice(police);
    }

    /*get all list of police officers*/
    @GetMapping("/list-all-police")
    public List<Police> getAllPolice(){
        return policeService.getAllPolice();
    }

    /*get police by Id*/
    @PostMapping("/fetch-police-byid/{id}")
    public Police fetchPoliceById(@PathVariable("id") Long policeId){
        return policeService.fetchPoliceById(policeId);
    }

    /*Delete police by Id*/
    @DeleteMapping("/delete-police-byid/{id}")
    public String deletePoliceById(@PathVariable("id") Long policeId){
        policeService.deletePoliceById(policeId);
        return "Police Deleted Successfully";
    }
}