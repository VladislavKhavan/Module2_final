package entity.map;

import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class GameField {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Cell[][] cells = new Cell[width][height];

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

    }

    public void initialize() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.cells[i][j] = new Cell(new HashMap<>());
            }
        }
    }

    public boolean isPositionValid(int X, int Y) {
        return X >= 0 && X < width && Y >= 0 && Y < height;
    }

    public void displayField() {
        for (int i = 0; i < width; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height; j++) {
                sb.append(cells[i][j].display()).append(" ");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            System.out.println(sb.toString());
        }
    }

    public int countBear() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i ,j);
                totalAmount += cell.countAnimal();
            }
        }
        return totalAmount;
    }
    public int countGrass() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i ,j);
                totalAmount += cell.countGrass();
            }
        }
        return totalAmount;
    }

    public void print() {
        Cell cell = getCell(0, 0);
        Cell cell1 = getCell(8, 8);
        Cell cell2 = getCell(9, 9);
        for (int i = 0; i < width; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height; j++) {
                sb.append(cells[i][j].display()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        System.out.println(cell.countAnimal() + " animal");
        System.out.println(cell1.countAnimal() + " animal");
        System.out.println(cell2.countAnimal() + " animal");
        System.out.println(cell.countGrass() + " grass");
        System.out.println(cell.countGrass() + " grass");
        System.out.println(cell.countGrass() + " grass");
        System.out.println(countGrass() + " Grass");

    }

}