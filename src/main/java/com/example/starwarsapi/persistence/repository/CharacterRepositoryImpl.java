package com.example.starwarsapi.persistence.repository;

import com.example.starwarsapi.persistence.entity.Character;
import com.example.starwarsapi.persistence.entity.Planet;
import com.example.starwarsapi.persistence.entity.Specie;
import com.example.starwarsapi.persistence.exception.CharacterAlreadyExistsException;
import com.example.starwarsapi.persistence.exception.CharacterNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CharacterRepositoryImpl implements CharacterRepository {

    Map<Integer, Character> characters = getMockedCharacters();

    @Override
    public Optional<Character> getCharacterById(Integer id) {
        return Optional.ofNullable(characters.get(id));
    }

    @Override
    public List<Character> getAllCharacters() {
        return characters.values()
                .stream()
                .toList();
    }

    @Override
    public Character updateCharacter(Character character) {
        int key = generateId(character);
        character.setId(key);
        characters.put(key, character);
        return character;
    }

    @Override
    public Character createCharacter(Character character) throws CharacterAlreadyExistsException {
        Integer key = generateId(character);
        Character persistedCharacter = characters.get(key);
        if (persistedCharacter != null) {
            throw new CharacterAlreadyExistsException("A character with such id already exists. [id: %s]".formatted(key));
        }
        if (isCharacterNameNotUnique(character.getName())) {
            throw new CharacterAlreadyExistsException("A character with such name already exists. [name: %s]".formatted(character.getName()));
        }
        character.setId(key);
        characters.put(key, character);
        return character;
    }

    @Override
    public void deleteCharacterById(Integer id) throws CharacterNotFoundException {
        Optional.ofNullable(characters.remove(id))
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    private Integer generateId(Character character) {
        return Optional.ofNullable(character.getId())
                .orElseGet(() -> characters.keySet().stream()
                        .max(Comparator.comparingInt(Integer::intValue))
                        .map(i -> i + 1)
                        .orElse(1));
    }

    private boolean isCharacterNameNotUnique(String name) {
        return characters.values().stream()
                .anyMatch(c -> c.getName().equals(name));
    }

    private static Map<Integer, Character> getMockedCharacters() {
        Planet tatooine = new Planet(12500, "Arid", "Tatooine", "Desert");
        Planet naboo = new Planet(10465, "Temperate", "Naboo", "Grassy hills, swamps, forests, mountains");
        Planet kashyyyk = new Planet(10750, "Temperate", "Kashyyyk", "Forests, jungles");
        Planet corellia = new Planet(11000, "Temperate", "Corellia", "Urban, plains");
        Planet nalHutta = new Planet(12220, "Swampy", "Nal Hutta", "Swamps");
        Planet stewjon = new Planet(12350, "Temperate", "Stewjon", "Forests, plains");
        Planet coruscant = new Planet(10400, "Urban", "Coruscant", "Cityscape");
        Planet dathomir = new Planet(10850, "Misty", "Dathomir", "Swamps, forests");
        Planet alderaan = new Planet(11300, "Temperate", "Alderaan", "Grasslands, mountains");
        Planet monCala = new Planet(10200, "Aquatic", "Mon Cala", "Oceans");
        Planet bespin = new Planet(10550, "Temperate", "Bespin", "Gas giant");
        Planet endor = new Planet(10700, "Temperate", "Endor", "Forests");
        Planet kamino = new Planet(11500, "Rainy", "Kamino", "Oceans");

        Specie human = new Specie(170, "Galactic Basic", "Human");
        Specie hutt = new Specie(300, "Huttese", "Hutt");
        Specie wookiee = new Specie(200, "Shyriiwook", "Wookiee");
        Specie droid = new Specie(96, "Binary", "Droid");
        Specie zabrak = new Specie(180, "Zabraki", "Zabrak");
        Specie gungan = new Specie(190, "Gunganese", "Gungan");
        Specie monCalamari = new Specie(160, "Mon Calamari", "Mon Calamari");
        Specie ewok = new Specie(100, "Ewokese", "Ewok");
        Specie kaminoan = new Specie(220, "Kaminoan", "Kaminoan");

        Map<Integer, Character> characters = new HashMap<>();
        characters.put(1, new Character(1, 172, 77, 19, tatooine, human, "Luke Skywalker"));
        characters.put(3, new Character(3, 165, 45, 27, naboo, human, "Padmé Amidala"));
        characters.put(4, new Character(4, 228, 112, 200, kashyyyk, wookiee, "Chewbacca"));
        characters.put(13, new Character(13, 228, 112, 60, kashyyyk, wookiee, "Lowbacca"));
        characters.put(5, new Character(5, 180, 80, 35, corellia, human, "Han Solo"));
        characters.put(6, new Character(6, 305, 1358, 600, nalHutta, hutt, "Jabba the Hutt"));
        characters.put(7, new Character(7, 182, 77, 57, stewjon, human, "Obi-Wan Kenobi"));
        characters.put(8, new Character(8, 202, 120, 45, tatooine, human, "Darth Vader"));
        characters.put(9, new Character(9, 96, 32, 32, naboo, droid, "R2-D2"));
        characters.put(10, new Character(10, 193, 89, 48, coruscant, human, "Qui-Gon Jinn"));
        characters.put(11, new Character(11, 175, 80, 52, dathomir, zabrak, "Darth Maul"));
        characters.put(12, new Character(12, 196, 66, 30, naboo, gungan, "Jar Jar Binks"));
        characters.put(14, new Character(14, 150, 49, 19, alderaan, human, "Leia Organa"));
        characters.put(15, new Character(15, 180, 70, 64, monCala, monCalamari, "Admiral Ackbar"));
        characters.put(16, new Character(16, 175, 70, 32, tatooine, human, "Shmi Skywalker"));
        characters.put(17, new Character(17, 178, 72, 53, coruscant, human, "Mace Windu"));
        characters.put(19, new Character(19, 165, 60, 33, bespin, human, "Lando Calrissian"));
        characters.put(20, new Character(20, 100, 50, 12, endor, ewok, "Wicket W. Warrick"));
        characters.put(21, new Character(21, 230, 80, 40, kamino, kaminoan, "Taun We"));
        characters.put(22, new Character(22, 175, 75, 45, tatooine, human, "Owen Lars"));
        characters.put(23, new Character(23, 163, 50, 43, tatooine, human, "Beru Lars"));
        return characters;
    }
}
