package entity.organism.animal.herbivore;

import entity.organism.Organism;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Sheep extends Herbivore implements Runnable {
    public static final String ICON = "\uD83D\uDC11";
    private static int food = 0;

    public void eat(Organism organism){
        if(food <= FULL_EAT){
            food += Grass.weight;
        }

    }

    @Override
    public String getIcon() {
        return ICON;
    }

    public Sheep(EnumList model) {
        super(model);
        this.maxStep = 4;
        this.cellAmount = 20;
        this.weight = 120;
        this.FULL_EAT = 15;
    }
}


