package com.kd.feedback.services;
import com.kd.feedback.data.PacientsRepository;
import com.kd.feedback.models.Pacients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientsService {

    @Autowired
    private PacientsRepository pacientsRepository;

    public void save(Pacients pacients) {
        pacientsRepository.save(pacients);
    }

    public Pacients getById(Integer id) {
        if (pacientsRepository.existsById(id)) {
            return pacientsRepository.findById(id).get();
        } else return null;
    }

    public List<Pacients> all() {
        return (List<Pacients>) pacientsRepository.findAll();
    }

    public void deleteById(Integer id){
        pacientsRepository.deleteById(id);
    }

}
