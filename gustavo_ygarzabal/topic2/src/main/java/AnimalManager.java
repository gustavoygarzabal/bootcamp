import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;

public abstract class AnimalManager extends AnimalBox{
    private ArrayList<Animal> allowedAnimals = new ArrayList<Animal>();

    public ArrayList<Animal> getAllowedAnimals() {
        return allowedAnimals;
    }

    public void setAllowedAnimals(ArrayList<Animal> allowedAnimals) {
        this.allowedAnimals = allowedAnimals;
    }

    public boolean isAllowed(Animal animal){
        return this.getAllowedAnimals().contains(animal);
    }

    @Override
    public void addAnimal(Animal animal){
        if(isAddable(animal)){
            this.getAnimals().add(animal);
        }
    }

    public void addAllowedAnimal(Animal animal){
        this.allowedAnimals.add(animal);
    }

    public void removeAllowedAnimal(Animal animal){
        this.getAllowedAnimals().remove(animal);
    }

    public boolean isAddable(Animal animal){
        return isNotFull() && isAllowed(animal);
    }
}
