import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.animals.*;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Farm farm = createFarm();

        //This code is also unnecessary, but it's maintain for no reason.
        Animal[] animals = new Animal[farm.getAnimals().size()];
        farm.getAnimals().toArray(animals);
        Main.singAnimals(animals);


        farm.work().forEach(product -> product.printProduct());
    }



    private static void singAnimals(Animal[] animalBox){
        for(Animal animal : animalBox){
            animal.makeSound();
            System.out.println(animal.getGender());
            System.out.println("-----------------");
        }
    }

    private static void showAnimals(ArrayList animals){
        Iterator it = animals.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getClass().toString());
        }
    }

    private static Farm createFarm(){
        Farmer farmer = new Farmer(Gender.MALE, "Bob");
        Farm farm = new Farm(5, farmer);
        HenHouse henHouse = createHenHouse();
        ArrayList<Building> buildings= new ArrayList<Building>();
        buildings.add(henHouse);
        farm.setBuildings(buildings);

        //I leave this section bus it's not my code, the project already included it, so i think this is
        //the best place to be. Feel free to delete it in any moment

        Animal[] animals = new Animal[4];
        Chicken gallina = new Chicken(Gender.FEMALE);
        Duck pato = new Duck(Gender.MALE);
        Dog doggo = new Dog(Gender.MALE);
        Cat cat = new Cat(Gender.FEMALE);


        animals[0] = gallina;
        animals[1] = pato;
        animals[2] = doggo;
        animals[3] = cat;

        for(Animal animal: animals) {
            farm.getAnimals().add(animal);
        }

        return farm;
    }

    private static HenHouse createHenHouse(){
        HenHouse henHouse = new HenHouse(40);
        for (int i = 0 ; i < 40*0.7 -1; i++) {
            henHouse.addAnimal(new Chicken(Gender.FEMALE, "RED"));
        }
        henHouse.addAnimal(new Chicken(Gender.FEMALE, "WHITE"));
        henHouse.addAnimal(new Chicken(Gender.FEMALE, "WHITE"));
        for (int i = 0 ; i < 40*0.3 -2; i++) {
            henHouse.addAnimal(new Chicken(Gender.FEMALE, "WHITE"));
        }
        henHouse.addAnimal(new Chicken(Gender.FEMALE, "RED"));
        return henHouse;

    }
}
