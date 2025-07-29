/*
    Name: Ioannis Voggelis
    AM: 5733
*/

public class Rabbit extends Animal 
{
    public boolean isRabbit(){
        return true;
    }

    public boolean breedingTime(int time){
        return time % 3 == 0; //3 steps alive
    }

    public Animal giveBirth(){
        return new Rabbit();
    }

    public String toString(){
        return "o";
    }
}