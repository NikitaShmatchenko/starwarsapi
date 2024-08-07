package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.exception.CharacterAlreadyExistsException;
import com.example.starwarsapi.persistence.exception.CharacterNotFoundException;

import java.util.List;

public interface CharacterService {

    Character getCharacterById(Integer id);

    Character getCharacterByName(String name);

    void deleteCharacterById(Integer id) throws CharacterNotFoundException;

    List<Character> getAllCharacters();

    Character createCharacter(Character character) throws CharacterAlreadyExistsException;

    Character updateCharacter(Character character);

    Boolean isCharacterOldWookie(Integer id);

    Boolean isCharacterTallerThanAverageHeightOfSpecie(Integer id);

    Double getAverageWeightOfAllCharacters();

    Character getHeaviestCharacterOnPlanet(String planet);

    List<Character> getHeaviestCharacterByEachSpecie();
}
