package entity.organism.animal.herbivore;

import abstraction.Reproducible;
import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumHerbivore;
import enum_list.EnumList;
import enum_list.EnumPredator;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public abstract class Herbivore extends Animal {
    public Herbivore(EnumList model) {
        super(model);
    }

    public void eat() {
        int currentX = this.getX();
        int currentY = this.getY();

        Cell cell = field.getCell(currentX, currentY);
        Map<EnumList, Set<Organism>> residents = cell.getResidents();
        Animal herbivore = (Animal) cell.findHerbivoreoinCell(residents);
        Organism organism = cell.findGrassinCell(residents);
        if (herbivore != null && organism != null) {
            switch (herbivore.getModel()) {
                case HORSE:
                    Horse horse = (Horse) herbivore;
                    horse.eat(organism);
                    break;
                case SHEEP:
                    Sheep sheep = (Sheep) herbivore;
                    sheep.eat(organism);
                    break;
            }
            cell.removeOrganism(organism);
        }
    }


}
