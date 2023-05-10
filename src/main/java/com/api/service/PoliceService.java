package com.api.service;

import com.api.entity.Police;

import java.util.List;

public interface PoliceService {
    public Police createPolice(Police police);
    public List<Police> getAllPolice();
    public Police updateName(Police police);

    Police fetchPoliceById(Long policeId);

    void deletePoliceById(Long policeId);
}
