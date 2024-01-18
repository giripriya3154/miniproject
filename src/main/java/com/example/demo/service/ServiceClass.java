package com.example.demo.service;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass {
    @Autowired
    private DoctorRepository repository;

    public Doctor saveDetail(Doctor doctor) {
        Doctor savedRecord = repository.save(doctor);
        System.out.println("Record has been successfully saved");
        return savedRecord;
    }

    public Doctor editDetail(Integer id, Doctor doctor) {
        Doctor savedDetail = repository.findById(id).orElseThrow(() -> {
            throw new CustomException("Record not found for update with id:" + id, "NOT_FOUND");
        });
        savedDetail.setContact(doctor.getContact());
        savedDetail.setEmail(doctor.getEmail());
        savedDetail.setFirstName(doctor.getFirstName());
        savedDetail.setLastName(doctor.getLastName());
        return repository.save(savedDetail);
    }

    public Doctor getDetailById(Integer id) throws CustomException {
        Optional<Doctor> optionalDoctor = repository.findById(id);
        Doctor doctor =optionalDoctor.orElseThrow(()->{
            throw new CustomException("Record not found with id:" + id, "NOT_FOUND");
        });
        return doctor;
    }

    public List<Doctor> getAllDetails() {
        return repository.findAll();
    }

    public void deleteDetail(Integer id) {
        repository.findById(id).orElseThrow(()->{
        throw new CustomException("Record not found for delete with id:" + id, "NOT_FOUND");
        });
        repository.deleteById(id);
    }
}
