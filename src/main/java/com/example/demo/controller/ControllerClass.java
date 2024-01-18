package com.example.demo.controller;

import com.example.demo.response.StatusResponse;
import com.example.demo.model.Doctor;
import com.example.demo.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/doctors")
public class ControllerClass {
    @Autowired
    private ServiceClass service;
    @PostMapping()

    public ResponseEntity<?> saveDetail(@RequestBody Doctor doctor){
        ResponseEntity<?> response = new ResponseEntity<>(service.saveDetail(doctor), HttpStatus.CREATED);
        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editDetail(@RequestBody Doctor doctor, @PathVariable("id") Integer id){
        Doctor updatedRecord = service.editDetail(id,doctor);
       return new ResponseEntity<Doctor>(updatedRecord, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDetail(@PathVariable("id") Integer id){
        Doctor getRecord = service.getDetailById(id);
        return new ResponseEntity<Doctor>(getRecord, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllDetail(){
        List<Doctor> getAllRecords = service.getAllDetails();
        if(getAllRecords.isEmpty()){
            return new ResponseEntity<>(getAllRecords,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Doctor>>(getAllRecords, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetail(@PathVariable("id") Integer id){
        service.deleteDetail(id);
        return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);

    }

}
