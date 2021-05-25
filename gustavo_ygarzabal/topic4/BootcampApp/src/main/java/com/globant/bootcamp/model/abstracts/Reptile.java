package com.globant.bootcamp.model.abstracts;

import com.globant.bootcamp.model.animals.Egg;
import com.globant.bootcamp.model.enums.Gender;

public abstract class Reptile extends Animal<Egg> {

    public Reptile(Gender gender) {
        super(gender);
    }
}
