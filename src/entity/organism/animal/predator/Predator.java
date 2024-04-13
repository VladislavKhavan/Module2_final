package entity.organism.animal.predator;

import entity.map.Cell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import enum_list.EnumList;
import game_simulation.GameSimulation;

import java.util.Map;
import java.util.Set;


public abstract class Predator extends Animal {
    public Predator(EnumList model) {
        super(model);
    }

    protected void removeFromCell(Organism organism, Cell cell) {
        cell.removeOrganism(organism);
        GameSimulation.removeAnimal((Animal) organism);
    }

    public void eat() {
        int currentX = this.getX();
        int currentY = this.getY();
        Cell cell = field.getCell(currentX, currentY);
        Map<EnumList, Set<Organism>> residents = cell.getResidents();
        Animal predator1 = cell.findPredatorInCell(residents);
        Organism herbivore = cell.findHerbivoreoinCell(residents);
        if (predator1 != null && herbivore != null) {
            switch (predator1.getModel()) {
                case BEAR:
                    Bear predator = (Bear) predator1;
                    predator.eat(herbivore, cell);
                    break;
                case WOLF:
                    Wolf predator2 = (Wolf) predator1;
                    predator2.eat(herbivore, cell);
                    break;
                default:
                    break;
            }
        }

    }


}



