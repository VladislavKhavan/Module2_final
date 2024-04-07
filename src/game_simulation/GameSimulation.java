package game_simulation;

import entity.map.Cell;
import entity.map.GameField;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import entity.organism.plant.Grass;
import enum_list.EnumList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class GameSimulation {
    private GameField field;
    private List<Animal> animalList;
    private ScheduledExecutorService executor;

    public GameField getField() {
        return field;
    }

    public GameSimulation() {
        field = new GameField(10, 10);
        field.initialize();
        animalList = new ArrayList<>();
        fillFieldWithGrass();
        randomlyPlaceAnimals();
        field.displayField();
        executor = Executors.newScheduledThreadPool(1);
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
        EnumList[] types = EnumList.values();
        Organism organism;

        for (int i = 0; i < field.getWidth() * field.getHeight(); i++) {
            EnumList randomType = types[ThreadLocalRandom.current().nextInt(types.length)];
            int x, y;
            Cell cell;

            do {
                x = ThreadLocalRandom.current().nextInt(field.getWidth());
                y = ThreadLocalRandom.current().nextInt(field.getHeight());
                cell = field.getCell(x, y);
            } while (!(cell.getResidents().size() == 1 && cell.getResidents().containsKey(EnumList.GRASS)));
            if (randomType == EnumList.BEAR) {
                organism = new Bear(EnumList.BEAR);
            } else if (randomType == EnumList.HORSE) {
                organism = new Horse(EnumList.HORSE);
            } else {
                continue;
            }

            organism.setX(x);
            organism.setY(y);
            cell.removeOrganism(cell.getResidents().get(EnumList.GRASS).iterator().next());
            cell.addOrganism(organism);

            if (organism instanceof Animal) {
                animalList.add((Animal) organism);
            }
        }
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(() ->{
            for(Animal animal: animalList){
                animal.setField(field);
                animal.move();
                animal.eat();
            }
            System.out.println("New field after iteration");
            field.print();

        }, 0, 1, TimeUnit.SECONDS);
        executor.schedule(this:: stopSimulation, 10, TimeUnit.SECONDS);
    }


    public void stopSimulation() {
        executor.shutdownNow();
        try {
            if(!executor.awaitTermination(1, TimeUnit.SECONDS)){
                System.out.println("Some tasks are not finished yet");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


