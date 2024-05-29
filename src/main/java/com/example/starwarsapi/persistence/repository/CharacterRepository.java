package com.example.starwarsapi.persistence.repository;

import com.example.starwarsapi.persistence.entity.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    Optional<Character> getCharacterById(Integer id);

    List<Character> getAllCharacters();

    Character saveCharacter(Character character);

    boolean deleteCharacterById(Integer id);
}
