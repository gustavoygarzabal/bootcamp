package com.globant.bootcamp.model.animalsFactory;

import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.enums.Gender;


public interface AnimalCreator {
    public Animal createAnimal(Gender gender);
}
