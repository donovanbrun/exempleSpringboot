package com.exSpringboot.conference.manager;

import com.exSpringboot.conference.model.Eleve;
import com.exSpringboot.conference.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EleveManager {

    //private ArrayList<Eleve> eleves;
    private EleveRepository eleveRepository;

    @Autowired
    public EleveManager(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
        /*
        eleves = new ArrayList<Eleve>();
        eleves.add(new Eleve("ATHIMON", "Clément", false));
        eleves.add(new Eleve("BARTHELME", "Justine", false));
        eleves.add(new Eleve("BESTARD", "Erwann", false));
        eleves.add(new Eleve("BIDET", "Emilien", false));
        eleves.add(new Eleve("BIZET", "Titouan", false));
        eleves.add(new Eleve("BRUN", "Donovan", false));
        eleves.add(new Eleve("CARPIO", "Jules", false));
        eleves.add(new Eleve("DALA", "Gertrudes", false));
        eleves.add(new Eleve("DILLENSEGER", "Théo", false));
        eleves.add(new Eleve("FOUILLÉ", "Justine", true));
        eleves.add(new Eleve("GEY", "Nathanaël", false));
        eleves.add(new Eleve("HAMON", "Thomas", false));
        eleves.add(new Eleve("HANNON", "Fabien", false));
        eleves.add(new Eleve("HOULES", "Matthis", false));
        eleves.add(new Eleve("KUMAR", "Aman", false));
        eleves.add(new Eleve("LAFON", "Pierre", false));
        eleves.add(new Eleve("LECOLAZET", "Aymeric", false));
        eleves.add(new Eleve("LEMOINE", "Aurélie", false));
        eleves.add(new Eleve("LEROYER", "Pierre", true));
        eleves.add(new Eleve("MAYSTRE", "Antonin", false));
        eleves.add(new Eleve("ORDRENNEAU", "Matteo", false));
        eleves.add(new Eleve("PARVIZ", "Mariam", false));
        eleves.add(new Eleve("PERIQUOI", "Yoann", false));
        eleves.add(new Eleve("PREKA", "Bruno", false));
        eleves.add(new Eleve("RAAPOTO", "Gabin", false));
        eleves.add(new Eleve("REIG", "Julien", false));
        eleves.add(new Eleve("SIGNE-MORICE", "Luka", false));
        eleves.add(new Eleve("SMARA", "Yassine", false));
        eleves.add(new Eleve("SUARD", "Maël", false));
        eleves.add(new Eleve("VAUTIER", "Paul", false));
        eleves.add(new Eleve("WANG", "Ting", false));
         */
    }
    /*
    public List<Eleve> getEleves() {
        return eleves;
    }

    public Eleve getEleve(int index) {
        if (index < eleves.size()) return eleves.get(index);
        return null;
    }

    public void addEleve(Eleve eleve) {
        if (eleve != null) eleves.add(eleve);
    }

    public void deleteEleve(int index) {
        if (index < eleves.size()) eleves.remove(index);
    }
    */

    public List<Eleve> getEleves() {
        return eleveRepository.findAll();
    }

    public Eleve getEleve(int index) {
        if (index < eleveRepository.count()) return eleveRepository.findAll().get(index);
        return null;
    }

    public void addEleve(Eleve eleve) {
        if (eleve != null) eleveRepository.insert(eleve);
    }

    public void deleteEleve(int index) {
        if (index < eleveRepository.count()) eleveRepository.delete(eleveRepository.findAll().get(index));
    }
}
