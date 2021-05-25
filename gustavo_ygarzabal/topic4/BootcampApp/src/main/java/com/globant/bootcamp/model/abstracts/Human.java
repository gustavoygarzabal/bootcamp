package com.globant.bootcamp.model.abstracts;

import com.globant.bootcamp.model.enums.Gender;
import com.globant.bootcamp.model.interfaces.Aquatic;
import com.globant.bootcamp.model.interfaces.HumanBeing;
import com.globant.bootcamp.model.interfaces.Terrestrial;

public abstract class Human extends Animal<Human> implements HumanBeing<Human>, Terrestrial, Aquatic {

    public Human(Gender gender) {
        super(gender);
    }

    @Override
    public void walk() {
        System.out.println("Mover las piernas");
    }

    @Override
    public void swing() {
        System.out.println("Mover los pies y los brazos");
    }
}
