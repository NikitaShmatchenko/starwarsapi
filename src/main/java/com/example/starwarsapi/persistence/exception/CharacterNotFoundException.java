package com.example.starwarsapi.persistence.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Integer id) {
        super("A character with such id was not found. [id: %s]".formatted(id));
    }
}
