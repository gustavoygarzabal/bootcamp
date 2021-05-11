import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.buildings.Building;
import com.globant.bootcamp.buildings.Farm;
import com.globant.bootcamp.buildings.HenHouse;
import com.globant.bootcamp.buildings.HenHouseCreator;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.roles.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Farm farm = Farm.getInstance();

       //Method already implemented and use, i mantain it. It could be deleted
        Animal[] animals = new Animal[farm.getAnimals().size()];
        farm.getAnimals().toArray(animals);
        singAnimals(animals);


        HenHouse henHouse = (HenHouse) new HenHouseCreator().createBuilding((int)(40*0.7),(int)(40*0.3));
        ArrayList<Building> buildings = new ArrayList<>();
        buildings.add(henHouse);

        farm.setBuildings(buildings);
        farm.work();
        farm.getProducts().forEach(product -> product.printProduct());
    }


// I think it should go as a Farm public non static method
    private static void singAnimals(Animal[] animalBox){
        for(Animal animal : animalBox){
            animal.makeSound();
            System.out.println(animal.getGender());
            System.out.println("-----------------");
        }
    }

    private static void showAnimals(ArrayList animals){
        animals.forEach(animal -> animal.getClass().toString());
    }

}
