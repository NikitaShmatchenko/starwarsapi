package com.example.starwarsapi.controller;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
    }

    @GetMapping("/heaviestOnPlanet/{planet}")
    public Character getHeaviestCharacterByPlanet(@PathVariable String planet) {
        return characterService.getHeaviestCharacterOnPlanet(planet);
    }

    @GetMapping("/heaviestBySpecie")
    public List<Character> getHeaviestCharacterByEachSpecie() {
        return characterService.getHeaviestCharacterByEachSpecie();
    }
}
