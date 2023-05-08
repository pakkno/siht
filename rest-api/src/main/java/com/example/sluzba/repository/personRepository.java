package com.example.sluzba.repository;

import com.example.sluzba.model.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepository extends JpaRepository<person, Integer> {
}
