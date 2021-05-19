import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.buildings.Farm;
import com.globant.bootcamp.buildings.FarmCreator;
import com.globant.bootcamp.buildings.HenHouseCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Farm farm = new FarmCreator().createBuilding(5);
        System.out.println(farm.getCapacity());
        logger.debug("Getting the farm instance");

        farm.addBuilding(new HenHouseCreator().createBuilding((int)(40*0.7),(int)(40*0.3)));
        farm.work();
        logger.info(farm.showProducts());


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
