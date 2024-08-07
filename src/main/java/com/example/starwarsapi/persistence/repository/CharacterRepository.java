package com.example.starwarsapi.persistence.repository;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.exception.CharacterAlreadyExistsException;
import com.example.starwarsapi.persistence.exception.CharacterNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    Optional<Character> getCharacterById(Integer id);

    List<Character> getAllCharacters();

    Character updateCharacter(Character character);

    Character createCharacter(Character character) throws CharacterAlreadyExistsException;

    void deleteCharacterById(Integer id) throws CharacterNotFoundException;
}
