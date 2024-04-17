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
    public static final int PROP_HORSE = 40;
    public static final int PROP_SHEEP = 70;


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
        int food = 0;
        if (food <= FULL_EAT) {
            if (number <= PROP_HORSE && org.getModel() == EnumList.HORSE) {
                food += org.getWeight();
                System.out.println(food + " the horse was eaten");
                removeFromCell(org, cell);
            }
            else if(number <= PROP_SHEEP && org.getModel() == EnumList.SHEEP){
                food += org.getWeight();
                System.out.println(food + " the sheep was eaten");
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


