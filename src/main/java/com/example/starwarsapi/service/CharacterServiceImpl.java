package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.entity.Specie;
import com.example.starwarsapi.persistence.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Retrieves a character by their ID.
     *
     * @param id The ID of the character to retrieve.
     * @return The Character with the specified ID, or null if not found.
     */
    public Character getCharacterById(Long id) {
        return characterRepository.getCharacterById(id)
                .orElse(null);
    }

    /**
     * Deletes a character by their ID.
     *
     * @param id The ID of the character to delete.
     */
    public void deleteCharacterById(Long id) {
        characterRepository.deleteCharacterById(id);
    }

    /**
     * Retrieves all characters in the database.
     *
     * @return A list of all Characters.
     */
    public List<Character> getAllCharacters() {
        return characterRepository.getAllCharacters()
                .stream()
                .toList();
    }

    /**
     * Creates a new character in the database.
     *
     * @param character The Character to be saved.
     * @return The saved Character.
     */
    public Character createCharacter(Character character) {
        return characterRepository.saveCharacter(character);
    }

    //TODO: Task 1 - Implement the method

    /**
     * Retrieves the heaviest character on a specified planet.
     *
     * @param planetName The name of the planet.
     * @return The heaviest Character on the specified planet, or null if not found.
     */
    public Character getHeaviestCharacterOnPlanet(String planetName) {
        return null;
    }

    //TODO: Task 2 - Fix the method
    /**
     * Retrieves the heaviest character of each species.
     *
     * @return A list of Characters, each representing the heaviest character of their respective species.
     */
    public List<Character> getHeaviestCharacterByEachSpecie() {
        List<Character> characters = characterRepository.getAllCharacters();
        Map<String, Character> heaviestCharacterBySpecie = new HashMap<>();

        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            Specie specie = character.getSpecie();
            String specieName = specie.getName();
            if (heaviestCharacterBySpecie.containsKey(specieName)) {
                heaviestCharacterBySpecie.put(specieName, character);
            } else {
                Character currentHeaviest = heaviestCharacterBySpecie.get(specieName);
                if (currentHeaviest.getMass() < character.getMass()) {
                    heaviestCharacterBySpecie.put(specieName, character);
                }
            }
        }

        return heaviestCharacterBySpecie.values()
                .stream()
                .toList();
    }
}
