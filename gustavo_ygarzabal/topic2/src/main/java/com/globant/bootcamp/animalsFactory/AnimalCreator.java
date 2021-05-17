package com.globant.bootcamp.animalsFactory;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.enums.Gender;

public interface AnimalCreator {
    public abstract Animal createAnimal(Gender gender);
}
