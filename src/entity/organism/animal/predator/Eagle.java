package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Eagle extends Predator implements Runnable {
    public static final String ICON = "\uD83E\uDD85";
    private static float food = 0;

    public static final int PROP_FOX = 10;
    public static final int PROP_RABBIT = 90;
    public static final int PROP_MOUSE = 90;
    public static final int PROP_DUCK = 80;


    @Override
    public String getIcon() {
        return ICON;
    }


    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_FOX && org.getModel() == EnumList.FOX) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_RABBIT && org.getModel() == EnumList.RABBIT) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_MOUSE && org.getModel() == EnumList.MOUSE) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_DUCK && org.getModel() == EnumList.DUCK) {
                food += org.getWeight();
                removeFromCell(org, cell);
            }


        }
    }

    public Eagle(EnumList model) {
        super(model);
        this.maxStep = 3;
        this.cellAmount = 20;
        this.weight = 6;
        this.FULL_EAT = 1;
    }

    @Override
    public Animal createNewAnimal() {
        return new Eagle(EnumList.EAGLE);
    }
}


