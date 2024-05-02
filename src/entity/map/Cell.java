package entity.map;

import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.*;
import entity.organism.animal.predator.*;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import static enum_list.EnumList.*;



public class Cell {
    private final ConcurrentHashMap<EnumList, Set<Organism>> residents;
    private GameField field;


    public Cell(ConcurrentHashMap<EnumList, Set<Organism>> residents) {
        this.residents = residents;
    }

    public synchronized void addOrganism(Organism organism) {
        EnumList model = organism.getModel();
        Set<Organism> organisms = residents.computeIfAbsent(model, k -> new HashSet<>());
        organisms.add(organism);
    }

    public synchronized void removeOrganism(Organism organism) {
        EnumList type = organism.getModel();
        Set<Organism> organismsOfType = residents.get(type);

        if (organismsOfType != null) {
            organismsOfType.removeIf(o -> o.equals(organism));
            if (organismsOfType.isEmpty()) {
                residents.remove(type);
                if (residents.isEmpty()) {
                    addOrganism(new Grass(EnumList.GRASS));
                }
            }
        }
    }

    public Animal findPredatorInCell() {
        synchronized (this) {
            for (EnumList type : residents.keySet()) {
                if (isPredatorType(type)) {
                    Set<Organism> organisms = residents.get(type);
                    if (!organisms.isEmpty()) {
                        return (Animal) organisms.iterator().next();
                    }
                }
            }
        }
        return null;
    }

    public Animal findVictimInCell() {
        synchronized (this) {
            for (EnumList type : residents.keySet()) {
                if (isVictimType(type)) {
                    Set<Organism> organisms = residents.get(type);
                    if (!organisms.isEmpty()) {
                        return (Animal) organisms.iterator().next();
                    }
                }
            }
        }
        return null;
    }

    public Animal findHerbivoreInCell() {
        synchronized (this) {
            for (EnumList type : residents.keySet()) {
                if (isHerbivoreType(type)) {
                    Set<Organism> organisms = residents.get(type);
                    if (!organisms.isEmpty()) {
                        return (Animal) organisms.iterator().next();
                    }
                }
            }
        }
        return null;
    }

    public Organism findGrassinCell(Map<EnumList, Set<Organism>> residents) {
        synchronized (this) {
            for (EnumList type : residents.keySet()) {
                if (isGrassType(type)) {
                    Set<Organism> organisms = residents.get(type);
                    if (!organisms.isEmpty()) {
                        return organisms.iterator().next();
                    }
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


    public int countGrass() {
        int totalGrass = 0;
        for (EnumList type : residents.keySet()) {
            if (type == EnumList.GRASS) {
                totalGrass += residents.get(type).size();
            }
        }
        return totalGrass;
    }

    public int countAllAnimals() {
        int total = 0;
        for (Set<Organism> animalList : residents.values()) {
            total += animalList.size();
        }
        return total;
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
                    case BOA:
                        icons.add(Boa.ICON);
                    case MOUSE:
                        icons.add(Mouse.ICON);
                    case DUCK:
                        icons.add(Duck.ICON);
                    case RABBIT:
                        icons.add(Rabbit.ICON);
                    case FOX:
                        icons.add(Fox.ICON);
                    case EAGLE:
                        icons.add(Eagle.ICON);
                    case BOAR:
                        icons.add(Boar.ICON);
                    case DEER:
                        icons.add(Deer.ICON);
                    case BUFFALO:
                        icons.add(Buffalo.ICON);
                    case GOAT:
                        icons.add(Goat.ICON);
                }
            }
        }

        if (!icons.isEmpty()) {
            return icons.get(ThreadLocalRandom.current().nextInt(icons.size()));
        } else {
            return null;
        }
    }

    private boolean isPredatorType(EnumList type) {
        return type.isPredator();
    }

    private boolean isVictimType(EnumList type) {
        return type.isVictimType();
    }

    private boolean isHerbivoreType(EnumList type) {
        return type.isHerbivoreType();
    }

    private boolean isGrassType(EnumList type) {
        return type == EnumList.GRASS;
    }

    public Map<EnumList, Set<Organism>> getResidents() {
        return residents;
    }
}