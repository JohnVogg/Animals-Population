/*
    Name: Ioannis Voggelis
    AM: 5733
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class AnimalSimulator
{
    private HashSet<Animal> animals;
    private int NUM_OF_FOXES = 5;
    private int NUM_OF_RABBITS = 100;

    public AnimalSimulator(){

    }

    public void populate(Grid grid){
        //Add foxes
        for (int i = 0; i < NUM_OF_FOXES; i++){
            Fox fox = new Fox();
            grid.addAnimal(fox);
            animals.add(fox);
            
        }
        //Add rabbits
        for (int i = 0; i < NUM_OF_RABBITS; i++){
            Rabbit rabbit = new Rabbit();
            grid.addAnimal(rabbit);
            animals.add(rabbit);
        }
    }

    public void moveAndBreedAnimals(int time){
        ArrayList<Animal> listOfAnimals = new ArrayList<>(animals);
        Collections.shuffle(listOfAnimals);

        HashSet<Animal> deadAnimals = new HashSet<>();
        HashSet<Animal> newAnimals = new HashSet<>();

        for (Animal animal : listOfAnimals){
            if (deadAnimals.contains(animal)){
                continue; //Skip dead animals
            }
            Animal findDeadAnimal = animal.move();

            if (findDeadAnimal != null){
                deadAnimals.add(findDeadAnimal);
            }

            if (animal.breedingTime(time) && !deadAnimals.contains(animal)){
                Animal newAnimal = animal.breed();
                if (newAnimal != null){
                    newAnimals.add(newAnimal);
                }
            }
        }

        animals.removeAll(deadAnimals); //Remove all dead animals
        animals.addAll(newAnimals); //Add all new animals
    }

    public void printPopulations(){
        int rabbitsCounter = 0;
        int foxesCounter = 0;

        for (Animal animal : animals){
            if (animal.isRabbit()){
                rabbitsCounter ++;
            }else{
                foxesCounter ++;
            }
        }
        System.out.println("Rabbits: " + rabbitsCounter + "\nFoxes: " + foxesCounter);
    }
}