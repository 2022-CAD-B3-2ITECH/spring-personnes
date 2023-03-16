package com.example.demo.mvc;

import com.example.demo.AnnuairePersonneService;
import com.example.demo.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    AnnuairePersonneService annuairePersonneService;

    @GetMapping("hello")
    public String hello(Model model){

        List<Personne> personnes = annuairePersonneService.getPersonnes();

        model.addAttribute("name", "Jean-Christophe");
        model.addAttribute("personnes", personnes);
        return "hello.html"; //return "hello";
    }
}
