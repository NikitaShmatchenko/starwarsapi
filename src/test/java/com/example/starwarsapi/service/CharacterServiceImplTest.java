package com.example.starwarsapi.service;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.entity.Planet;
import com.example.starwarsapi.persistence.entity.Specie;
import com.example.starwarsapi.persistence.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceImplTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterServiceImpl characterService;

    @Test
    void getHeaviestCharacterByEachSpecie() {
        Specie specie = new Specie();
        specie.setName("Human");
        Character char1 = new Character();
        char1.setSpecie(specie);
        char1.setName("Luke Skywalker");
        char1.setMass(77);
        Character char2 = new Character();
        char2.setSpecie(specie);
        char2.setName("Leia Organa");
        char2.setMass(49);
        Specie specie2 = new Specie();
        specie.setName("Droid");
        Character char3 = new Character();
        char3.setSpecie(specie2);
        char3.setName("C-3PO");
        char3.setMass(75);
        Character char4 = new Character();
        char4.setSpecie(specie2);
        char4.setName("R2-D2");
        char4.setMass(32);

        when(characterRepository.getAllCharacters()).thenReturn(List.of(char1, char2, char3, char4));

        List<Character> result = characterService.getHeaviestCharacterByEachSpecie();

        verify(characterRepository).getAllCharacters();
        assertThat(result).containsOnly(char1, char3);
    }

    @Test
    void getHeaviestCharacterOnPlanet() {
        String planetName = "Tatooine";
        Planet planet = new Planet();
        planet.setName(planetName);
        Character char1 = new Character();
        char1.setPlanet(planet);
        char1.setName("Luke Skywalker");
        char1.setMass(77);
        Character char2 = new Character();
        char2.setPlanet(planet);
        char2.setName("Leia Organa");
        char2.setMass(49);
        Character char3 = new Character();
        char3.setPlanet(planet);
        char3.setName("C-3PO");
        char3.setMass(75);

        when(characterRepository.getAllCharacters()).thenReturn(List.of(char1, char2, char3));

        Character result = characterService.getHeaviestCharacterOnPlanet(planetName);

        verify(characterRepository).getAllCharacters();
        assertThat(result).isEqualTo(char1);
    }
}
