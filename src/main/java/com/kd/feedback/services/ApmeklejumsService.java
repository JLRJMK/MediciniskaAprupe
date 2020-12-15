package com.kd.feedback.services;

import com.kd.feedback.data.ApmeklejumsRepository;
import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Medmasa;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApmeklejumsService {

    @Autowired
    private ApmeklejumsRepository apmeklejumsRepository;

    public void save(Apmeklejums apmeklejums) {
      apmeklejumsRepository.save(apmeklejums);
    }

    public Apmeklejums getById(Integer id) {
        if (apmeklejumsRepository.existsById(id)) return apmeklejumsRepository.findById(id).get();
        else return null;
    }

    public List<Apmeklejums> all() {
        return (List<Apmeklejums>) apmeklejumsRepository.findAll();
    }

    public void deleteById(Integer id){
        apmeklejumsRepository.deleteById(id);
    }
}
