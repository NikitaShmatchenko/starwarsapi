package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.entity.Specie;
import com.example.starwarsapi.persistence.exception.CharacterAlreadyExistsException;
import com.example.starwarsapi.persistence.exception.CharacterNotFoundException;
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
    public Character getCharacterById(Integer id) {
        return characterRepository.getCharacterById(id)
                .orElse(null);
    }

    /**
     * Deletes a character by their ID.
     *
     * @param id The ID of the character to delete.
     */
    public void deleteCharacterById(Integer id) throws CharacterNotFoundException {
        characterRepository.deleteCharacterById(id);
    }

    /**
     * Retrieves all characters.
     *
     * @return A list of all Characters.
     */
    public List<Character> getAllCharacters() {
        return characterRepository.getAllCharacters()
                .stream()
                .toList();
    }

    /**
     * Updates the passed character. If the character doesn't have
     * an id then a new character will be created.
     *
     * @param character The Character to be saved.
     * @return The saved Character.
     */
    public Character updateCharacter(Character character) {
        return characterRepository.updateCharacter(character);
    }

    /**
     * Creates a new character.
     *
     * @param character The Character to be created.
     * @return The created character.
     */
    public Character createCharacter(Character character) throws CharacterAlreadyExistsException {
        return characterRepository.createCharacter(character);
    }

    // TODO: Implement the method
    // Live coding
    // Show not found
    public Character getCharacterByName(String name) {
        return null;
    }

    // TODO: Task 1. Implement the method

    /**
     * Retrieves the character by ID and checks if it belongs to the Wookiee species
     * and their age is greater than or equal to 60 years.
     *
     * @param id The ID of the character.
     * @return true if the character meets the condition, false otherwise.
     */
    public Boolean isCharacterOldWookie(Integer id) {
        return null;
    }

    // TODO: Task 2. Implement the method

    /*ResponseEntity*
     * Retrieves the character by ID and checks if it is taller than the average
     * height of the species it belongs to.
     *
     * @param id The ID of the character.
     * @return true if the character is taller than the average height of its species, false otherwise.
     */
    public Boolean isCharacterTallerThanAverageHeightOfSpecie(Integer id) {
        return false;
    }

    // TODO: Task 3. Implement the method

    /**
     * Calculates the average weight based on the weight of all characters.
     *
     * @return The average weight of all characters.
     */
    public Double getAverageWeightOfAllCharacters() {
        return 0.0;
    }

    // TODO: Task 4. Find and fix the bug

    /**
     * Retrieves the heaviest character of each species.
     *
     * @return A list of Characters, each representing the heaviest character of their respective species.
     */
    public List<Character> getHeaviestCharacterByEachSpecie() {
        List<Character> characters = characterRepository.getAllCharacters();
        Map<String, Character> heaviestCharacterBySpecie = new HashMap<>();

        for (Character character : characters) {
            Specie specie = character.getSpecie();
            String specieName = specie.getName();
            if (heaviestCharacterBySpecie.containsKey(specieName)) {
                heaviestCharacterBySpecie.put(specieName, character);
            } else {
                Character currentHeaviest = heaviestCharacterBySpecie.get(specieName);
                if (currentHeaviest.getWeight() < character.getWeight()) {
                    heaviestCharacterBySpecie.put(specieName, character);
                }
            }
        }

        return heaviestCharacterBySpecie.values()
                .stream()
                .toList();
    }

    // TODO: Task 6. Implement the method. It should return the heaviest character on the specified planet. If there is no such planet, it should return null.
    // TODO: Additionally, you need to create an endpoint (a method in the controller) that will invoke this method and return the proper status code based on the return value of the method.

    /**
     * Retrieves the heaviest character on a specified planet.
     *
     * @param planetName The name of the planet.
     * @return The heaviest Character on the specified planet, or null if not found.
     */
    public Character getHeaviestCharacterOnPlanet(String planetName) {
        return null;
    }
}