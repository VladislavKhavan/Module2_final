package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.predator.Predator;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Buffalo extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC03";
    private static float food = 0;

    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public void eat(Organism organism, Cell cell) {
        if (food <= FULL_EAT) {
            food += Grass.weight;
            removeFromCell(organism, cell);
        }
    }

    public Buffalo(EnumList model) {
        super(model);
        this.maxStep = 3;
        this.cellAmount = 10;
        this.weight = 700;
        this.FULL_EAT = 100;
    }

    @Override
    public Animal createNewAnimal() {
        return new Buffalo(EnumList.BUFFALO);
    }
}
