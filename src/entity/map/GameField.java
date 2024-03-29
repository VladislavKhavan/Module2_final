package entity.map;

import entity.organism.Organism;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import enum_list.EnumList;

import java.lang.reflect.Type;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class GameField {
    private int width;
    private int height;
    private Cell[][] cells = new Cell[width][height];
    Random random = new Random();

    public GameField(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        initialize(cells);

    }
    public void initialize(Cell[][] cells){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                cells[i][j] = new Cell(new HashMap<>());
            }
        }
    }
    public void addOrganism(int countOfOrganism){
        EnumSet<EnumList> organisms = EnumSet.allOf(EnumList.class);
        EnumList[] enumLists = organisms.toArray(new EnumList[0]);


        for(int i = 0; i < countOfOrganism; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            EnumList randomElement = enumLists[random.nextInt(enumLists.length)];
            Organism organism = createOrganism(randomElement);

            cells[x][y].addOrganism(organism);
        }
    }
    public Organism createOrganism(EnumList enumList) {
        switch (enumList){
            case BEAR :
                return new Bear(EnumList.BEAR);
            case HORSE:
                return new Horse(EnumList.HORSE);
            default:
            throw new IllegalArgumentException("Unknown type of organism");
        }
    }
    public void displayField(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                System.out.print(cells[i][j].display() + " ");
            }
            System.out.println();
        }
    }

    public Cell[][] getCells(){
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
