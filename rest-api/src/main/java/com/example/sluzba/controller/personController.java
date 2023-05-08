package com.example.sluzba.controller;

import com.example.sluzba.model.person;
import com.example.sluzba.service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class personController {

    private final personService person_Service;

    @Autowired
    public personController(personService person_Service) {
        this.person_Service = person_Service;
    }

    @PostMapping("/create")
        public ResponseEntity<person> create(@RequestBody person _person){

            return new ResponseEntity<person>(person_Service.createPerson(_person), HttpStatus.CREATED);
        }

    @GetMapping("/findAll")
    public ResponseEntity<List<person>> find(){

        return new ResponseEntity<List<person>>(person_Service.fetchAllPerson(), HttpStatus.OK);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<person> findOne(@PathVariable int id){
        return new ResponseEntity<person>(person_Service.fetchPerson(id), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<person> update(@RequestBody person _person){
        return new ResponseEntity<person>(person_Service.updatePerson(_person), HttpStatus.CREATED);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return new ResponseEntity<String>(person_Service.deletePerson(id), HttpStatus.ACCEPTED);
    }

}
