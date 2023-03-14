package com.example.demo;

public class PersonneMapper {


    Personne convertToEntity(PersonneDTO dto){
        Personne entity = new Personne();
        entity.setNom(dto.getNom());
        // ...
        return entity;
    }
}
