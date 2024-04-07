package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

public abstract class Predator extends Animal {
    public Predator(EnumList model) {
        super(model);
    }

    public void eat(){
        int currentX = this.getX();
        int currentY = this.getY();

        Cell cell = field.getCell(currentX, currentY);
        if(cell.getResidents().containsKey(EnumList.BEAR) && cell.getResidents().containsKey(EnumList.HORSE)){
            Organism organism = cell.getResidents().get(EnumList.HORSE).iterator().next();
            cell.removeOrganism(organism);
        }
    }

}


