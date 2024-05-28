package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator implements Runnable {
    public static final String ICON = "\uD83D\uDC3A";
    private static float food = 0;
    public static final int PROP_HORSE = 10;
    public static final int PROP_SHEEP = 70;
    public static final int PROP_DEER = 15;
    public static final int PROP_RABBIT = 60;
    public static final int PROP_MOUSE = 80;
    public static final int PROP_GOAT = 60;
    public static final int PROP_BOAR = 15;
    public static final int PROP_BUFFALO = 10;
    public static final int PROP_DUCK = 40;

    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_HORSE && org.getModel() == EnumList.HORSE) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_DEER && org.getModel() == EnumList.DEER) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_RABBIT && org.getModel() == EnumList.RABBIT) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_MOUSE && org.getModel() == EnumList.MOUSE) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_GOAT && org.getModel() == EnumList.GOAT) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_BOAR && org.getModel() == EnumList.BOAR) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_BUFFALO && org.getModel() == EnumList.BUFFALO) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_DUCK && org.getModel() == EnumList.DUCK) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_SHEEP && org.getModel() == EnumList.SHEEP) {
                food += org.getWeight();
                removeFromCell(org, cell);
            }
        }
    }

    public Wolf(EnumList model) {
        super(model);
        this.maxStep = 3;
        this.cellAmount = 30;
        this.weight = 50;
        this.FULL_EAT = 8;
    }


    @Override
    public Animal createNewAnimal() {
        return new Wolf(EnumList.WOLF);
    }
}

