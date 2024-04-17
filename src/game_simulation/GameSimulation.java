package game_simulation;

import entity.map.Cell;
import entity.map.GameField;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.*;
import entity.organism.animal.predator.*;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.Arrays;
import java.util.concurrent.*;

public class GameSimulation {
    private GameField field;
    private static CopyOnWriteArrayList<Animal> animalList;
    private ScheduledExecutorService executor;

    public GameField getField() {
        return field;
    }

    public GameSimulation() {
        field = new GameField(10, 10);
        field.initialize();
        animalList = new CopyOnWriteArrayList<>();
        fillFieldWithGrass();
        randomlyPlaceAnimals();
        //   field.displayField();
        executor = Executors.newScheduledThreadPool(1);
    }

    public static void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }

    private void fillFieldWithGrass() {
        for (int x = 0; x < field.getWidth(); x++) {
            for (int y = 0; y < field.getHeight(); y++) {
                Grass grass = new Grass(EnumList.GRASS);
                grass.setX(x);
                grass.setY(y);
                field.getCell(x, y).addOrganism(grass);
            }
        }
    }

    private void randomlyPlaceAnimals() {
        EnumList[] types = Arrays.stream(EnumList.values())
                .filter(type -> type != EnumList.GRASS)
                .toArray(EnumList[]::new);
        Organism organism;
        for (int i = 0; i < field.getWidth() * field.getHeight() * 5; i++) {

            EnumList randomType = types[ThreadLocalRandom.current().nextInt(types.length)];
            int x, y;
            Cell cell;
            x = ThreadLocalRandom.current().nextInt(field.getWidth());
            y = ThreadLocalRandom.current().nextInt(field.getHeight());
            cell = field.getCell(x, y);

            do {
                x = ThreadLocalRandom.current().nextInt(field.getWidth());
                y = ThreadLocalRandom.current().nextInt(field.getHeight());
                cell = field.getCell(x, y);
            } while (!(cell.getResidents().containsKey(EnumList.GRASS)));

            if (randomType == EnumList.BEAR) {
                organism = new Bear(EnumList.BEAR);
            } else if (randomType == EnumList.HORSE) {
                organism = new Horse(EnumList.HORSE);
            } else if (randomType == EnumList.WOLF) {
                organism = new Wolf(EnumList.WOLF);
            } else if (randomType == EnumList.SHEEP) {
                organism = new Sheep(EnumList.SHEEP);
            } else if (randomType == EnumList.BOA) {
                organism = new Boa(EnumList.BOA);
            } else if (randomType == EnumList.DUCK) {
                organism = new Duck(EnumList.DUCK);
            } else if (randomType == EnumList.MOUSE) {
                organism = new Mouse(EnumList.MOUSE);
            } else if (randomType == EnumList.RABBIT) {
                organism = new Rabbit(EnumList.RABBIT);
            } else if (randomType == EnumList.FOX) {
                organism = new Fox(EnumList.FOX);
            } else if (randomType == EnumList.EAGLE) {
                organism = new Eagle(EnumList.EAGLE);
            } else {
                continue;
            }

            organism.setX(x);
            organism.setY(y);
            cell.addOrganism(organism);

            if (organism instanceof Animal) {
                animalList.add((Animal) organism);
            }
        }
    }

    public void startSimulation() {
        for (Animal animal : animalList) {
            animal.setField(field);
            Thread animalThread = new Thread(animal);
            animalThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            field.print();
        }

    }

    public void stopSimulation() {
        executor.shutdownNow();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Some tasks are not finished yet");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

