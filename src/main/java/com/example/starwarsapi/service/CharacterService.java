package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;

import java.util.List;

public interface CharacterService {

    Character getCharacterById(Long id);
    void deleteCharacterById(Long id);

    List<Character> getAllCharacters();

    Character createCharacter(Character character);

    Character getHeaviestCharacterOnPlanet(String planet);

    List<Character> getHeaviestCharacterByEachSpecie();
}
