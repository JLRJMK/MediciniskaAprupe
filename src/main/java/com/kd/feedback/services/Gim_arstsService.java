package com.kd.feedback.services;

import com.kd.feedback.data.Gim_arstsRepository;
import com.kd.feedback.models.Gim_arsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Gim_arstsService {

    @Autowired
    private Gim_arstsRepository gim_arstsRepository;

    public void save(Gim_arsts gim_arsts) {
        gim_arstsRepository.save(gim_arsts);
    }

    public Gim_arsts getById(Integer id) {
        if (gim_arstsRepository.existsById(id)) {
            return gim_arstsRepository.findById(id).get();
        } else return null;
    }

    public List<Gim_arsts> all() {
        return (List<Gim_arsts>) gim_arstsRepository.findAll();
    }

    public void deleteById(Integer id){
       gim_arstsRepository.deleteById(id);
    }
}
