package com.kd.feedback.services;

import com.kd.feedback.data.DokumentsRepository;
import com.kd.feedback.models.Dokuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DokumentsService {
    @Autowired
    private DokumentsRepository dokumentsRepository;

    public void save(Dokuments dokuments) {
        dokumentsRepository.save(dokuments);
    }

    public Dokuments getById(Integer id) {
        if (dokumentsRepository.existsById(id)) {
            return dokumentsRepository.findById(id).get();
        } else return null;
    }

    public List<Dokuments> all() {
        return (List<Dokuments>) dokumentsRepository.findAll();
    }

    public void deleteById(Integer id){
       dokumentsRepository.deleteById(id);
    }
}
