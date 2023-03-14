package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonneController {

    @Autowired
    AnnuairePersonneService annuairePersonne;

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        return annuairePersonne.getPersonnes();
    }

    @PostMapping("personnes")
    public void postPersonne(@RequestBody Personne newPersonne){
        System.out.println(newPersonne);
        annuairePersonne.addPersonne(newPersonne);
    }

    @GetMapping("personnes/{id}")
    public ResponseEntity<Personne> getOnePersonne(@PathVariable("id") Integer id){
        Optional<Personne> optional = annuairePersonne.getOnePersonne(id);
        if(optional.isEmpty()){
            // status code : 404
            return ResponseEntity.notFound().build();
        } else {
            Personne p = optional.get();
            return ResponseEntity.ok(p);
        }
    }

    @PutMapping("personnes/{id}")
    public void updatePersonne(@PathVariable("id") Integer id, @RequestBody Personne personne){
        Optional<Personne> op = annuairePersonne.getOnePersonne(id);
        if(op.isPresent()) {
            annuairePersonne.updatePersonne(id, personne);
        }
    }

    @DeleteMapping("personnes/{id}")
    public void deletePersonne(@PathVariable("id") Integer id){
        annuairePersonne.deletePersonne(id);
    }

    // Query param
    // searchByNom?nom=delon
    @GetMapping("searchByNom")
    public List<Personne> searchByNom(@RequestParam String nom){
        return annuairePersonne.searchByNom(nom);
    }
}
