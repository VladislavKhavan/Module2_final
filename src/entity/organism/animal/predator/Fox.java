package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Predator implements Runnable {
    public static final String ICON = "\uD83E\uDD8A";
    private static int food = 0;
    public static final int PROP_MOUSE = 40;
    public static final int PROP_RABBIT = 70;
    public static final int PROP_DUCK = 60;
    public static final int PROP_WORM = 40;


    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_DUCK && org.getModel() == EnumList.DUCK) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_WORM && org.getModel() == EnumList.WORM) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_MOUSE && org.getModel() == EnumList.MOUSE) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_RABBIT && org.getModel() == EnumList.RABBIT) {
                food += org.getWeight();
                removeFromCell(org, cell);
            }
        }
    }

    public Fox(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 30;
        this.weight = 8;
        this.FULL_EAT = 2;
    }

    @Override
    public Animal createNewAnimal() {
        return new Fox(EnumList.FOX);
    }
}
