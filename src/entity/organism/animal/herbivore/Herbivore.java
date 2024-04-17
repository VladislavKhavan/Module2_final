package entity.organism.animal.herbivore;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;

import java.util.Map;
import java.util.Set;

public abstract class Herbivore extends Animal {
    public Herbivore(EnumList model) {
        super(model);
    }

    public void eat() {
        int currentX = this.getX();
        int currentY = this.getY();

        Cell cell = field.getCell(currentX, currentY);
        Map<EnumList, Set<Organism>> residents = cell.getResidents();
        Animal herbivore = (Animal) cell.findHerbivoreInCell();
        Organism organism = cell.findGrassinCell(residents);
        if (herbivore != null && organism != null) {
            herbivore.eat(organism, cell);

        }
    }

    protected void removeFromCell(Organism organism, Cell cell) {
        cell.removeOrganism(organism);
    }

}