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

    // TODO méthode gérant la requête d'accès à un élève grâce à son index dans la liste

    // TODO méthode gérant la requête l'ajout d'une élève

    // TODO méthode gérant la requête de suppression d'un élève grâce à son index dans la liste

    // TODO méthode gérant la requête d'accès à la liste des délègués
}
