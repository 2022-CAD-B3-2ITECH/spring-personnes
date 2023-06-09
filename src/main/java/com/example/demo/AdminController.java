package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AnnuairePersonneService annuairePersonne;

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        return annuairePersonne.getPersonnes();
    }
}
