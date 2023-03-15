package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;

    @ManyToMany
    private List<Personne> stagiaires = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Personne> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Personne> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public void addStagiaire(Personne stagiaire){
        stagiaires.add(stagiaire);
    }
}
