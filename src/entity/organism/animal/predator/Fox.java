package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Predator implements Runnable {
    public static final String ICON = "\uD83E\uDD8A";
    private static int food = 0;
    public static final int PROP_HORSE = 40;
    public static final int PROP_SHEEP = 70;


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
            }
            else if(number <= PROP_SHEEP && org.getModel() == EnumList.SHEEP){
                food += org.getWeight();
                removeFromCell(org, cell);
            }
        }
    }

    public Fox(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 5;
        this.weight = 500;
        this.FULL_EAT = 80;
    }

    @Override
    public Animal createNewAnimal() {
        return new Fox(EnumList.FOX);
    }
}