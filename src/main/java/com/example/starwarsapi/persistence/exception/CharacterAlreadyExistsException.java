package com.example.starwarsapi.persistence.exception;

public class CharacterAlreadyExistsException extends RuntimeException {

    public CharacterAlreadyExistsException(String message) {
        super(message);
    }
}
