package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore implements Runnable {
    public static final String ICON = "\uD83E\uDD86";
    private static float food = 0;
    public static int PROP_WORM = 90;

    @Override
    public void eat(Organism org, Cell cell){
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if(food <= FULL_EAT){
            if (number <= PROP_WORM && org.getModel() == EnumList.MOUSE) {
                food += org.getWeight();
                removeFromCellA(org, cell);
            }

            else if(org.getModel() == EnumList.GRASS) {
                food += Grass.weight;
                removeFromCell(org, cell);
            }
        }
    }

    @Override
    public String getIcon() {
        return ICON;
    }

    public Duck(EnumList model) {
        super(model);
        this.maxStep = 4;
        this.cellAmount = 200;
        this.weight = 1;
        this.FULL_EAT = 0.15F;
    }

    @Override
    public Animal createNewAnimal() {
        return new Duck(EnumList.DUCK);
    }
}
