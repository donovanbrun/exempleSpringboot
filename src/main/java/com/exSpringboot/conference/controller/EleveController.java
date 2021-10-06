package com.exSpringboot.conference.controller;

import com.exSpringboot.conference.service.EleveService;
import com.exSpringboot.conference.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "eleve")
public class EleveController {

    private final EleveService eleveService;

    @Autowired
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @GetMapping
    public List<Eleve> getAll() {
        return eleveService.getEleves();
    }

    /*
    @GetMapping(path = "{index}")
    public Eleve getOne(@PathVariable int index) {
        return eleveService.getEleve(index);
    }

    @PostMapping
    public void add(@RequestBody Eleve eleve) {
        if (eleve != null) eleveService.addEleve(eleve);
    }

    @DeleteMapping(path = "{index}")
    public void delete(@PathVariable int index) {
        eleveService.deleteEleve(index);
    }
    */
}
