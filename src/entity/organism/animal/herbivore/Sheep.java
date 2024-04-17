package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Sheep extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC11";
    private static float food = 0;

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

    public Sheep(EnumList model) {
        super(model);
        this.maxStep = 3;
        this.cellAmount = 140;
        this.weight = 70;
        this.FULL_EAT = 15;
    }

    @Override
    public Animal createNewAnimal() {
        return new Sheep(EnumList.SHEEP);
    }
}


