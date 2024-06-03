package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;

import java.util.List;

public interface CharacterService {

    Character getCharacterById(Integer id);
    boolean deleteCharacterById(Integer id);

    List<Character> getAllCharacters();

    Character createCharacter(Character character);

    Boolean isCharacterOldWookie(Integer id);

    Boolean isCharacterTallerThanAverageHeightOfSpecie(Integer id);
    Double getAverageWeightOfAllCharacters();
    Character getHeaviestCharacterOnPlanet(String planet);

    List<Character> getHeaviestCharacterByEachSpecie();
}
