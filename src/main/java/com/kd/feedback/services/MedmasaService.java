package com.kd.feedback.services;

import com.kd.feedback.data.MedmasaRepository;
import com.kd.feedback.models.Medmasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedmasaService {
    @Autowired
    private MedmasaRepository medmasaRepository;

    public void save(Medmasa medmasa) {
        medmasaRepository.save(medmasa);
    }

    public Medmasa getById(Integer id) {
        if (medmasaRepository.existsById(id)) {
            return medmasaRepository.findById(id).get();
        } else return null;
    }

    public List<Medmasa> all() {
        return (List<Medmasa>) medmasaRepository.findAll();
    }

    public void deleteById(Integer id){
        medmasaRepository.deleteById(id);
    }


}
