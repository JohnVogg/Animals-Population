import java.util.ArrayList;
import java.util.Collections;


public class Cell
{
    private ArrayList<Cell> neighbors;
    private Animal animal;

    public Cell(){
        this.neighbors = new ArrayList<>();
        this.animal = null;
    }

    public void addNeighbor(Cell neighborCell){
        neighbors.add(neighborCell);
    }

    public Cell getRandomEmptyNeighbor(){
        Collections.shuffle(neighbors);
        for (Cell neighborCell : neighbors){
            if (neighborCell.isEmpty()){
                return neighborCell;
            }
        }
        return null;
    }

    public Cell getRandomRabbitNeighbor(){
        Collections.shuffle(neighbors);
        for (Cell neighborCell : neighbors){
            if (neighborCell.containsRabbit()){
                return neighborCell;
            }
        }
        return null;
    }

    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    public void removeAnimal(){
        this.animal = null;
    }

    public boolean isEmpty(){
        return animal == null;
    }

    public boolean containsRabbit(){
        return animal != null && animal.isRabbit();
    }

    public String toString(){
        if (isEmpty()){
            return "_";
        }else{
            return animal.toString();
        }
    }

    public ArrayList<Cell> getNeighbors(){
        return neighbors;
    }
}
