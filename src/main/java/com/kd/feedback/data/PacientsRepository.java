package com.kd.feedback.data;
import com.kd.feedback.models.Pacients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientsRepository extends CrudRepository<Pacients, Integer> {
}