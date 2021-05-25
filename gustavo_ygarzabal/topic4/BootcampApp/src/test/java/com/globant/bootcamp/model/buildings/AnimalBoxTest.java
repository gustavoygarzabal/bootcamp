package com.globant.bootcamp.model.buildings;


import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.animals.Cat;
import com.globant.bootcamp.model.animals.Chicken;
import com.globant.bootcamp.model.animals.Dog;
import com.globant.bootcamp.model.enums.EggColor;
import com.globant.bootcamp.model.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalBoxTest {
    int capacity = 7;
    AnimalBox<Animal> animalBox;
    ArrayList<Animal> animals;

    @BeforeEach
    void initTest() {
        animalBox = new AnimalBox<>();
        animals = new ArrayList<>(Arrays.asList(
                new Chicken(Gender.FEMALE, EggColor.WHITE),
                new Dog(Gender.MALE),
                new Dog(Gender.FEMALE),
                new Chicken(Gender.FEMALE, EggColor.RED),
                new Chicken(Gender.MALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED)));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "-1, 0",
            "1, 1",
            "10, 10"
    })
    void setCapacity(int input, int expected) {
        animalBox.setCapacity(input);
        assertEquals(expected, animalBox.getCapacity());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 7})
    void setAnimals(int capacity){
        animalBox.setCapacity(capacity);
        animalBox.setAnimals(animals);
        assertEquals(animals.subList(0, capacity), animalBox.getAnimals());
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 7, 8})
    void isNotFull(int capacity) {
        animalBox.setCapacity(capacity);

        if(capacity == 0){
            assertFalse(animalBox.isNotFull());
        }
    }

    @Test
    void removeAnimal() {
        animalBox.setCapacity(capacity);
        animalBox.setAnimals(animals);

        animalBox.removeAnimal(new Dog(Gender.MALE));
        assertNotEquals(new Dog(Gender.MALE),animalBox.getAnimals().get(1));
        assertEquals(capacity-1, animalBox.getAnimals().size());

        animalBox.removeAnimal(new Dog(Gender.MALE));
        assertEquals(new Dog(Gender.FEMALE),animalBox.getAnimals().get(1));
        assertEquals(capacity-1, animalBox.getAnimals().size());

        animalBox.removeAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(new Chicken(Gender.MALE, EggColor.RED),animalBox.getAnimals().get(2));
        assertEquals(capacity-2, animalBox.getAnimals().size());
    }

    @Test
    void countRepetitions() {
        animalBox.setCapacity(capacity);
        animalBox.setAnimals(animals);

        assertEquals(1, animalBox.countRepetitions(new Dog(Gender.MALE)));
        assertEquals(3, animalBox.countRepetitions(new Chicken(Gender.FEMALE, EggColor.RED)));
        assertEquals(1, animalBox.countRepetitions(new Chicken(Gender.FEMALE, EggColor.WHITE)));
        assertEquals(0, animalBox.countRepetitions(new Cat(Gender.MALE)));
    }
}