import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.animals.*;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Farm farm = Farm.getInstance();


        farm.setDemoConfig(5, new Farmer(Gender.MALE, "Bob"));

       //Method already implemented and use, i mantain it. It could be deleted
        Animal[] animals = new Animal[farm.getAnimals().size()];
        farm.getAnimals().toArray(animals);
        Main.singAnimals(animals);


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
