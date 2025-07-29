import java.util.Random;


public class Grid 
{
    private final int SIZE = 20;
    private Cell[][] cells;
    private Random luck;

    public Grid(){
        luck = new Random();
        
        cells = new Cell[SIZE][SIZE]; //Create the gird
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                cells[i][j] = new Cell();
            }
        }

        //Connection of cells(Add neighbors)
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (i > 0){
                    cells[i][j].addNeighbor(cells[i-1][j]);
                    cells[i-1][j].addNeighbor(cells[i][j]);
                }
                if (j > 0){
                    cells[i][j].addNeighbor(cells[i][j-1]);
                    cells[i][j-1].addNeighbor(cells[i][j]);
                }
            }
        }
    }

    public void addAnimal(Animal animal){
        int i = luck.nextInt(SIZE);
        int j = luck.nextInt(SIZE);
        while (!cells[i][j].isEmpty()){ //In order to find an empty cell
            i = luck.nextInt(SIZE);
            j = luck.nextInt(SIZE);
        }
        cells[i][j].setAnimal(animal);
        animal.setCell(cells[i][j]);
    }

    public String toString(){
        String gridAppearance = "";
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j ++){
                gridAppearance += cells[i][j] + " ";
            }
            gridAppearance += "\n";
        }
        return gridAppearance;
    }
}
