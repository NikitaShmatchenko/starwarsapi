package com.example.starwarsapi.controller;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Integer id) {
        Character character = characterService.getCharacterById(id);
        if(character == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(character);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    //TODO add age validation
    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        boolean characterDeleted = characterService.deleteCharacterById(id);
        if (!characterDeleted) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/isCharacterOldWookie/{id}")
    public ResponseEntity<Boolean> isCharacterAnOldWookie(@PathVariable Long id) {
        Boolean isCharacterAnOldWookie = characterService.isCharacterOldWookie(id);
        if(isCharacterAnOldWookie == null) {
            return ResponseEntity.status(404).body(null);
        }
            return ResponseEntity.status(200).body(isCharacterAnOldWookie);
    }

    @GetMapping("/isCharacterTallerThanAverageHeightOfSpecie/{id}")
    public ResponseEntity<Boolean> isCharacterTallerThanAverageHeightOfSpecie(@PathVariable Long id) {
        Boolean isCharacterTaller = characterService.isCharacterTallerThanAverageHeightOfSpecie(id);
        if(isCharacterTaller == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(isCharacterTaller);
    }

    @GetMapping("/heaviestBySpecie")
    public ResponseEntity<List<Character>> getHeaviestCharacterByEachSpecie() {
        return ResponseEntity.status(200).body(characterService.getHeaviestCharacterByEachSpecie());
    }
}
