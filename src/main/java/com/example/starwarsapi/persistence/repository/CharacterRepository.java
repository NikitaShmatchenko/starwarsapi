package com.example.starwarsapi.persistence.repository;

import com.example.starwarsapi.persistence.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    default Optional<Character> getCharacterById(Long id) {
        return findById(id);
    }

    default List<Character> getAllCharacters() {
        return findAll();
    }

    default Character saveCharacter(Character character) {
        return save(character);
    }

    default void deleteCharacterById(Long id) {
        deleteById(id);
    }
}
