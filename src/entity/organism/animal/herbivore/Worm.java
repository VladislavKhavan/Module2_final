package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Worm extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC1B";
    private static float food = 0;

    @Override
    public void eat(Organism organism, Cell cell) {
        if (food <= FULL_EAT) {
            food += Grass.weight;
            removeFromCell(organism, cell);
        }
    }

    @Override
    public String getIcon() {
        return ICON;
    }

    public Worm(EnumList model) {
        super(model);
        this.maxStep = 0;
        this.cellAmount = 1000;
        this.weight = 0.01F;
        this.FULL_EAT = 0;
    }

    @Override
    public Animal createNewAnimal() {
        return new Worm(EnumList.WORM);
    }
}