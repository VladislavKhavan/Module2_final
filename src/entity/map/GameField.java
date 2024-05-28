package entity.map;

import enum_list.EnumList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


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
                this.cells[i][j] = new Cell(new ConcurrentHashMap<>());
            }
        }
    }

    public int countAll() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAllAnimals();
            }
        }
        return totalAmount;

    }


    public int countGrass() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countGrass();
            }
        }
        return totalAmount;
    }

    public int countAnimalInCell(int x, int y, EnumList AnimalType) {
        return cells[x][y].countAnimalByType(AnimalType);
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                sb.append(cells[i][j].display()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        System.out.println(countGrass() + " total number of grass");
        System.out.println(countAll() + " total number of all animals");
    }
}