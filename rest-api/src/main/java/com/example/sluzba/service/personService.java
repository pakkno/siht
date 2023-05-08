package com.example.sluzba.service;

import com.example.sluzba.model.person;
import com.example.sluzba.repository.personRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class personService {

    private final personRepository person_Repository;
    @Autowired
    public personService(personRepository person_Repository) {
        this.person_Repository = person_Repository;
    }

    public person createPerson(person _person){
        return person_Repository.save(_person);
    }

    public List<person> fetchAllPerson(){
        return person_Repository.findAll();
    }
    public person fetchPerson(int id){

        return person_Repository.findById(id).get();
    }

    public person updatePerson(@NonNull person _person){
        person selectedPerson = fetchPerson(_person.getId());

        if(selectedPerson != null && selectedPerson.getName()!=null && selectedPerson.getEmail()!=null){
            selectedPerson.setName(_person.getName());
            selectedPerson.setEmail(_person.getEmail());
            person_Repository.save(selectedPerson);
        }
        return _person;
    }

    public String deletePerson(@NonNull int id){
        person_Repository.deleteById(id);

        return "Person deleted";
    }
}
