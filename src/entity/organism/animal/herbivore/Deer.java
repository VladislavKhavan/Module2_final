package entity.organism.animal.herbivore;


import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.plant.Grass;
import enum_list.EnumList;

public class Deer extends Herbivore implements Runnable {
    public static final String ICON = "\uD83E\uDD8C";
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

    public Deer(EnumList model) {
        super(model);
        this.maxStep = 4;
        this.cellAmount = 20;
        this.weight = 300;
        this.FULL_EAT = 50;
    }

    @Override
    public Animal createNewAnimal() {
        return new Deer(EnumList.DEER);
    }
}
