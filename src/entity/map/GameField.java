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

    public int countHorse() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAnimalByType(EnumList.HORSE);
            }
        }
        return totalAmount;
    }

    public int countBear() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAnimalByType(EnumList.BEAR);
            }
        }
        return totalAmount;
    }

    public int countSheep() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAnimalByType(EnumList.SHEEP);
            }
        }
        return totalAmount;
    }
    public int countBoa() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAnimalByType(EnumList.BOA);
            }
        }
        return totalAmount;
    }

    public int countWolf() {
        int totalAmount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = getCell(i, j);
                totalAmount += cell.countAnimalByType(EnumList.WOLF);
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

        System.out.println(countHorse() + " total number of horses");
        System.out.println(countBear() + " total number of bears");
        System.out.println(countGrass() + " total number of grass");

        System.out.println(countSheep() + " total number of sheeps");
        System.out.println(countWolf() + " total number of wolfs");
        System.out.println(countBoa() + " total number of boas");


    }
}