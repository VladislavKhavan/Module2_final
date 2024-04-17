package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.predator.Predator;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Predator implements Runnable {
    public static final String ICON = "\uD83D\uDC0D";
    private static int food = 0;
    public static final int PROP_FOX = 15;

    public static final int PROP_MOUSE = 50;

    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_MOUSE && org.getModel() == EnumList.FOX) {
                food += org.getWeight();
                removeFromCell(org, cell);
            }
        }
    }

    public Boar(EnumList model) {
        super(model);
        this.maxStep = 1;
        this.cellAmount = 30;
        this.weight = 15;
        this.FULL_EAT = 3;
    }

    @Override
    public Animal createNewAnimal() {
        return new Boar(EnumList.BOAR);
    }
}
