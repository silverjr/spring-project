package com.api.service;

import com.api.entity.Police;
import com.api.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceServiceImp implements PoliceService{

    @Autowired
    PoliceRepository policeRepository;

    public Police createPolice(Police police) {
        return policeRepository.save(police);
    }

    @Override
    public List<Police> getAllPolice() {
        return policeRepository.findAll();
    }

    @Override
    public Police updateName(Police police) {
       return null;
    }

    @Override
    public Police fetchPoliceById(Long policeId) {
        return policeRepository.findById(policeId).get();
    }

    @Override
    public void deletePoliceById(Long policeId) {
        policeRepository.deleteById(policeId);
    }
}
