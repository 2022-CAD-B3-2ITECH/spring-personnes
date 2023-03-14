package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnuairePersonneService {

    @Autowired
    PersonneRepository personneRepository;

    public List<Personne> getPersonnes() {

        return personneRepository.findAll();
    }

    public void addPersonne(Personne p){
        personneRepository.save(p);
    }

    public Optional<Personne> getOnePersonne(Integer id){
        return personneRepository.findById(id);
    }

    public void updatePersonne(Integer id, Personne personne) {
        personneRepository.save(personne);
    }

    public void deletePersonne(Integer id) {
        personneRepository.deleteById(id);
    }

    public List<Personne> searchByNom(String nom) {
        return personneRepository.findAllByNom(nom);
    }
}
