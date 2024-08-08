package com.example.starwarsapi.controller;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars-api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Integer id) {
        Character character = characterService.getCharacterById(id);
        if (character == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(character);
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return ResponseEntity.status(200).body(characterService.getAllCharacters());
    }

    //TODO Task 5. Add age validation. The method should check that the age of the character being created is more than 0 years old and less than or equal to 1000 years old and return BAD_REQUEST status if the validation fails.
    //TODO Task 7. Add exception handling.
    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return ResponseEntity.status(200).body(characterService.createCharacter(character));
    }

    @PutMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
        return ResponseEntity.status(200).body(characterService.updateCharacter(character));
    }

    //TODO Task 7. Add exception handling.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/{id}/is-character-old-wookie")
    public ResponseEntity<Boolean> isCharacterAnOldWookie(@PathVariable Integer id) {
        Boolean isCharacterAnOldWookie = characterService.isCharacterOldWookie(id);
        if (isCharacterAnOldWookie == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(isCharacterAnOldWookie);
    }

    @GetMapping("/average-weight")
    public ResponseEntity<Double> getAverageWeight() {
        Double averageWeight = characterService.getAverageWeightOfAllCharacters();
        return ResponseEntity.status(200).body(averageWeight);
    }

    @GetMapping("/{id}/is-taller-than-average-specie")
    public ResponseEntity<Boolean> isCharacterTallerThanAverageHeightOfSpecie(@PathVariable Integer id) {
        Boolean isCharacterTaller = characterService.isCharacterTallerThanAverageHeightOfSpecie(id);
        if (isCharacterTaller == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(isCharacterTaller);
    }

    @GetMapping("/heaviest-by-specie")
    public ResponseEntity<List<Character>> getHeaviestCharacterByEachSpecie() {
        return ResponseEntity.status(200).body(characterService.getHeaviestCharacterByEachSpecie());
    }
}
