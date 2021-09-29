package com.exSpringboot.conference.controller;

import com.exSpringboot.conference.manager.EleveManager;
import com.exSpringboot.conference.model.Eleve;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "eleve")
public class EleveController {

    private final EleveManager eleveManager;

    public EleveController(EleveManager eleveManager) {
        this.eleveManager = eleveManager;
    }

    @GetMapping
    public List<Eleve> getAll() {
        return eleveManager.getEleves();
    }

    @GetMapping(path = "{index}")
    public Eleve getOne(@PathVariable int index) {
        return eleveManager.getEleve(index);
    }

    @PostMapping
    public void add(@RequestBody Eleve eleve) {
        if (eleve != null) eleveManager.addEleve(eleve);
    }

    @DeleteMapping(path = "{index}")
    public void delete(@PathVariable int index) {
        eleveManager.deleteEleve(index);
    }
}
