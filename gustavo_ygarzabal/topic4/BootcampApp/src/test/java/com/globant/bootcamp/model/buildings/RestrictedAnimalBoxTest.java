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
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RestrictedAnimalBoxTest {
    int capacity = 7;
    RestrictedAnimalBox<Animal> restrictedAnimalBox;
    ArrayList<Animal> animals;
    ArrayList<Animal> allowed;

    @BeforeEach
    void initTest() {
        restrictedAnimalBox = new RestrictedAnimalBox<>();
        animals = new ArrayList<>(Arrays.asList(
                new Chicken(Gender.FEMALE, EggColor.WHITE),
                new Dog(Gender.MALE),
                new Chicken(Gender.MALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED)));
        allowed = new ArrayList<>(Arrays.asList(
                new Dog(Gender.MALE),
                new Chicken(Gender.MALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED),
                new Chicken(Gender.FEMALE, EggColor.RED)));
    }

    @Test
    void setAllowedAnimals() {
        restrictedAnimalBox.setAllowedAnimals(allowed);
        assertEquals(3, restrictedAnimalBox.getAllowedAnimals().size());
        assertTrue(restrictedAnimalBox.getAllowedAnimals().contains(new Dog(Gender.MALE)));
        assertTrue(restrictedAnimalBox.getAllowedAnimals().contains(new Chicken(Gender.MALE, EggColor.RED)));
        assertTrue(restrictedAnimalBox.getAllowedAnimals().contains(new Chicken(Gender.FEMALE, EggColor.RED)));

    }

    @Test
    void isAllowed() {
        restrictedAnimalBox.setAllowedAnimals(allowed);
        assertFalse(restrictedAnimalBox.isAllowed(new Chicken(Gender.FEMALE, EggColor.WHITE)));
        assertTrue(restrictedAnimalBox.isAllowed(new Chicken(Gender.FEMALE, EggColor.RED)));
        assertTrue(restrictedAnimalBox.isAllowed(new Chicken(Gender.MALE, EggColor.RED)));
        assertTrue(restrictedAnimalBox.isAllowed(new Dog(Gender.MALE)));
        assertFalse(restrictedAnimalBox.isAllowed(new Dog(Gender.FEMALE)));
        assertFalse(restrictedAnimalBox.isAllowed(new Cat(Gender.FEMALE)));
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, 7})
    void addAnimal(int capacity) {
        restrictedAnimalBox.setAllowedAnimals(allowed);
        restrictedAnimalBox.setCapacity(capacity);
        if(capacity==0){
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            assertEquals(0, restrictedAnimalBox.getAnimals().size());
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            assertEquals(0, restrictedAnimalBox.getAnimals().size());
        }
        if(capacity == 1) {
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            restrictedAnimalBox.addAnimal(new Dog(Gender.MALE));
            assertEquals(1 , restrictedAnimalBox.getAnimals().size());
            assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), restrictedAnimalBox.getAnimals().get(0));

        }
        if (capacity == 7) {
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            restrictedAnimalBox.addAnimal(new Dog(Gender.MALE));
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            assertEquals(3 , restrictedAnimalBox.getAnimals().size());
            assertTrue(restrictedAnimalBox.getAnimals().contains(new Chicken(Gender.FEMALE, EggColor.RED)));
            assertTrue(restrictedAnimalBox.getAnimals().contains(new Dog(Gender.MALE)));
        }
    }

    @Test
    void addAllowedAnimal() {
        restrictedAnimalBox.addAllowedAnimal(new Dog(Gender.MALE));
        assertEquals(new Dog(Gender.MALE), restrictedAnimalBox.getAllowedAnimals().get(0));

        restrictedAnimalBox.addAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        restrictedAnimalBox.addAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, restrictedAnimalBox.getAllowedAnimals().size());
        assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), restrictedAnimalBox.getAllowedAnimals().get(1));

        restrictedAnimalBox.addAllowedAnimal(new Chicken(Gender.MALE, EggColor.RED));
        assertEquals(3, restrictedAnimalBox.getAllowedAnimals().size());
        assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), restrictedAnimalBox.getAllowedAnimals().get(1));

    }

    @Test
    void removeAllowedAnimal() {
        restrictedAnimalBox.setAllowedAnimals(allowed);

        restrictedAnimalBox.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
        assertEquals(3, restrictedAnimalBox.getAllowedAnimals().size());

        restrictedAnimalBox.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, restrictedAnimalBox.getAllowedAnimals().size());

        restrictedAnimalBox.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, restrictedAnimalBox.getAllowedAnimals().size());
    }

    @Test
    void isAllowedAndNotFull() {
        //No capacity && Allowed
        restrictedAnimalBox.setAllowedAnimals(allowed);
        assertFalse(restrictedAnimalBox.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));

        //Capacity && Allowed
        restrictedAnimalBox.setCapacity(1);
        assertTrue(restrictedAnimalBox.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));
        //No capacity && not allowed
        assertFalse(restrictedAnimalBox.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.WHITE)));

        //No capacity && not allowed
        restrictedAnimalBox.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertFalse(restrictedAnimalBox.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));
    }

    @Test
    void countRepetitions() {
        assertEquals(0, restrictedAnimalBox.countRepetitions(new Dog(Gender.MALE)));

        restrictedAnimalBox.setAllowedAnimals(allowed);
        restrictedAnimalBox.setCapacity(7);
        restrictedAnimalBox.setAnimals(animals);

        assertEquals(3, restrictedAnimalBox.countRepetitions(new Chicken(Gender.FEMALE, EggColor.RED)));
        assertEquals(0, restrictedAnimalBox.countRepetitions(new Chicken(Gender.FEMALE, EggColor.WHITE)));
        assertEquals(1, restrictedAnimalBox.countRepetitions(new Dog(Gender.MALE)));
    }
}