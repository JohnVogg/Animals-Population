/*
    Name: Ioannis Voggelis
    AM: 5733
*/

import java.util.Scanner;


public class Simulation
{   
    public static void main(String[] args){
        int SIMULATION_STEPS = 1000;
        Grid mainGrid = new Grid();
        AnimalSimulator mainAnimalSimulator = new AnimalSimulator();
        mainAnimalSimulator.populate(mainGrid);
        Scanner input = new Scanner(System.in);
        
        for (int step = 1; step <= SIMULATION_STEPS; step++){
            System.out.println(mainGrid);
            mainAnimalSimulator.printPopulations();
            System.out.print("Press enter continue to the next step" + "(" + (step + 1) + "): ");
            input.nextLine();
            mainAnimalSimulator.moveAndBreedAnimals(step);
        }

        //Show the final state of the grid
        System.out.println(mainGrid);
        mainAnimalSimulator.printPopulations();
    }
}