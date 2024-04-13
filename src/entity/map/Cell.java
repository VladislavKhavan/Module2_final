package entity.map;

import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.herbivore.Sheep;
import entity.organism.animal.predator.Bear;
import entity.organism.animal.predator.Wolf;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static enum_list.EnumList.SHEEP;


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

    public synchronized void removeOrganism(Organism organism) {
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
    public Animal findPredatorInCell(Map<EnumList, Set<Organism>> residents) {
        // Example logic: find the first animal that can act as a predator
        for (EnumList type : residents.keySet()) {
            if (isPredatorType(type)) {
                Set<Organism> organisms = residents.get(type);
                if (!organisms.isEmpty()) {
                    return (Animal) organisms.iterator().next();
                }
            }
        }
        return null;
    }
    public Organism findHerbivoreoinCell(Map<EnumList, Set<Organism>> residents){
        for(EnumList type: residents.keySet()){
            if(isHerbivoreType(type)){
                Set<Organism> organisms = residents.get(type);
                if(!organisms.isEmpty()){
                    return (Animal) organisms.iterator().next();
                }
            }
        }
        return null;
    }
    public Organism findGrassinCell(Map<EnumList, Set<Organism>> residents){
        for(EnumList type: residents.keySet()){
            if(isGrassType(type)){
                Set<Organism> organisms = residents.get(type);
                if(!organisms.isEmpty()){
                    return organisms.iterator().next();
                }
            }
        }
        return null;
    }

    public int countAnimalByType(EnumList animalType) {
        if (residents.containsKey(animalType)) {
            return residents.get(animalType).size();
        }
        return 0;
    }

    public int countHorse() {
        int total = 0;
        if (residents.containsKey(EnumList.HORSE)) {
            total += residents.get(EnumList.HORSE).size();

        }
        return total;
    }

    public int countBear() {
        int total = 0;
        if (residents.containsKey(EnumList.BEAR)) {
            total += residents.get(EnumList.BEAR).size();

        }
        return total;
    }
    public int countSheep() {
        int total = 0;
        if (residents.containsKey(EnumList.SHEEP)) {
            total += residents.get(SHEEP).size();

        }
        return total;
    }

    public int countGrass() {
        int totalGrass = 0;
        for (EnumList type : residents.keySet()) {
            if (type == EnumList.GRASS) {
                totalGrass += residents.get(type).size();
            }
        }
        return totalGrass;
    }

    public String display() {
        List<String> icons = new ArrayList<>();
        for (EnumList key : residents.keySet()) {
            if (key != null) {
                switch (key) {
                    case BEAR:
                        icons.add(Bear.ICON);
                        break;
                    case HORSE:
                        icons.add(Horse.ICON);
                        break;
                    case GRASS:
                        icons.add(Grass.ICON);
                        break;
                    case WOLF:
                        icons.add(Wolf.ICON);
                        break;
                    case SHEEP:
                        icons.add(Sheep.ICON);
                }
            }
        }


        return icons.get(ThreadLocalRandom.current().nextInt(icons.size()));
    }

    private boolean isPredatorType(EnumList type) {
        // Define which types are considered predators
        return type == EnumList.BEAR || type == EnumList.WOLF;  // Expand this list as needed
    }
    private boolean isHerbivoreType(EnumList type){
        return type == EnumList.HORSE || type == EnumList.SHEEP;
    }
    private boolean isGrassType(EnumList type){
        return type == EnumList.GRASS;
    }

    public Map<EnumList, Set<Organism>> getResidents() {
        return residents;
    }
}

