package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AdresseRepository adresseRepository;
	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	StageRepository stageRepository;

	@Test
	void testAdresseRepository() {
		Adresse adresse = new Adresse();
		adresse.setRue("rue de la mairie");
		adresseRepository.save(adresse);

		Personne alain = new Personne("Alain", "Delon");
		alain.setAdresse(adresse);
		personneRepository.save(alain);
	}

	@Test
	void testSelect() {
		Optional<Personne> op = personneRepository.findById(7);
		if(op.isPresent()){
			Personne alain = op.get();
			System.out.println(alain.getAdresse());
		}
	}

	@Test
	void testStage(){
		Personne alain = new Personne("Alain", "Delon");
		personneRepository.save(alain);

		Personne marie = new Personne("Marie", "Delon");
		personneRepository.save(marie);

		Stage stage1 = new Stage();
		stage1.setTitre("Stage Salsa");
		stage1.addStagiaire(alain);
		stage1.addStagiaire(marie);
		stageRepository.save(stage1);


		Stage stage2 = new Stage();
		stage2.setTitre("Stage mécanique");
		stage2.addStagiaire(alain);
		stageRepository.save(stage2);
	}
}
