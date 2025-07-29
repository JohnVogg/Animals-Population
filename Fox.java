/*
    Name: Ioannis Voggelis
    AM: 5733
*/

public class Fox extends Animal
{
    private int foodsteps;

    public Fox(){
        foodsteps = 0;
    }

    public boolean isRabbit(){
        return false;
    }

    public boolean breedingTime(int time){
        return time % 8 == 0; //8 steps alive
    }

    public Animal giveBirth(){
        return new Fox();
    }

    public Animal move(){
        Animal eatenRabbit = null;

        Cell foxCell = this.getCell();
        Cell rabbitCell = foxCell.getRandomRabbitNeighbor();
        
        if (rabbitCell != null){
            eatenRabbit = rabbitCell.getAnimal();
            eatenRabbit.die();
            foxCell.removeAnimal();
            rabbitCell.setAnimal(this);
            this.setCell(rabbitCell);
            foodsteps = 0;
            return eatenRabbit;
        }else{ //Doesn't find a rabbit
            foodsteps ++;
            if (foodsteps >= 3){
                this.die();
                return this;
            }
            return super.move();
        }
    }

    public String toString(){
        return "X";
    }
}