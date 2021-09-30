package com.exSpringboot.conference.repository;

import com.exSpringboot.conference.model.Eleve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface EleveRepository extends MongoRepository<Eleve, Long> {
}
