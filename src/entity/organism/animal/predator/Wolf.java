package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator implements Runnable {
    public static final String ICON = "\uD83D\uDC3A";
    private static final int PROP_HORSE = 100;
    private static final int PROP_SHEEP = 70;
    private static int food = 0;


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

                System.out.println(number +  " first number");

                removeFromCell(org, cell);
            }
            else if(number <= PROP_SHEEP && org.getModel() == EnumList.SHEEP){
                food += org.getWeight();

                System.out.println(number + " second number");

                removeFromCell(org, cell);
            }
        }

    }

    public Wolf(EnumList model) {
        super(model);
        this.maxStep = 3;
        this.cellAmount = 30;
        this.weight = 120;
        this.FULL_EAT = 250;
    }

    @Override
    public Animal createNewAnimal() {
        return new Wolf(EnumList.WOLF);
    }
}

