public abstract class Animal 
{
    private Cell cellOfAnimal;

    public abstract boolean isRabbit();
    public abstract boolean breedingTime(int time);
    public abstract Animal giveBirth();

    public void setCell(Cell cellOfAnimal){
        this.cellOfAnimal = cellOfAnimal;
    }

    public Cell getCell(){
        return cellOfAnimal;
    }

    public void die(){
        if (cellOfAnimal != null){
            cellOfAnimal.removeAnimal();
        }
    }

    public Animal move(){
        Cell currentCell = this.getCell();
        Cell nextCell = currentCell.getRandomEmptyNeighbor();
        if (nextCell != null){
            currentCell.removeAnimal(); 
            nextCell.setAnimal(this);
            this.setCell(nextCell);
        }
        return null;
    }

    public Animal breed(){
        Cell cellForBirth = this.getCell().getRandomEmptyNeighbor();
        if (cellForBirth != null){
            Animal babyAnimal = giveBirth();
            babyAnimal.setCell(cellForBirth);
            cellForBirth.setAnimal(babyAnimal);
            return babyAnimal;
        }
        return null;
    }

    public String toString(){
        return "*";
    }
}
