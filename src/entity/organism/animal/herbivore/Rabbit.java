package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Rabbit extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC07";
    private static int food = 0;

    @Override
    public void eat(Organism organism, Cell cell){
        if(food <= FULL_EAT){
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
        this.maxStep = 4;
        this.cellAmount = 140;
        this.weight = 15;
        this.FULL_EAT = 15;
    }

    @Override
    public Animal createNewAnimal() {
        return new Rabbit(EnumList.RABBIT);
    }
}
