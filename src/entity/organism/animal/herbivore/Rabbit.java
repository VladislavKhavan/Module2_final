package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Rabbit extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC07";
    private static float food = 0;

    @Override
    public void eat(Organism organism, Cell cell) {
        if (food <= FULL_EAT) {
            food += Grass.weight;
            removeFromCell(organism, cell);
        }
    }

    @Override
    public String getIcon() {
        return ICON;
    }


    public Rabbit(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 150;
        this.weight = 2;
        this.FULL_EAT = 0.45F;
    }

    @Override
    public Animal createNewAnimal() {
        return new Rabbit(EnumList.RABBIT);
    }
}
