package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC01";
    public static final int PROP_WORM = 90;
    private static int food = 0;

    @Override
    public void eat(Organism org, Cell cell) {
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if (food <= FULL_EAT) {
            if (number <= PROP_WORM && org.getModel() == EnumList.WORM) {
                food += org.getWeight();
                removeFromCellA(org, cell);
            } else if (org.getModel() == EnumList.GRASS) {
                food = Grass.weight;
                removeFromCell(org, cell);

            }
        }
    }

    @Override
    public String getIcon() {
        return ICON;
    }

    public Mouse(EnumList model) {
        super(model);
        this.maxStep = 1;
        this.cellAmount = 500;
        this.weight = 0.05F;
        this.FULL_EAT = 0.01F;
    }

    @Override
    public Animal createNewAnimal() {
        return new Mouse(EnumList.MOUSE);
    }
}
