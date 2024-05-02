package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.map.GameField;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Herbivore implements Runnable {
    public static final String ICON = "🐎";
    private static float food = 0;

    @Override
    public void eat(Organism organism, Cell cell){
        if(food <= FULL_EAT){
            food += Grass.weight;
            removeFromCell(organism, cell);
        }
    }

    @Override
    public String getIcon() {
        return ICON;
    }


    public Horse(EnumList model) {
        super(model);
        this.maxStep = 4;
        this.cellAmount = 20;
        this.weight = 400;
        this.FULL_EAT = 60;
    }

    @Override
    public Animal createNewAnimal() {
        return new Horse(EnumList.HORSE);
    }
}
