package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.predator.Predator;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC0D";
    private static float food = 0;

    public static final int PROP_MOUSE = 50;
    public static final int PROP_WORM = 90;

    @Override
    public String getIcon() {
        return ICON;
    }

    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_MOUSE && org.getModel() == EnumList.MOUSE) {
                food += org.getWeight();
                removeFromCellA(org, cell);
            } else if (number <= PROP_WORM && org.getModel() == EnumList.WORM) {
                food += org.getWeight();
                removeFromCellA(org, cell);
            } else if (org.getModel() == EnumList.GRASS) {
                food += Grass.weight;
                removeFromCell(org, cell);
            }
        }
    }

    public Boar(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 50;
        this.weight = 400;
        this.FULL_EAT = 50;
    }

    @Override
    public Animal createNewAnimal() {
        return new Boar(EnumList.BOAR);
    }
}
