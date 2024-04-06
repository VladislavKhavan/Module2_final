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
    private final Set<Organism> history = new HashSet<>();

    public Cell(Map<EnumList, Set<Organism>> residents) {
        this.residents = residents;
    }

  public synchronized void addOrganism(Organism organism) {
      EnumList model = organism.getModel();
      Set<Organism> organisms = residents.getOrDefault(model, new HashSet<>());
      organisms.add(organism);
      residents.put(model, organisms);
      history.add(organism);
  }

    public void removeOrganism(Organism organism) {
        EnumList type = organism.getModel();
        Set<Organism> organismsOfType = residents.get(type);

        if (organismsOfType != null) {
            if (organismsOfType.contains(organism)) {
                organismsOfType.remove(organism);
                if (organismsOfType.isEmpty()) {
                    residents.remove(type);
                    restoreFromHistory();
                }
            }
        }
    }
    public void restoreFromHistory(){
        for(Organism organism: history){
            if(!residents.containsKey(organism.getModel())){
                addOrganism(organism);
                break;
            }
        }
    }
    public String display() {
        if (residents.isEmpty()) {
            return ".";
        } else {
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
        }
        return "?";
    }
    public String display1() {
        if (residents.isEmpty()) {
            return " ";
        } else {

            StringBuilder sb = new StringBuilder();
            for (Set<Organism> organisms : residents.values()) {
                for(Organism organism: organisms) {
                    sb.append(organism.getIcon());
                }
            }
            return sb.toString();
        }
    }
        public Map<EnumList, Set<Organism>> getResidents () {
            return residents;
        }
    }

