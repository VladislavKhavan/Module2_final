package entity.map;

import entity.organism.Organism;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<EnumList, Set<Organism>> residents;
    private GameField field;


    public Cell(Map<EnumList, Set<Organism>> residents) {
        this.residents = residents;
    }

    public synchronized void addOrganism(Organism organism) {
        EnumList model = organism.getModel();
        Set<Organism> organisms = residents.getOrDefault(model, new HashSet<>());
        organisms.add(organism);
        residents.put(model, organisms);
    }

    public void removeOrganism(Organism organism) {
        EnumList type = organism.getModel();
        Set<Organism> organismsOfType = residents.get(type);

        if (organismsOfType != null && organismsOfType.contains(organism)) {
            organismsOfType.remove(organism);
            if (organismsOfType.isEmpty()) {
                residents.remove(type);
                if (residents.isEmpty()) {
                    addOrganism(new Grass(EnumList.GRASS));
                }
            }
        }
    }
    public String display() {
        for (EnumList key : residents.keySet()) {
            if (key != null) {
                switch (key) {
                    case BEAR:
                        return Bear.ICON;
                    case HORSE:
                        return Horse.ICON;
                    case GRASS:
                        return Grass.ICON;
                }
            }
        }

        return "?";
    }

    public Map<EnumList, Set<Organism>> getResidents() {
        return residents;
    }
}

