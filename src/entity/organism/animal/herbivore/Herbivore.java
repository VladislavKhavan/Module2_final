package entity.organism.animal.herbivore;

import abstraction.Reproducible;
import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumHerbivore;
import enum_list.EnumList;
import enum_list.EnumPredator;

public abstract class Herbivore extends Animal{
    public Herbivore(EnumList model) {
        super(model);
    }
    public void eat() {
        int currentX = this.getX();
        int currentY = this.getY();

        Cell cell = field.getCell(currentX, currentY);
            if (cell.getResidents().containsKey(EnumList.HORSE) && cell.getResidents().containsKey(EnumList.GRASS)) {
                Organism organism = cell.getResidents().get(EnumList.GRASS).iterator().next();
                cell.removeOrganism(organism);
            }


    }


}
