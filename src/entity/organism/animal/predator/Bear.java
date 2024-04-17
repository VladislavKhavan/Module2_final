package entity.organism.animal.predator;

import abstraction.Movable;
import entity.map.Cell;
import entity.map.GameField;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import enum_list.EnumList;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator implements Runnable {
    public static final String ICON = "🐻";
    public static final int PROP_BOA = 80;
    public static final int PROP_HORSE = 40;
    public static final int PROP_DEER = 80;
    public static final int PROP_RABBIT = 80;
    public static final int PROP_MOUSE = 90;
    public static final int PROP_GOAT = 70;
    public static final int PROP_SHEEP = 70;
    public static final int PROP_DUCK = 10;
    public static final int PROP_BOAR = 50;
    public static final int PROP_BUFFALO = 20;
    private static float food = 0;


    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public Animal createNewAnimal() {
        return new Bear(EnumList.BEAR);
    }

    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_HORSE && org.getModel() == EnumList.HORSE) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_BOA && org.getModel() == EnumList.BOA) {
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
            } else if (number <= PROP_DUCK && org.getModel() == EnumList.DUCK) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_BOAR && org.getModel() == EnumList.BOAR) {
                food += org.getWeight();
                removeFromCell(org, cell);
            } else if (number <= PROP_BUFFALO && org.getModel() == EnumList.BUFFALO) {
                food += org.getWeight();
                removeFromCell(org, cell);
            }
        }
    }

    public Bear(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 5;
        this.weight = 500;
        this.FULL_EAT = 80;
    }
}


