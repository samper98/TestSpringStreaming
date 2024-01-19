package org.generation.italy.testspring.repository;

import org.generation.italy.testspring.model.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttoreRepository extends JpaRepository<Attore,Integer> {
 
}
