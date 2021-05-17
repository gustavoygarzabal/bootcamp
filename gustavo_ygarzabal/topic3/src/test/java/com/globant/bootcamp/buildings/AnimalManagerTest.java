package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.animals.Cat;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Dog;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;
import net.bytebuddy.asm.MemberAttributeExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalManagerTest {
    int capacity = 7;
    AnimalManager animalManager;
    ArrayList<Animal> animals;
    ArrayList<Animal> allowed;

    @BeforeEach
    void initTest() {
        animalManager = new AnimalManager();
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
        animalManager.setAllowedAnimals(allowed);
        assertEquals(3, animalManager.getAllowedAnimals().size());
        assertTrue(animalManager.getAllowedAnimals().contains(new Dog(Gender.MALE)));
        assertTrue(animalManager.getAllowedAnimals().contains(new Chicken(Gender.MALE, EggColor.RED)));
        assertTrue(animalManager.getAllowedAnimals().contains(new Chicken(Gender.FEMALE, EggColor.RED)));

    }

    @Test
    void isAllowed() {
        animalManager.setAllowedAnimals(allowed);
        assertFalse(animalManager.isAllowed(new Chicken(Gender.FEMALE, EggColor.WHITE)));
        assertTrue(animalManager.isAllowed(new Chicken(Gender.FEMALE, EggColor.RED)));
        assertTrue(animalManager.isAllowed(new Chicken(Gender.MALE, EggColor.RED)));
        assertTrue(animalManager.isAllowed(new Dog(Gender.MALE)));
        assertFalse(animalManager.isAllowed(new Dog(Gender.FEMALE)));
        assertFalse(animalManager.isAllowed(new Cat(Gender.FEMALE)));
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, 7})
    void addAnimal(int capacity) {
        animalManager.setAllowedAnimals(allowed);
        animalManager.setCapacity(capacity);
        if(capacity==0){
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            assertEquals(0, animalManager.getAnimals().size());
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            assertEquals(0, animalManager.getAnimals().size());
        }
        if(capacity == 1) {
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            animalManager.addAnimal(new Dog(Gender.MALE));
            assertEquals(1 , animalManager.getAnimals().size());
            assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), animalManager.getAnimals().get(0));

        }
        if (capacity == 7) {
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
            animalManager.addAnimal(new Dog(Gender.MALE));
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
            assertEquals(3 , animalManager.getAnimals().size());
            assertTrue(animalManager.getAnimals().contains(new Chicken(Gender.FEMALE, EggColor.RED)));
            assertTrue(animalManager.getAnimals().contains(new Dog(Gender.MALE)));
        }
    }

    @Test
    void addAllowedAnimal() {
        animalManager.addAllowedAnimal(new Dog(Gender.MALE));
        assertEquals(new Dog(Gender.MALE), animalManager.getAllowedAnimals().get(0));

        animalManager.addAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        animalManager.addAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, animalManager.getAllowedAnimals().size());
        assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), animalManager.getAllowedAnimals().get(1));

        animalManager.addAllowedAnimal(new Chicken(Gender.MALE, EggColor.RED));
        assertEquals(3, animalManager.getAllowedAnimals().size());
        assertEquals(new Chicken(Gender.FEMALE, EggColor.RED), animalManager.getAllowedAnimals().get(1));

    }

    @Test
    void removeAllowedAnimal() {
        animalManager.setAllowedAnimals(allowed);

        animalManager.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.WHITE));
        assertEquals(3, animalManager.getAllowedAnimals().size());

        animalManager.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, animalManager.getAllowedAnimals().size());

        animalManager.removeAllowedAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertEquals(2, animalManager.getAllowedAnimals().size());
    }

    @Test
    void isAllowedAndNotFull() {
        //No capacity && Allowed
        animalManager.setAllowedAnimals(allowed);
        assertFalse(animalManager.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));

        //Capacity && Allowed
        animalManager.setCapacity(1);
        assertTrue(animalManager.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));
        //No capacity && not allowed
        assertFalse(animalManager.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.WHITE)));

        //No capacity && not allowed
        animalManager.addAnimal(new Chicken(Gender.FEMALE, EggColor.RED));
        assertFalse(animalManager.isAllowedAndNotFull(new Chicken(Gender.FEMALE, EggColor.RED)));
    }

    @Test
    void countRepetitions() {
        assertEquals(0, animalManager.countRepetitions(new Dog(Gender.MALE)));

        animalManager.setAllowedAnimals(allowed);
        animalManager.setCapacity(7);
        animalManager.setAnimals(animals);

        assertEquals(3, animalManager.countRepetitions(new Chicken(Gender.FEMALE, EggColor.RED)));
        assertEquals(0, animalManager.countRepetitions(new Chicken(Gender.FEMALE, EggColor.WHITE)));
        assertEquals(1, animalManager.countRepetitions(new Dog(Gender.MALE)));
    }
}