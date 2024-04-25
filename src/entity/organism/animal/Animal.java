package entity.organism.animal;

import abstraction.Eatable;
import abstraction.Movable;
import abstraction.Reproducible;
import entity.map.Cell;
import entity.map.GameField;
import entity.organism.Organism;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism implements Movable, Reproducible, Eatable, Runnable {
    protected int maxStep;
    protected float FULL_EAT;
    protected GameField field;

    public abstract Animal createNewAnimal();

    public abstract void eat(Organism herbivore, Cell cell);

    public void setField(GameField field) {
        this.field = field;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    public Animal(EnumList model) {
        super(model);
    }

    public void moveOrganism(Animal animal, int newX, int newY) {
        int oldX = animal.getX();
        int oldY = animal.getY();

        Cell oldCell = field.getCell(oldX, oldY);

        oldCell.removeOrganism(animal);

        Cell newCell = field.getCell(newX, newY);
        if (newCell != null) {
            newCell.addOrganism(animal);
        }
        animal.setX(newX);
        animal.setY(newY);
    }

    public void move() {
        int currentX = this.getX();
        int currentY = this.getY();

        int moveX = ThreadLocalRandom.current().nextInt(-maxStep, maxStep + 1);
        int moveY = ThreadLocalRandom.current().nextInt(-maxStep, maxStep + 1);

        if (moveX == 0 && moveY == 0) return;

        int newX = Math.max(0, Math.min(field.getWidth() - 1, currentX + moveX));
        int newY = Math.max(0, Math.min(field.getHeight() - 1, currentY + moveY));
        if(cellAmount > field.countAnimalInCell(newX, newY, this.getModel())) {
            moveOrganism(this, newX, newY);
            this.setX(newX);
            this.setY(newY);
            this.eat();
            this.reproduce(this);
        }
    }
    public void reproduce(Animal animal){
        int currentX = this.getX();
        int currentY = this.getY();

        Cell cell = field.getCell(currentX, currentY);
        if(cell.countAnimalByType(this.getModel()) > 1){
            Animal newAnimal = this.createNewAnimal();
            cell.addOrganism(newAnimal);
        }
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.move();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}


